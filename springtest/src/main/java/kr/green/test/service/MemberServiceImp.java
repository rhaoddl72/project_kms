package kr.green.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.test.dao.MemberDAO;
import kr.green.test.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	 @Autowired
	    MemberDAO memberDao;
	 
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

	    
	   

		


}
