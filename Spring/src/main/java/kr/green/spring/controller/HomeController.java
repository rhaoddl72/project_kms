package kr.green.spring.controller;

import java.util.ArrayList;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	 
	 @Autowired
	 private JavaMailSender mailSender;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		
		mv.setViewName("/template/main/home");
		return mv;
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv) {
		
		mv.setViewName("/template/member/signin");
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
		
		mv.setViewName("/template/member/signup");
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
		mv.setViewName("/template/member/mypage");
		return mv;
	}
	
	@RequestMapping(value = "/member/mypage", method = RequestMethod.POST)
	public ModelAndView memberMypagePost(ModelAndView mv, MemberVO user, HttpServletRequest request) {
		
//		user: 화면에서 보낸 회원 정보, 정상적이라면 바로 수정해도 되지만
//		      개발자 도구를 이용하여 잘못된 정보를 보낼 수 있기 때문에 바로 수정하면 안됨
//		sessionUser : 현재 로그인된 회원 정보
//		updateUser : 업데이트된 회원정보로 user의 아이디와 myUser의 아이디가 일치하지않으면 null
//                   일치하면 업데이트된 회원정보
		
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
	
	
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(ModelAndView mv, HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		
		mv.setViewName("redirect:/");
		return mv;
	}
	// pathVariable은 해당 경로에 있는 변수를 가져온다.
	@ResponseBody
	@GetMapping(value = "/member/idcheck/{id}")
	public String memberIdcheckPost(@PathVariable("id") String id) {
		
		MemberVO user = memberService.getMember(id);
		String res = user != null ? "IMPOSSIBLE" : "POSSIBLE";
		
		return res;
	}
	
	@ResponseBody
	@PostMapping(value = "/member/signin")
	public String memberSigninPost(@RequestBody MemberVO user, HttpServletRequest r) {
		MemberVO dbUser = memberService.signin(user);
		
		if(dbUser != null)
			r.getSession().setAttribute("user", dbUser);
		
		return dbUser != null ? "success" : "fail";
	}
	
	@GetMapping("/find/pw")
	public ModelAndView findPwGet(ModelAndView mv) {
		mv.setViewName("/template/main/findpw");
		return mv;
	}
	@ResponseBody
	@GetMapping("/find/pw/{id}")
	public String findPwPost(@PathVariable("id") String id) {
		MemberVO user = memberService.getMember(id);
		if(user == null)
			return "FAIL";
		try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");
	        
	        //임시 비밀번호 발급
	        String newPw = newPW();
	        
	        //새 비밀번호를 DB에 저장
	        user.setPw(newPw);
	        memberService.updateMember(user);
	        
	        messageHelper.setFrom("rhaoddl72@gmail.com");  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(user.getEmail());     // 받는사람 이메일
	        messageHelper.setSubject("새 비밀번호를 발급합니다."); // 메일제목은 생략이 가능하다
	        messageHelper.setText("","발급된 새 비밀번호는 <b>" + newPw + "</b>입니다.");  // 메일 내용

	        mailSender.send(message);
	        return "SUCCESS";
	    } catch(Exception e){
	        System.out.println(e);
	    }
		return "FAIL";
		
		
		
	}
	// 8자리의 숫자 or 영어 대소문자로 된 비밀번호 
	private String newPW() {
		//랜덤숫자 :0~9 => 문자열 : 0~9
		//랜덤숫자 : 10~35 => 문자열 : a~z
		//랜덤숫자 : 36~61 => 문자열 : A~Z
		// 12 => c
		String pw = "";
		int max = 61, min = 0;
		for(int i = 0; i<8; i++) {
			int r = (int)(Math.random()*(max-min+1)) + min;
			// == int r = (int)(Math.random()*62);
			
			if(r <= 9) {
				pw += r;
			}
			else if(r <= 35){
				pw += (char)('a'+(r-10));
			}else {
				pw += (char)('A'+(r-36));
			}
		}
		
		return pw;
	}
	
	
	@GetMapping("/find/id")
	public ModelAndView findIdGet(ModelAndView mv) {
		mv.setViewName("/template/main/findid");
		return mv;
	}
	
	@ResponseBody
	@PostMapping("/find/id")
	public String findIdPost(String email) {
		
		ArrayList<MemberVO> userList = memberService.getMemberByEmail(email);
		
		
		if(userList == null || userList.size() == 0)
			return "FAIL";
		try {
			ArrayList<String> idList = new ArrayList<String>();
			for(MemberVO user : userList) {
				idList.add(user.getId());
			}
			System.out.println(idList);
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");
	        

	        
	        messageHelper.setFrom("rhaoddl72@gmail.com");  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(email);     // 받는사람 이메일
	        messageHelper.setSubject("가입된 아이디입니다."); // 메일제목은 생략이 가능하다
	        messageHelper.setText("","가입된 아이디는 <b>" + idList.toString().replaceAll("[\\[\\]]","") + "</b>입니다.");  // 메일 내용 replaceall은 []없애기위해서함
	        
	        mailSender.send(message);
	        return "SUCCESS";
	    } catch(Exception e){
	        System.out.println(e);
	    }
		return "FAIL";
		
		
		
	}
}

