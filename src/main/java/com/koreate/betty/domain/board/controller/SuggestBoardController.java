package com.koreate.betty.domain.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koreate.betty.domain.board.dto.SuggestBoardDTO;
import com.koreate.betty.domain.board.service.SuggestBoardService;
import com.koreate.betty.global.util.PageMaker;
import com.koreate.betty.global.util.SearchCriteria;

@Controller
@RequestMapping("/boards/suggest")
public class SuggestBoardController {

    @Autowired
    SuggestBoardService sbs;

    @GetMapping
    public ModelAndView suggestBoardList(SearchCriteria cri, ModelAndView mav) {
	mav.setViewName("board/suggest/suggest-board");
	System.out.println(cri.getKeyword());
	System.out.println(cri.getSearchType());
	System.out.println("\n\n\n\n");
	List<SuggestBoardDTO> list = sbs.SuggestList(cri);
	mav.addObject("list", list);
	PageMaker pm = sbs.getPageMaker(cri);
	mav.addObject("pm", pm);
	return mav;
    }
    

    @GetMapping("new")
    public String freeBoardNew() {
	return "board/suggest/suggest-new";
    }

    @GetMapping("/{bno}")
    public String suggestBoardDetail() {
	return "board/suggest/suggest-detail";
    }

    @GetMapping("{bno}/edit")
    public String suggestBoardEdit() {
	return "board/suggest/suggest-edit";
    }

}