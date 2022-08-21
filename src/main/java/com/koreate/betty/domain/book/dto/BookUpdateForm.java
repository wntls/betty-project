package com.koreate.betty.domain.book.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.koreate.betty.domain.book.vo.Book;

import lombok.Data;

@Data
public class BookUpdateForm {
	
	// 필수 X인 건 지워도 정상적으로 작동합니다 필요에 따라 제거
	
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
	
	@NotBlank
	private String img;
	
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
				.img(img)
				.intro(intro)
				.build();
	}
}
