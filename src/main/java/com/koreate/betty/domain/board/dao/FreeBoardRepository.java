package com.koreate.betty.domain.board.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.koreate.betty.domain.board.dao.provider.FreeBoardProvider;
import com.koreate.betty.domain.board.vo.FreeBoard;

@Mapper
public interface FreeBoardRepository {

	@InsertProvider(type=FreeBoardProvider.class, method="save")
	// insert 후 자동 생성된 key 값을 반환함.
	@Options(useGeneratedKeys = true , keyProperty = "bno")
	public void save(FreeBoard board);
	
	
}
