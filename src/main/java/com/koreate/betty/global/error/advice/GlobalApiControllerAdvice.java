package com.koreate.betty.global.error.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.koreate.betty.global.error.ErrorResult;
import com.koreate.betty.global.error.exception.MessageException;
import com.koreate.betty.global.error.exception.NotFoundISBNException;
import com.koreate.betty.global.error.exception.NotFoundIdException;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalApiControllerAdvice {

	
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
