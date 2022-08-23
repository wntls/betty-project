package com.koreate.betty.domain.book.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.koreate.betty.domain.book.vo.Book;

public class BookBuyForm {
	
	@Size(max = 50)
	@NotBlank
	private String code;
	
	@Size(max = 50)
	@NotBlank
	private String title;
	
	@Size(max = 30)
	@NotBlank
	private String auth;
	
	@Size(max = 50)
	@NotBlank
	private String pub;
	
	@Size(max = 50)
	@NotBlank
	private Timestamp pubDate;
	
	@NotBlank // 필수 X
	private int page;
	
	@NotBlank
	private int genre;
	
	@NotBlank // 필수 X
	private String intro;
	
	public Book createBook() {
		
		return Book.builder()
				.code(code)
				.title(title)
				.auth(auth)
				.pub(pub)
				.pubDate(pubDate)
				.page(page)
				.genre(genre)
				.intro(intro)
				.build();
	}
}
