package com.koreate.betty.domain.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreate.betty.domain.board.service.FreeBoardService;
import com.koreate.betty.domain.board.vo.FreeBoard;

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
	
	@GetMapping("{bno}/edit")
	public String freeBoardEdit() {
		return "board/free/free-edit";
	}
	@GetMapping("{bno}")
	public String freeBoardDetail(@PathVariable Integer bno, Model model) {
		FreeBoard board =  freeBoardService.detail(bno);
		model.addAttribute("board", board);
		return "board/free/free-detail";
	}
	
	
	/*@GetMapping("getList")
	//{ subject : re, perPageNum : 5 }
	public String getListAll(SearchCriteria searchCriteria) {
		// List<FreeBoardCommentDto> list = servere..();
		
		// new ResponseEntity<List<FreeBoardCommentDto>>(list, "200");
		
	}*/
	
}
