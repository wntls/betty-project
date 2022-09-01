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
	
	{
		this.setPerPageNum(8);
	}
	
	private String genre;
	private String searchOption;
	private String searchText;
	
	public BookCriteria(int page, int perPageNum, String genre, String searchOption, String searchText) {
		super(page, perPageNum);
		this.genre = genre;
		this.searchOption = searchOption;
		this.searchText = searchText;
	}
	
	
}