package com.koreate.betty.domain.member.exception;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.koreate.betty.global.error.ErrorResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class SignControllerAdvice {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public ErrorResult notFoundIdHandle(NotFoundIdException ex) {
		log.info("NotFoundIdHandle = {}", ex);
		return new ErrorResult("NOT_FOUND_ID", "입력한 정보와 일치하는 아이디가 없습니다.");
	}
	
	//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	//@ExceptionHandler(RuntimeException.class)
	public ErrorResult validHandle(RuntimeException ex) {
		log.info("validHandle 호출");
		log.error(ex.getMessage());
		return new ErrorResult("BAD", ex.getMessage());
	}
	
	@ExceptionHandler
	public String testHandle(Exception e) {
		log.error("exception message ={}",e.getMessage());
		return "failed";
	}
}
