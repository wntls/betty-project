package com.koreate.betty.domain.book.vo;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookJoinBookSingle {

	private final String code;
	private final String title;
	private final String auth;
	private final String pub;
	private final Timestamp pubDate;
	private final int page;
	private final int genre;
	private final String intro;
	private final int num;
	private final String rental;
	private final String stat;
	
}
