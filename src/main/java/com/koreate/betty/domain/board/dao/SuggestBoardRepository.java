package com.koreate.betty.domain.board.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;

import com.koreate.betty.domain.board.provider.FreeBoardProvider;
import com.koreate.betty.domain.board.vo.SuggestBoard;

@Mapper
public interface SuggestBoardRepository {
	
		// 건의사항 등록
		@InsertProvider(type=FreeBoardProvider.class, method="suggestRegist")
		@Options(useGeneratedKeys = true , keyProperty = "bno")
		public void suggestRegist(SuggestBoard vo);
		
		// 건의사항 삭제
		@UpdateProvider(type=FreeBoardProvider.class, method="suggestRemove")
		public void suggestRemove(SuggestBoard vo);
		
		// 건의사항 수정
		@UpdateProvider(type=FreeBoardProvider.class, method="suggestUpdate")
		public void suggestUpdate(SuggestBoard vo);
		
		// 건의사항 수정
		// 여기까지 하고 합침
		@UpdateProvider(type=FreeBoardProvider.class, method="suggestRead")
		public SuggestBoard suggestRead(SuggestBoard vo);
		
}
