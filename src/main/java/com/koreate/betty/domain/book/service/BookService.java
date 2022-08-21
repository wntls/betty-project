package com.koreate.betty.domain.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreate.betty.domain.book.dao.BookRepository;
import com.koreate.betty.domain.book.dto.BookUpdateForm;
import com.koreate.betty.domain.book.vo.Book;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public int bookUpdate(String targetBookCode, BookUpdateForm form) {	// bookUpdate Form에 맞게 수정할 것
		
		Book book = form.createBook();		
		return bookRepository.bookUpdate(targetBookCode, book);
	}
}
