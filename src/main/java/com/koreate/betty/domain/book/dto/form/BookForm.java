package com.koreate.betty.domain.book.dto.form;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.koreate.betty.domain.book.vo.Book;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookForm {
	
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
	private Integer page;
	
	@NotBlank
	private Integer genre;
	
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
