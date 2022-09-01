package com.koreate.betty.global.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler
	public ModelAndView noHandlerMappingHandle(NoHandlerFoundException ex) {
		return new ModelAndView("error/404");
	}
	
}
