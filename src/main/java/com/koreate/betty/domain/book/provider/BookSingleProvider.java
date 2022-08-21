package com.koreate.betty.domain.book.provider;

import static com.koreate.betty.domain.model.TableConst.BOOK_SINGLE_TBL;

import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.book.vo.Book;

public class BookSingleProvider {

	// 기존 도서 재고 1권 추가
	public String bookSingleAdd(String code) {
		return new SQL().INSERT_INTO(BOOK_SINGLE_TBL)
				.INTO_COLUMNS("book_code")
				.INTO_VALUES("#{code}")
				.toString();
	}
	
	// 기존 도서 재고 1권 제거
	public String bookSingleDelete(String code, String num) {
		return new SQL().DELETE_FROM(BOOK_SINGLE_TBL)
				.WHERE("book_code = #{code}").WHERE("num = #{num}")
				.toString();
	}
	
	// 해당 도서 1권 정보
	
}
