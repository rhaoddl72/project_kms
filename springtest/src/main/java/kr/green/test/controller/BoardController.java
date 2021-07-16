package kr.green.test.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.pagination.*;
import kr.green.test.service.*;
import kr.green.test.vo.*;
import lombok.extern.log4j.Log4j;

//오류 찾아내기

@Log4j
@Controller
// board로 시작하는 url을 다 여기서 처리한다는 의미
@RequestMapping(value = "/board/*")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	MemberService memberService;
	
	//위에 value board/*해줘서 board는 생략한다.
	@RequestMapping(value = "/list")
	public ModelAndView List(ModelAndView mv, String msg, Criteria cri) {
		cri.setPerPageNum(2);
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		//현재 페이지 정보(검색타입, 검색어)에 대한 총 게시글 수를 가져와야한다.
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 2, cri);
		
		
		mv.addObject("pm",pm);
		mv.addObject("list",list);
		mv.addObject("msg",msg);
		mv.setViewName("/template/board/list");
		return mv;
	}
	
	
	@RequestMapping(value = "/detail")
	public ModelAndView Detail(ModelAndView mv, Integer num, String msg) {
		//볼때마다 조회수 1씩 증가시키기
		boardService.updateViews(num);
		
		mv.addObject("msg",msg);
		BoardVO board = boardService.getBoard(num);
		//어떠한 컨트롤러 클래스에서 테스트하는지 확인할 수 있는 오류찾기 방법
		//log.info("test");
		
		
		mv.addObject("board",board);
		
		//첨부파일 가져오기
		ArrayList<FileVO> fileList = boardService.getFileList(num);
		mv.addObject("fileList",fileList);
		
		mv.setViewName("/template/board/detail");
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView RegisterGet(ModelAndView mv) {
		
		
		mv.setViewName("/template/board/register");
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView RegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest r, MultipartFile[] files) {
		
		MemberVO user = memberService.getMember(r);
		boardService.insertBoard(board, user, files);
		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView ModifyGet(ModelAndView mv, Integer num, HttpServletRequest r) {
		
		BoardVO board = boardService.getBoard(num);
		
		mv.addObject("board",board);
		mv.setViewName("/template/board/modify");
		
		MemberVO user = memberService.getMember(r);
		if(board == null || !board.getWriter().equals(user.getId())) {
			
			mv.setViewName("redirect:/board/list");
		}
		return mv;
	}
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView ModifyPost(ModelAndView mv, BoardVO board, HttpServletRequest r) {
		
		
			
		mv.addObject("num",board.getNum());
		mv.setViewName("redirect:/board/detail");
		String msg = "";
		
		MemberVO user = memberService.getMember(r);
			
		int res = boardService.updateBoard(board,user);
			
			if(res == 1) {
				msg = board.getNum()+"번 게시글이 수정되었습니다.";
			}
			else if(res == 0){
				msg = "없는 게시물입니다.";
			}
			else if(res == -1) {
				msg = "잘못된 접근입니다.";
				mv.setViewName("redirect:/board/list");
			}
			mv.addObject("msg",msg);
		
		
		return mv;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deletePost(ModelAndView mv, Integer num, HttpServletRequest r) {
		
		MemberVO user = memberService.getMember(r);
		
		int res = boardService.deleteBoard(num, user);
		
		
		//화면에 창띄우기
		if(res == 1) {
			mv.addObject("msg",num+"번 게시글을 삭제 했습니다.");
		}else if(res == 0) {
			mv.addObject("msg","게시글이 없거나 이미 삭제 되었습니다.");
		}else if(res == -1) {
			mv.addObject("msg","잘못된 접근입니다.");
		}
		
		
		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName) throws Exception {
		
		ResponseEntity<byte[]> entity = boardService.downloadFile(fileName);
		
		return entity;
	}
	
	
}
