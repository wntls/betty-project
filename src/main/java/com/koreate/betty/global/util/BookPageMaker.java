package com.koreate.betty.global.util;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookPageMaker extends PageMaker{

	@Override
	public String makeQuery(int page) {
		BookCriteria bcr = (BookCriteria)super.getCri();
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("genre",bcr.getGenre())
				.queryParam("page", page)
				.queryParam("perPageNum",bcr.getPerPageNum())
				.queryParam("searchType",bcr.getSearchType())
				.queryParam("keyword",bcr.getKeyword()).build();
		String query = uri.toUriString();
		return query;
	}
	
	
	
}
