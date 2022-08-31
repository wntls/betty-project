package com.koreate.betty.domain.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreate.betty.domain.book.dto.form.BookForm;
import com.koreate.betty.domain.book.service.BookCommentService;
import com.koreate.betty.domain.book.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bs;
	
	@Autowired
	BookCommentService bcs;
	
	@GetMapping
	public String bookListPage() {
		return "book/book-board";
	}
	
	// 도서 상세 정보
	@GetMapping("{isbn}")
	public String bookDetail(@PathVariable String isbn, Model model) { // key : book
		model.addAttribute("book", bs.bookDetail(isbn));
		return "book/book-detail";
	}
	
	// 도서 검색 : 작업 대기 중
	
	// 도서 페이지 전환 (ajax가 아닌 일반 처리) : 작업 대기 중
	
	// 신규 도서 입고
	@PostMapping
	public String newBook(BookForm form) {
		int result = bs.bookRegister(form);
		return "redirect:/books/" + form.getCode();
	}
	
	// 도서 정보 수정
	@PutMapping("{isbn}")
	public String updateBook(BookForm form) {
		String code = form.getCode();
		int result = bs.update(code, form);
		return "redirect:/books/" + code;
	}	
	
	// 도서 후기 목록 페이지 (목록 출력은 ajax 사용으로 인해 commentApi에서 처리)
	@GetMapping("{isbn}/comments")
	public String bookComment(@PathVariable String isbn) {
		return isbn + "/comments";
	}
	
	// 재고 추가
	@PostMapping("{isbn}/single")
	public String addWare(@PathVariable String isbn, String id, int amount) {
		int result = 0;
		Integer count = amount;		
		result = bs.insertWare(isbn, id, count);
		return "redirect:/staff/books/";
	}
	
}