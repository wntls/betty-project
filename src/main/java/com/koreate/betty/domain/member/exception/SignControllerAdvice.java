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
		return new ErrorResult(HttpStatus.BAD_REQUEST.value(), "입력한 정보와 일치하는 아이디가 없습니다.");
	}
	
	@ExceptionHandler
	public ErrorResult testHandle(Exception e) {
		log.error("exception message ={}",e.getMessage());
		return new ErrorResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "요청 오류");
	}
}
