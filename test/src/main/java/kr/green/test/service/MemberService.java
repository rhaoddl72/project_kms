package kr.green.test.service;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO user);

	MemberVO signin(MemberVO user);

	Object getMember(String id);

	void signout(HttpServletRequest request, HttpServletResponse response);

	void keepLogin(String id, String id2, Date date);
	
	MemberVO getMemberByCookie(String value);
	
	MemberVO getMemberByRequest(HttpServletRequest request);

	ArrayList<MemberVO> getMemberList(MemberVO user, Criteria cri);

	
	boolean updateAuthority(MemberVO user, MemberVO loginUser);

	int getTotalCount(MemberVO user);


}
