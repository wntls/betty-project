package com.koreate.betty.example;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class TempExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception ex) {
		log.error("Exception ex", ex);
		return new ModelAndView();
	}

}
