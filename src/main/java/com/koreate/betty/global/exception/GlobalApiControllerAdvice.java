package com.koreate.betty.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.koreate.betty.domain.book.exception.NotFoundISBNException;
import com.koreate.betty.global.error.ErrorResult;

@RestControllerAdvice
public class GlobalApiControllerAdvice {

	
	@ExceptionHandler(NotFoundISBNException.class)
	public ErrorResult notFoundISBNHandle(NotFoundISBNException ex) {
	
		return new ErrorResult(HttpStatus.NOT_FOUND.value(), "요청하신 도서 정보를 조회할 수 없습니다.");
	}
}
