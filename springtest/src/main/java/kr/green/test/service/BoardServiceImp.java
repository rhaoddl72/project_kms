package kr.green.test.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.print.DocFlavor.INPUT_STREAM;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.test.dao.BoardDAO;
import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.FileVO;
import kr.green.test.vo.MemberVO;
import utils.UploadFileUtils;


@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;
	
	private String uploadPath = "D:\\java_kMS\\uploadfiles";

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVO getBoard(Integer num) {
//		if(num == null) {
//			return null;
//		}
//		return boardDao.getBoard(num);
		
		return num == null ? null : boardDao.getBoard(num);
	}

	@Override
	public int updateViews(Integer num) {
		//게시글 정보를 가져오라고 dao에게 시킨다.
		BoardVO board = boardDao.getBoard(num);
		if(board == null) {
			return 0;
		}
			
		board.setViews(board.getViews()+1);
		return boardDao.updateBoard(board);
		
	}

	@Override
	public void insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		
		
		
		if(board == null || board.getTitle().trim().length() == 0) {
			return;
		}
		if(user == null || user.getId() == null || user.getId().trim().length() == 0) {
			return;
		}
		
		board.setWriter(user.getId());
		boardDao.insertBoard(board);
		
		//첨부파일 추가
		if(files == null || files.length == 0) {
			return;
		}
		for(MultipartFile file : files) {
			if(file != null && file.getOriginalFilename().length() != 0) {
				
				try {
					// 첨부 파일을 업로드 한 후 경로를 반환해서 ori_name에 저장
					String name = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
					
					//첨부파일 객체 생성
					FileVO fvo = new FileVO(board.getNum(),name,file.getOriginalFilename());
					
					// DB에 첨부파일 정보 추가
					boardDao.insertFile(fvo);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
		
		
	}
	
	@Override
	public int updateBoard(BoardVO board, MemberVO user) {
		if(board == null) {
			return 0;
		}
		if(user == null) {
			return -1;
		}
		
		BoardVO dbBoard = boardDao.getBoard(board.getNum());
		if(!user.getId().equals(dbBoard.getWriter())) {
			return -1;
		}
		
		dbBoard.setContents(board.getContents());
		dbBoard.setTitle(board.getTitle());
		
		return boardDao.updateBoard(dbBoard);
	}

	@Override
	public int deleteBoard(Integer num, MemberVO user) {
		if(num == null) {
			
			return 0;
		}
		BoardVO board = boardDao.getBoard(num);
		
		if(board == null) {
			return 0;
		}
		if(user ==  null || !user.getId().equals(board.getWriter())) {
	
			return -1;
		}
		
		board.setValid("D");
		
		return boardDao.updateBoard(board);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		
		return boardDao.getTotalCount(cri);
	}

	@Override
	public ArrayList<FileVO> getFileList(Integer num) {
		
		if(num == null) {
			return null;
		}
		
		return boardDao.getFileList(num);
	}

	
	
}
