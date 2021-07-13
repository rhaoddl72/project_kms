package kr.green.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;


@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
//	@GetMapping @PostMapping은 @RequestMapping 대신 쓰인다.
	
	@GetMapping(value="/signup")
	public ModelAndView signinupGet(ModelAndView mv) {
		
		mv.setViewName("member/signup");
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
		
		mv.setViewName("member/signin");
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
	
	
}
