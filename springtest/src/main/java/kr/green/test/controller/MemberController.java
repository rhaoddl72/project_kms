package kr.green.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
//	@GetMapping @PostMapping은 @RequestMapping 대신 쓰인다.
	
	@GetMapping(value="/signup")
	public ModelAndView signinupGet(ModelAndView mv) {
		
		mv.setViewName("/template/member/signup");
		return mv;
	}
	
	
	@PostMapping(value="/signup")
	public ModelAndView signinupPost(ModelAndView mv, MemberVO user) {
		memberService.signup(user);
		
		
		
		mv.setViewName("redirect:/");
		return mv;
	}
	
	
	@GetMapping(value="/signin")
	public ModelAndView signinGet(ModelAndView mv) {
		
		mv.setViewName("/template/member/signin");
		return mv;
	}
	
	@PostMapping(value="/signin")
	public ModelAndView signinPost(ModelAndView mv, MemberVO user) {
		MemberVO loginUser = memberService.signin(user);
		
		if(loginUser != null)
			mv.setViewName("redirect:/");
		else
			mv.setViewName("redirect:/signin");
		
		mv.addObject("user",loginUser);
		return mv;
	}
	
	@GetMapping(value="/member/mypage")
	public ModelAndView mypageGet(ModelAndView mv) {
		
		mv.setViewName("/template/member/mypage");
		return mv;
	}
	
	@PostMapping(value="/member/mypage")
	public ModelAndView mypagePost(ModelAndView mv, MemberVO user, HttpServletRequest r) {
		// user : 화면에서 보낸 회원 정보, 정상적이라면 바로 수정해도 되지만
		//        개발자 도구를 이용하여 잘못된 정보를 보낼 수 있기 때문에 바로 수정하면 안됨
		// myUser : 현재 로그인된 회원 정보
		// updateUser : 업데이트된 회원정보로 user의 아이디와 myUser의 아이디가 일치하지않으면 null
		//              일치하면 업데이트된 회원정보
		log.info(user);
		
		MemberVO myUser = memberService.getMember(r);
		
		
		if(myUser != null && myUser.getId().equals(user.getId())) {
			
			MemberVO updateUser = memberService.updateMember(user);
			
			if(updateUser != null) {
//				업데이트된 내용으로 덮어쓴다.
				r.getSession().setAttribute("user", updateUser);
			}
			
		}
		mv.setViewName("redirect:/member/mypage");
		return mv;
	}
	
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(ModelAndView mv, HttpServletRequest r) {
		
		r.getSession().removeAttribute("user");
		
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@ResponseBody
	@GetMapping(value="/member/idCheck/{id}")
	public String idCheck(@PathVariable("id") String id) {
		
		
		
		return memberService.idCheck(id) ? "true" : "false";
	}
	
	
}
