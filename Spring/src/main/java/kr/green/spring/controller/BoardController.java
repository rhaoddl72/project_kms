package kr.green.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jdk.internal.org.jline.utils.Log;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.service.MemberService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
//	로그인해서 글쓰기하기 위해 추가
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/board/list")
	public ModelAndView boardList(ModelAndView mv, Criteria cri) {
		PageMaker pm = new PageMaker();
		cri.setPerPageNum(2);
		pm.setCriteria(cri);
		pm.setDisplayPageNum(2);
//		검색 기능할 때 cri정보가 필요하다.
		int totalCount = boardService.getTotalCount(cri);
		pm.setTotalCount(totalCount);
		pm.calcData();
		
		//서비스에게 모든 게시글을 가져오라고 시킴
		// BoardVO에서 하나의 게시글을 담을 수 있으니까 여러개를 담을수있도록 ArrayList사용
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		
		//화면에 모든 게시글을 전송
		mv.addObject("list",list);
		mv.addObject("pm", pm);
		mv.setViewName("board/list");
		return mv;
	}
	
	
	@RequestMapping(value="/board/detail")
//	Integer는 링크 뒤에 ?num값이 없어도(null이들어감) 에러가 안나지만 int는 숫자만되기때문에 에러난다.
	public ModelAndView boardDetail(ModelAndView mv, Integer num) {
		
		//게시글을 가져오기 전 조회수를 증가
		//서비스에게 게시글 번호를 주면서 게시글 조회수를 1증가시키라고 시킨다.
		boardService.updateViews(num);
		
		
		//서비스에게 번호를 주면서 게시글을 가져오라고 시킨다.
		//num(기본키)으로 가져오니까 하나씩만 가져온다. 그래서 BoardVO사용	
		BoardVO board = boardService.getBoard(num);
		
		// 가져온 게시글을 화면에 전달, 이름은 board
		mv.addObject("board",board);
		mv.setViewName("board/detail");
		return mv;
	}
	

	@RequestMapping(value="/board/register", method = RequestMethod.GET)

	public ModelAndView boardRegisterGet(ModelAndView mv) {
		
		mv.setViewName("board/register");
		return mv;
	}
	
	
//	게시글을 작성할 때 get으로하면 url주소가 너무 길어지기 때문에 post를 이용하는게 좋다.
//	그래서 등록은 post로 한다.
	@RequestMapping(value="/board/register", method = RequestMethod.POST)
//  BoardVO의 멤버변수 이름과 jsp의 name명을 맞춰줬기 때문에 이렇게 쓸 수 있다.
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		
		MemberVO user = memberService.getMember(request);
		
		// user에서 아이디 가져와서 writer부분에 넣어주기
		board.setWriter(user.getId());
		
		//화면에서 보내준 제목, 작성자, 내용을 받아서 콘솔에 출력
		//System.out.println(board);
		
		//서비스에게 게시글 정보(제목,작성자,내용)을 주면서 게시글을 등록하라고 시킨다.
		boardService.insertBoard(board);
		
		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	
	@RequestMapping(value="/board/modify", method = RequestMethod.GET)

	public ModelAndView boardModifyGet(ModelAndView mv, Integer num, HttpServletRequest request) {
		
		BoardVO board = boardService.getBoard(num);

		mv.addObject("board",board);
		mv.setViewName("board/modify");
		
		MemberVO user = memberService.getMember(request);
		if(board == null || !board.getWriter().equals(user.getId())) {
			mv.setViewName("redirect:/board/list");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/board/modify", method = RequestMethod.POST)

	public ModelAndView boardModifyPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		
		
		//detail로 이동
//		detail값 가져가기전에 num값도 같이 보내준다.
		mv.addObject("num",board.getNum());
		mv.setViewName("redirect:/board/detail");
		
		MemberVO user = memberService.getMember(request);
		if(!user.getId().equals(board.getWriter())) {
			mv.setViewName("redirect:/board/list");
		}else {
			
			//서비스에게 게시글을 주면서 수정하라고 요청
			//이부분이 밑에 와야한다. 위에있으면 작성자랑 수정하는 아이디가 달라도 
			//수정을 해버리고 redirect가 실행되기 때문에 밑에부분에 넣어줘야한다.
			boardService.updateBoard(board);
		}
		return mv;
	}
	
	
	@RequestMapping(value="/board/delete")

	public ModelAndView boardDelete(ModelAndView mv, Integer num, HttpServletRequest request) {
		
		// service한테 전달해서 알아서 하라고하는게 편해서 서비스로 넘김
		MemberVO user = memberService.getMember(request);
		
		//서비스에게 게시글 번호를 주면서 삭제하라고 요청
		//추가로 유저정보 넘겨주기
		boardService.deleteBoard(num, user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}

	
}