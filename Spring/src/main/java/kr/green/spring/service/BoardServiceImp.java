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
	

	@Override
	public void insertBoard(BoardVO board) {
		//dao에게 게시글 정보를 주면서 게시글을 등록하라고 시킨다.
		boardDao.insertBoard(board);
		
	}

	@Override
	public int updateViews(Integer num) {
		//dao에게 게시글 번호를 주고 게시글을 가져오라고 시킨다.
		BoardVO board = boardDao.getBoard(num);
		//가져온 게시글이 있으면 가져온 게시글의 조회수를 1증가 시킨다.
		if(board != null) {
			board.setViews(board.getViews()+1);
			
		//dao에게 게시글을 주면서 게시글을 수정하라고 요청한다.
		return boardDao.updateBoard(board);
		}
		
		return 0;
	}

	@Override
	public int updateBoard(BoardVO board) {
		if(board == null) {
			return 0;
		}
		
		if(board.getValid() == null) {
		board.setValid("I");
		}
		return boardDao.updateBoard(board);
	}

	@Override
	public int deleteBoard(Integer num) {
		// dao에게 게시글 번호를 주면서 가져오라고 시킨다.
		BoardVO board = boardDao.getBoard(num);
		if(board == null) {
			return 0;
		}
		// 가져온 게시글의 valid값을 D로 수정
		board.setValid("D");
		// dao에게 게시글 정보를 주면서 수정하라고 시킨 후 정수값을 리턴
		return boardDao.updateBoard(board);
	}
}
