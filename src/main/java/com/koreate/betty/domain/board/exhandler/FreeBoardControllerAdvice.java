package com.koreate.betty.domain.board.exhandler;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.koreate.betty.domain.board.controller.FreeBoardController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice(assignableTypes = {FreeBoardController.class})
public class FreeBoardControllerAdvice {

	@ExceptionHandler
	public void invalidMemberId(SQLIntegrityConstraintViolationException ex) {
		log.error("중복된 아이디 오류 ={}",ex);
	}
	
}
