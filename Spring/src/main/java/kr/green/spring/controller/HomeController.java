package kr.green.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	 @Autowired
	    MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv) {
		
		mv.setViewName("signin");
		return mv;
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signinPost(ModelAndView mv,MemberVO user) {
		
//		System.out.println(user);
		//서비스에게 아이디와 비밀번호를 전달하면, 해당 정보가 DB에 있으면
		//회원 정보를 없으면 null을 반환
		// user정보가 담긴 signin을 dbUser라는 객체에 담아둔다.
		MemberVO dbUser = memberService.signin(user);
		//회원 정보가 있으면 => 로그인에 성공하면
		if(dbUser != null) {
			
			//redirect는 작업이 다 끝난 후 URI가 /인 곳으로 넘어가도록 해준다.
			// 내가 원하는 곳으로 URI를 보낼 수 있다.
			//위에 method가 GET이고 vlaue가 /인 곳으로 넘어간다. 
			mv.setViewName("redirect:/");
		//회원정보가 없으면 => 일치하는 아이디가 x, 비밀번호 x => 로그인 실패
		}else {
			mv.setViewName("redirect:/signin");
		}
//		마지막에 유저라는 정보를 넣어줘야 로그인 인터셉터가 가로채서 세션에 저장한다.
		mv.addObject("user",dbUser);
		return mv;
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		
		mv.setViewName("signup");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv,MemberVO user) {
		
//		System.out.println(user);
		//서비스에게 회원 정보를 주면서 회원가입하라고 일을 시키고, 회원가입이 성공하면 true를
		//실패하면 false를 알려달라고 요청
		boolean isSignup = memberService.signup(user);
		
		//회원가입에 성공하면 메인으로 실패하면 회원가입 페이지로 이동
		if(isSignup) {
			mv.setViewName("redirect:/");
		}else {
			
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	
	
	@RequestMapping(value = "/member/mypage", method = RequestMethod.GET)
	public ModelAndView memberMypageGet(ModelAndView mv) {
//		서비스에게 아이디를 주면서 회원 정보를 가져오라고 시킴
//		MemberVO user = memberService.getMember(id);
//		가져온 회원 정보를 화면에 전달
//		mv.addObject("user", user);
//		세션을 이용하기 때문에 위에 코드가 필요없어진다.
		mv.setViewName("member/mypage");
		return mv;
	}
	
	@RequestMapping(value = "/member/mypage", method = RequestMethod.POST)
	public ModelAndView memberMypagePost(ModelAndView mv, MemberVO user, HttpServletRequest request) {
		// service에게 request 정보 줄테니 회원정보 찾아서 달라고 요청
//		request에 있는 세션 안에있는 로그인한 회원정보를 가져옴
		MemberVO sessionUser = memberService.getMember(request);
		
		//세션에 로그인한 회원 정보가 있고, 세션에 있는 아이디와 수정할 아이디가 같으면 회원 정보 수정함
		// 개발자 도구에서의 아이디 수정을 막아줌
		if(sessionUser != null && sessionUser.getId().equals(user.getId())) {
			
			MemberVO updateUser = memberService.updateMember(user);
//			업데이트가 되었으면
			if(updateUser != null) {
				request.getSession().setAttribute("user", updateUser);
			}
		}
		
		mv.setViewName("redirect:/");
		return mv;
	}
	
}

