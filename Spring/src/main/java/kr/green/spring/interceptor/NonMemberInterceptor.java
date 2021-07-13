package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class NonMemberInterceptor extends HandlerInterceptorAdapter {
//	로그인 안한 상태에서 보여줄것들
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
//		세션에있는 유저정보 가져옴
//		아이디가 뭔지 비번이 뭔지 정보를 알려는게 아니고 유저정보가 있는지 없는지만 판단
//		그래서 딱히 형변환하고 할 필요가 없다.
//		세션에 user로 저장했기 때문에 getAttribute에 user라고 적음
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
//		MemberInterception에서 여기에 != 이것만 바꿔줌
		if(user != null) {
			response.sendRedirect(request.getContextPath()+"/");
//			false : 원래 가려던 경로를 못가게 한다.
			return false;
		}
//		true : 원래 가려던 경로로 간다.
		return true;
	}

}
