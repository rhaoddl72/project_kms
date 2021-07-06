package kr.green.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/list")
	public ModelAndView boardList(ModelAndView mv) {
		
		//서비스에게 모든 게시글을 가져오라고 시킴
		// BoardVO에서 하나의 게시글을 담을 수 있으니까 여러개를 담을수있도록 ArrayList사용
		ArrayList<BoardVO> list = boardService.getBoardList();
		
		//화면에 모든 게시글을 전송
		mv.addObject("list",list);
		
		//리스트가 비어있지않다면 리스트 출력해주기
		if(list != null) {
			for(BoardVO tmp : list) {
				System.out.println(tmp);
			}
		}
		
		mv.setViewName("board/list");
		return mv;
	}

	
}
