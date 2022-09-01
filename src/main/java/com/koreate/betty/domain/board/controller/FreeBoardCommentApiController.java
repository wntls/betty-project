package com.koreate.betty.domain.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreate.betty.domain.board.dto.form.FreeBoardCommentForm;
import com.koreate.betty.domain.board.service.FreeCommentService;
import com.koreate.betty.domain.board.vo.FreeBoardComment;
import com.koreate.betty.global.util.PageMaker;
import com.koreate.betty.global.util.SearchCriteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("boards/free/{bno}/comments")
public class FreeBoardCommentApiController {
	
	@Autowired
	FreeCommentService freeCommentService;
	
	@GetMapping
	public List<FreeBoardComment> controllerLoadTest(@PathVariable Integer bno) {
		log.info("api called complete");
		SearchCriteria cri = new SearchCriteria();
		PageMaker pm = freeCommentService.getPageMaker(cri, bno);
		return freeCommentService.list(pm.getCri(), bno);
	} 
	
	@PostMapping
	public ResponseEntity<Integer> commentAdd(FreeBoardCommentForm form) {
		ResponseEntity<Integer> entity = null;
		try {
			int message = freeCommentService.add(form);
			entity = new ResponseEntity<>(message,HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
}











