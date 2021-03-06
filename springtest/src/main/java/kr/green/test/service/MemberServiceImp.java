package kr.green.test.service;

import java.util.Date;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.test.dao.MemberDAO;
import kr.green.test.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	 @Autowired
	    MemberDAO memberDao;
	 
	 @Autowired
	 private JavaMailSender mailSender;

	 
	 @Autowired
	 	BCryptPasswordEncoder passwordEncoder;

	@Override
	public void signup(MemberVO user) {
		if(user == null) {
			return;
		}
		//필수 항목 체크
//		||는 앞에가 참이면 뒤에 조건은 보지않고 그냥 실행문을 실행한다.
//		그래서 뒤에 getId.trim()을 하면 null인데 trim메소드를 실행시키려하니 
//		오류(nullpointException)가떠야하는데 user.getId()가 null이므로
//		정상 실행이 된다.
		
//		user.getId() == null을 해줘야하는 이유는 객체를 초기화하면 각 멤버변수에
//		String은 null, int는 0으로 빈값이 들어가는데 user.getId() == null
//		처리를 해주지 않으면 오류(nullpointException)가 발생하기 때문에
//		안정성을 위해 해줘야한다.
		if( user.getId() == null || user.getId().trim().length() == 0 || 
			user.getPw() == null ||user.getPw().trim().length() == 0 ||
			user.getName() == null ||user.getName().trim().length() == 0 ||
			user.getEmail() == null ||user.getEmail().trim().length() == 0 ) {
			return;
		}
		//정규표현식 체크해야 하는데 나중에 할 예정
		
		//암호화
		String ePw = passwordEncoder.encode(user.getPw());
		user.setPw(ePw);
		
		//회원가입
		memberDao.insertMember(user);
	}

	@Override
	public MemberVO signin(MemberVO user) {
		if(user == null || user.getId() == null || user.getId().trim().length() == 0
		   || user.getPw() == null || user.getPw().trim().length() == 0) {
			
			return null;
		}
		MemberVO dbUser = memberDao.getMember(user.getId());
		if(dbUser == null) {
			return null;
		}
		if(passwordEncoder.matches(user.getPw(), dbUser.getPw())){
			dbUser.setUseCookie(user.getUseCookie());
			return dbUser;
		}
		return null;
	}

	@Override
	public MemberVO getMember(HttpServletRequest r) {
		if(r == null || r.getSession() == null)
		return null;
		
		return (MemberVO)r.getSession().getAttribute("user");
	}

	@Override
	public MemberVO updateMember(MemberVO user) {
		
		if(user == null) {
			return null;
		}
		
		MemberVO updateUser = memberDao.getMember(user.getId());
		
		if(updateUser == null) {
			return null;
		}
		
		updateUser.setGender(user.getGender());
		updateUser.setEmail(user.getEmail());
		updateUser.setName(user.getName());
		
		if(user.getPw() != null && !user.getPw().equals("")) {
			String pw2 = passwordEncoder.encode(user.getPw());
			updateUser.setPw(pw2);
		}
		
		if(memberDao.updateMember(updateUser) == 0) {
			return null;
		};
		
		return updateUser;
	}

	@Override
	public boolean idCheck(String id) {
		if(id == null || id.length() == 0)
			return false;
		return memberDao.getMember(id) == null ? true : false;
	}

	@Override
	public void keepLogin(String id, String session_id, Date session_limit) {
		if(id == null || session_id == null || session_limit == null) {
			return;
		}
		memberDao.keepLogin(id, session_id, session_limit);
		
	}

	@Override
	public MemberVO checkLoginBefore(String session_id) {
		if(session_id == null) {
			return null;			
		}
		
		return memberDao.getMemberSession(session_id);
	}

	@Override
	public String findPw(String id) {
		if(id == null) {
			return "FAIL";
		}
		
		MemberVO user = memberDao.getMember(id);
		
		if(user == null) {
			return "FAIL";
		}
		// 비밀번호 8자리 랜덤 생성
		String newPW = newRandomPw(8);
		// 비밀번호를 변경
		user.setPw(newPW);
		updateMember(user);
		// 새 비밀번호를 메일로 전송
		try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom("rhaoddl72@gmail.com");  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(user.getEmail());     // 받는사람 이메일
	        messageHelper.setSubject("새 비밀번호입니다."); // 메일제목은 생략이 가능하다
	        messageHelper.setText("","발급된 새 비밀번호는 <h3>" + newPW + "입니다.");  // 메일 내용

	        mailSender.send(message);
	        return "SUCCESS";
	        
	    } catch(Exception e){
	        System.out.println(e);
	    }

		return "FAIL";
	}
	
	private String newRandomPw(int size) {
		int min = 0, max = 61;
		String str = "";
		for(int i = 0; i<size; i++) {
			int r = (int)(Math.random()*(max - min +1) + min);
			if(r <= 10)
				str += r;
			else if(r < 36)
				str += (char) ('a' + (r - 10));
			else if(r < 62)
				str += (char) ('A' + (r-36));
		}
		return str;
	}



}
