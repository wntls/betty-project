package com.koreate.betty.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * 예외 공통 처리부
 * @author 82105
 */

@Slf4j
//@ControllerAdvice
public class TempAdvisor {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception ex) {
		log.error("Exception ex",ex);
		return new ModelAndView();
	}
	
}
