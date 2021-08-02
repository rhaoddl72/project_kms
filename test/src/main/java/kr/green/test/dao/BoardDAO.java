package kr.green.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList();

	BoardVO selectBoard(Integer num);

	void insertBoard(@Param("board")BoardVO board);

	void updateBoard(BoardVO dbBoard);

	void deleteBoard(Integer num);

	void deleteReplyBoard(Integer num);

}
