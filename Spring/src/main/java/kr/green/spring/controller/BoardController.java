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
				//System.out.println(tmp);
			}
		}
		
		mv.setViewName("board/list");
		return mv;
	}
	
	
	@RequestMapping(value="/board/detail")
//	Integer는 링크 뒤에 ?num값이 없어도(null이들어감) 에러가 안나지만 int는 숫자만되기때문에 에러난다.
	public ModelAndView boardDetail(ModelAndView mv, Integer num) {
		
		//서비스에게 번호를 주면서 게시글을 가져오라고 시킨다.
		//num(기본키)으로 가져오니까 하나씩만 가져온다. 그래서 BoardVO사용	
		BoardVO board = boardService.getBoard(num);
		
		// 가져온 게시글을 화면에 전달, 이름은 board
		mv.addObject("board",board);
		mv.setViewName("board/detail");
		return mv;
	}

	
}
