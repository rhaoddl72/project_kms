package kr.green.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.FileVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList(Criteria cri);

	BoardVO selectBoard(Integer num);

	void insertBoard(@Param("board")BoardVO board);

	void updateBoard(BoardVO dbBoard);

	void deleteBoard(Integer num);

	void deleteReplyBoard(Integer num);

	void insertFile(FileVO file);

	void updateViews(Integer num);

	ArrayList<FileVO> selectFileList(Integer num);

	void deleteFile(int num);

	ArrayList<Integer> selectFileNumList(int num);

	FileVO selectFile(Integer tmp);

	int getTotalCount(Criteria cri);

	FileVO selectThumbnail(int num);

}
