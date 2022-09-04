package com.koreate.betty.global.error.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.koreate.betty.global.error.BettyNotFoundException;
import com.koreate.betty.global.error.ErrorResult;
import com.koreate.betty.global.error.exception.MessageException;
import com.koreate.betty.global.error.exception.NotFoundISBNException;
import com.koreate.betty.global.error.exception.NotFoundIdException;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler({NoHandlerFoundException.class, BettyNotFoundException.class})
	public ModelAndView noHandlerMappingHandle(Exception ex) {
		return new ModelAndView("error/404");
	}
	
	@ExceptionHandler(NotFoundISBNException.class)
	public ErrorResult notFoundISBNHandle(NotFoundISBNException ex) {
		return new ErrorResult();
	}
	
	@ExceptionHandler
	public ErrorResult notFoundIdHandle(NotFoundIdException ex) {
		return new ErrorResult();
	}
	
	@ExceptionHandler
	public ErrorResult messageHandle(MessageException ex) {
		return new ErrorResult();
	}
	
}
