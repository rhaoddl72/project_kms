package kr.green.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.getBoardList();
	}

	@Override
	public BoardVO getBoard(Integer num) {
		//num가 null인지 확인하여 null이면 null을 반환
		if(num == null) {
			
			return null;
		}
		//dao에게 게시글 번호를 주면서 게시글을 가져오라고 시킨다.
		BoardVO board = boardDao.getBoard(num);
		
		// 가져온 게시글을 전달. 이때 가져온 게시글은 없을 수도 있다.(null들어갈 수도있다.)
		// ex) 게시글은 1,2번만있는데 num이 3일 때 
		return board;
		
		//위에 두줄하고 같음
		//return boardDao.getBoard(num);
	}
}
