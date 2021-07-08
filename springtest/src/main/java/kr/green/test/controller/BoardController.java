package kr.green.test.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.BoardService;
import kr.green.test.vo.BoardVO;
import lombok.extern.log4j.Log4j;

//오류 찾아내기

@Log4j
@Controller
// board로 시작하는 url을 다 여기서 처리한다는 의미
@RequestMapping(value = "/board/*")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	//위에 value board/*해줘서 board는 생략한다.
	@RequestMapping(value = "/list")
	public ModelAndView List(ModelAndView mv) {
		ArrayList<BoardVO> list = boardService.getBoardList();
		
		mv.addObject("list",list);
		mv.setViewName("board/list");
		return mv;
	}
	
	
	@RequestMapping(value = "/detail")
	public ModelAndView Detail(ModelAndView mv, Integer num) {
		//볼때마다 조회수 1씩 증가시키기
		boardService.updateViews(num);
		
		BoardVO board = boardService.getBoard(num);
		//어떠한 컨트롤러 클래스에서 테스트하는지 확인할 수 있는 오류찾기 방법
		//log.info("test");
		
		
		mv.addObject("board",board);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView RegisterGet(ModelAndView mv) {
		
		
		mv.setViewName("board/register");
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView RegisterPost(ModelAndView mv, BoardVO board) {
		
		boardService.insertBoard(board);
		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
}
