package com.koreate.betty.domain.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreate.betty.domain.board.dto.FreeBoardDto;
import com.koreate.betty.domain.board.service.FreeBoardService;

@Controller
@RequestMapping("/boards/free")
public class FreeBoardController {

	@Autowired
	FreeBoardService freeBoardService;
	
	@GetMapping
	public String freeBoardList() {
		return "board/free/free-board";
	}
	
	@GetMapping("new")
	public String freeBoardNew() {
		return "board/free/free-new";
	}
	
	//@PathVariable
	@GetMapping("{bno}/edit")
	public String freeBoardEdit() {
		return "board/free/free-edit";
	}
	
	//@PathVariable
	@GetMapping("{bno}")
	public String freeBoardDetail(@PathVariable @Nullable Integer bno, Model model) {
		// 게시글에 필요한 정보만 담아서 model 에 담고 페이지 반환
		FreeBoardDto dto = null;
		model.addAttribute("dto", dto);
		return "board/free/free-detail";
	}
	
}
