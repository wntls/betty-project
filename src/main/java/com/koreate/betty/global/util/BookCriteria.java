package com.koreate.betty.global.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper=true)
public class BookCriteria extends Criteria {
	
	private String genre;
	private String searchType;
	private String keyword;
	
	public BookCriteria(int page, int perPageNum, String genre, String searchType, String keyword) {
		super(page, perPageNum);
		this.genre = genre;
		this.searchType = searchType;
		this.keyword = keyword;
	}
	
	
}