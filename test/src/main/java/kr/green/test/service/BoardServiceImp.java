package kr.green.test.service;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.test.dao.BoardDAO;
import kr.green.test.utils.UploadFileUtils;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.FileVO;
import kr.green.test.vo.MemberVO;
import lombok.AllArgsConstructor;

@Service

public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	private String uploadPath = "/Users/main/Documents/Java_KMS/uploadfiles";

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public BoardVO getBoard(Integer num) {
		if(num == null)
			return null;
		
		return boardDao.selectBoard(num);
	}

	@Override
	public void insertBoard(BoardVO board, MultipartFile[] fileList, MemberVO user) throws Exception {
		if(board == null || user == null)
			return;
		
		board.setWriter(user.getId());
		board.setGroupOrd(0);
		boardDao.insertBoard(board);
		
		
		if(fileList == null)
			return;
		int size = fileList.length < 3 ? fileList.length : 3;
		for(int i = 0; i<size; i++) {
			MultipartFile tmp = fileList[i];
			if(tmp == null || tmp.getOriginalFilename().length() == 0) {
				continue;
			}
			String name = UploadFileUtils.uploadFile(uploadPath, tmp.getOriginalFilename(), tmp.getBytes());
			FileVO file = new FileVO(board.getNum(),name,tmp.getOriginalFilename());
			boardDao.insertFile(file);
		}
	}

	@Override
	public void insertReplyBoard(BoardVO board, MemberVO user) {
		if(board == null || user == null)
			return;
		
		board.setWriter(user.getId());
		// 게시글 가져와서  답변달기 하면 자동으로 문의글 내용을 제목으로 지정하기
		BoardVO dbBoard = boardDao.selectBoard(board.getOriNo());
		if(dbBoard == null)
			return;
		board.setTitle(dbBoard.getTitle());
		boardDao.insertBoard(board);
		
		
	}

	@Override
	public void updateBoard(BoardVO board, MemberVO user) {
		if(user == null || board == null)
			return;
		
		BoardVO dbBoard = boardDao.selectBoard(board.getNum());
		
		if(dbBoard == null || !user.getId().equals(dbBoard.getWriter()))
			return;
		
		dbBoard.setTitle(board.getTitle());
		dbBoard.setContents(board.getContents());
		boardDao.updateBoard(dbBoard);
		
	}

	@Override
	public void deleteBoard(Integer num, MemberVO user) {
		if(num == null || user == null)
			return;
		
		BoardVO board = boardDao.selectBoard(num);
		
		if(board == null || !board.getWriter().equals(user.getId()))
			return;
		
		boardDao.deleteBoard(num);
		boardDao.deleteReplyBoard(num);
		
	}
	
}
