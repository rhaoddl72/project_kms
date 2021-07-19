package kr.green.test.service;

import java.io.File;
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
			
			insertFile(file, board.getNum());
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
		
		if(board == null || board.getNum() <= 0) {
			return 0;
		}
		if(user ==  null || !user.getId().equals(board.getWriter())) {
	
			return -1;
		}
		
		board.setValid("D");
		
		//게시글에 있는 첨부파일 가져오기
		ArrayList<FileVO> fileList = boardDao.getFileList(num);

		//첨부 파일을 반복문을 이용하여 하나씩 삭제 처리(이때, 서버에 있는 파일을 삭제)
		if(fileList != null && fileList.size() != 0) {
			for(FileVO tmp : fileList) {
				
				deleteFile(tmp);
				
			}
		}
		
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

	@Override
	public ResponseEntity<byte[]> downloadFile(String fileName) throws Exception {
		
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		
	    try{
	        
	        HttpHeaders headers = new HttpHeaders();
	        
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;

	}

	
	private void deleteFile(FileVO file) {
		File tmp = new File(uploadPath+file.getName());
		if(tmp.exists()) {
			//서버에 있는 파일을 삭제
			tmp.delete();
		}
		// DOA에게 DB에 첨부파일 정보를 삭제 처리 시킴
		boardDao.deleteFile(file.getNum());
		
	}
	
	// insert도 메소드로 만들어줌
	private void insertFile(MultipartFile file, int num) {
		if(file != null && file.getOriginalFilename().length() != 0) {
			
			try {
				// 첨부 파일을 업로드 한 후 경로를 반환해서 ori_name에 저장
				String name = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				
				//첨부파일 객체 생성
				FileVO fvo = new FileVO(num,name,file.getOriginalFilename());
				
				// DB에 첨부파일 정보 추가
				boardDao.insertFile(fvo);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
