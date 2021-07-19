package kr.green.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView handle404(NoHandlerFoundException e) {
		
		//modelandview를 매개변수로 만들면 실행이 안되서 객체로 만들어줌
		ModelAndView mv = new ModelAndView();
		
		//예외 처리하고 싶은 코드 작업
		log.error("페이지를 찾을 수 없습니다.");
		mv.setViewName("/template/exception/custom404");
		return mv;
	}
}
