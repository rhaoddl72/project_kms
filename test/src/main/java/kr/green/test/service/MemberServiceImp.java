package kr.green.test.service;

import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import kr.green.test.dao.MemberDAO;
import kr.green.test.vo.MemberVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImp implements MemberService {
	
	MemberDAO memberDao;
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(MemberVO user) {
		
		if(user == null)
			return false;
		
		//아이디 유효성 검사
		String idRegex = "^[a-z0-9_-]{5,20}$";
		if(user.getId() == null || !Pattern.matches(idRegex, user.getId()) )
			return false;
		
		//비밀번호 유효성 검사
		String pwRegex = "^[a-z0-9!@#]{8,16}$";
		if(user.getId() == null || !Pattern.matches(pwRegex, user.getPw()) )
			return false;
		
		//이메일 유효성 검사, xx@yy.zz or xx@yy.zz.cc
		String emailRegex = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		if(user.getEmail() == null || !Pattern.matches(emailRegex, user.getEmail()))
			return false;
		
		//이름 유효성 검사
		if(user.getName() == null || user.getName().trim().length() == 0) 
		
		//성별 유효성 검사
		if(user.getGender() == null)
			return false;
		
		//비밀번호 암호화
		String ecnPw = passwordEncoder.encode(user.getPw());
		user.setPw(ecnPw);
		memberDao.insertMember(user);
		
		return true;
	}

	@Override
	public MemberVO signin(MemberVO user) {
		if(user == null || user.getId() == null)
			return null;
	
		MemberVO dbUser = memberDao.selectUser(user.getId());
		
		//잘못된 ID == 회원 아님
		if(dbUser == null)
			return null;
		
		//잘못된 비번
		if(user.getPw() == null || !passwordEncoder.matches(user.getPw(), dbUser.getPw()))
			return null;
		
		//자동 로그인 기능을 위해
		dbUser.setUseCookie(user.getUseCookie());
		return dbUser;
	}

	@Override
	public Object getMember(String id) {
		if(id == null)
			return null;
		return memberDao.selectUser(id);
	}
}