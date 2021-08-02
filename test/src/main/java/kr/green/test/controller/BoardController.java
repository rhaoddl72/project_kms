package kr.green.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
import kr.green.test.service.BoardService;
import kr.green.test.service.MemberService;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.FileVO;
import kr.green.test.vo.MemberVO;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	private BoardService boardService;
	
	// 등록할 때 작성자 정보가져오기 위해 httpservletrequest의 세션을 가져올 수 있다.
	private MemberService memberService;
	
	@GetMapping("/list")
	public ModelAndView listGet(ModelAndView mv, Criteria cri) {
		
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount,10,cri);
		
		mv.addObject("pm",pm);
		mv.addObject("list",list);
		mv.setViewName("/template/board/list");
		return mv;
	}
	
	@GetMapping("/detail")
	public ModelAndView detailGet(ModelAndView mv, Integer num) {
	
		boardService.updateViews(num);
		BoardVO board = boardService.getBoard(num);
		
		ArrayList<FileVO> fList = boardService.getFileList(num);
		
		mv.addObject("board",board);
		mv.addObject("fList",fList);
		mv.setViewName("/template/board/detail");
		return mv;
	}
	
	@GetMapping("/register")
	public ModelAndView registerGet(ModelAndView mv) {
		mv.setViewName("/template/board/register");
		return mv;
	}
	
	@PostMapping("/register")
	public ModelAndView registerPost(ModelAndView mv, BoardVO board, MultipartFile [] fileList, HttpServletRequest request) throws Exception {
		//로그인한 회원정보 가져옴
		MemberVO user = memberService.getMemberByRequest(request);
		board.setType("NORMAL");
		
		boardService.insertBoard(board, fileList, user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@GetMapping("/reply/register")
	public ModelAndView replyRegisterGet(ModelAndView mv, Integer oriNo) {
		
		
		mv.addObject("oriNo",oriNo);
		mv.setViewName("/template/board/replyregister");
		return mv;
	}
	
	@PostMapping("/reply/register")
	public ModelAndView replyRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		
		//로그인한 회원정보 가져옴
		MemberVO user = memberService.getMemberByRequest(request);
		board.setType("NORMAL");
		boardService.insertReplyBoard(board,user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@GetMapping("/modify")
	public ModelAndView ModifyGet(ModelAndView mv, Integer num) {
		
		BoardVO board = boardService.getBoard(num);
		ArrayList<FileVO> fList = boardService.getFileList(num);
		
		
		mv.addObject("board",board);
		mv.addObject("fList",fList);
		mv.setViewName("/template/board/modify");
		return mv;
	}
	
	
	@PostMapping("/modify")
	public ModelAndView ModifyPost(ModelAndView mv, BoardVO board, HttpServletRequest request,
			MultipartFile[] fileList, Integer[] fileNumList) throws Exception {
		
		MemberVO user = memberService.getMemberByRequest(request);
		
		boardService.updateBoard(board,user,fileList,fileNumList);
		
		mv.addObject("num",board.getNum());
		mv.setViewName("redirect:/board/detail");
		return mv;
	}

	@GetMapping("/delete")
	public ModelAndView deleteGet(ModelAndView mv, Integer num, HttpServletRequest request) {
		
		MemberVO user = memberService.getMemberByRequest(request);
		boardService.deleteBoard(num,user);
		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@ResponseBody
	@GetMapping("/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	   
	    return boardService.downloadFile(fileName);
	}


	
}
