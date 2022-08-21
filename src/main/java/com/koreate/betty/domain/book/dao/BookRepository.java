package com.koreate.betty.domain.book.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

import com.koreate.betty.domain.book.provider.BookProvider;
import com.koreate.betty.domain.book.vo.Book;

@Mapper
public interface BookRepository {
	
	@UpdateProvider(type=BookProvider.class, method="bookUpdate")
	public int bookUpdate(@Param("targetBookCode") String targetBookCode, @Param("book") Book book);
		
}
