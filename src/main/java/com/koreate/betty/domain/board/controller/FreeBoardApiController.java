package com.koreate.betty.domain.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreate.betty.domain.board.dto.FreeBoardListDto;
import com.koreate.betty.domain.board.dto.form.FreeBoardForm;
import com.koreate.betty.domain.board.service.FreeBoardService;
import com.koreate.betty.domain.board.vo.FreeBoard;

@RestController
@RequestMapping("/boards/free/")
public class FreeBoardApiController {
	
	@Autowired
	FreeBoardService freeBoardService;
	
	// 게시글 목록 요청
	// page, cri 정보 받아서 처리해야함
	@GetMapping("list")
	public FreeBoardListDto freeBoardList() {
		return null;
	}
	
	// 게시글 등록 요청
	@PostMapping("new")
	public void freeBoardNewReq(@Validated FreeBoardForm form, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			// form error logic
			return;
		}
		
		int result = freeBoardService.write(form);
		
		if(result == 0) {
			// insert error logic
			return;
		}
		
		// complete : location 이동
		// redirect:/boards/free/bno
	}

}
