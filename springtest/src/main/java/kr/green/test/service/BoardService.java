package kr.green.test.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.FileVO;
import kr.green.test.vo.MemberVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer num);

	int updateViews(Integer num);

	void insertBoard(BoardVO board, MemberVO user, MultipartFile[] files);

	int updateBoard(BoardVO board, MemberVO user);

	int deleteBoard(Integer num, MemberVO user);

	int getTotalCount(Criteria cri);

	ArrayList<FileVO> getFileList(Integer num);

	ResponseEntity<byte[]> downloadFile(String fileName) throws Exception;

}
