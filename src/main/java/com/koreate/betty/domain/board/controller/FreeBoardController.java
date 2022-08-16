package com.koreate.betty.domain.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreate.betty.domain.board.dto.FreeBoardDto;
import com.koreate.betty.domain.board.dto.form.FreeBoardForm;
import com.koreate.betty.domain.board.service.FreeBoardService;
import com.koreate.betty.domain.board.vo.FreeBoard;

@Controller
@RequestMapping("/boards/free/")
public class FreeBoardController {

	@Autowired
	FreeBoardService freeBoardService;
	
	// 자유게시판 첫 페이지
	@GetMapping
	public String freeBoard() {
		return "boards/free";
	}
	
	// 자유게시판 글쓰기
	@GetMapping("new")
	public String freeBoardNew() {
		// 아이디
		return "boards/free/new";
	}
	
	// 자유게시판 게시글
	@GetMapping("{num}")
	public String freeBoardDetail(@PathVariable int num, Model model) {
		// 게시글에 필요한 정보만 담아서 model 에 담고 페이지 반환
		FreeBoardDto dto = null;
		model.addAttribute("dto", dto);
		return "boards/free/"+num;
	}
	
}
