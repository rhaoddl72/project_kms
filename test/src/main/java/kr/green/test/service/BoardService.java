package kr.green.test.service;

import java.io.IOException;
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

	void insertBoard(BoardVO board, MultipartFile[] fileList, MemberVO user) throws Exception;

	void insertReplyBoard(BoardVO board, MemberVO user);

	void updateBoard(BoardVO board, MemberVO user, MultipartFile[] fileList, Integer[] fileNumList) throws Exception;

	void deleteBoard(Integer num, MemberVO user);

	void updateViews(Integer num);

	ArrayList<FileVO> getFileList(Integer num);

	ResponseEntity<byte[]> downloadFile(String fileName) throws IOException;

	int getTotalCount(Criteria cri);

	void insertBoard(BoardVO board, MultipartFile[] fileList, MemberVO user, MultipartFile mainImage) throws Exception;

	void getThumbnail(ArrayList<BoardVO> list);

	void updateBoard(BoardVO board, MemberVO user, MultipartFile[] fileList, Integer[] fileNumList,
			MultipartFile mainImage, Integer thumbnailNo) throws Exception;

	boolean checkBoardPw(BoardVO tmpBoard);

}
