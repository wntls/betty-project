package com.koreate.betty.domain.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.koreate.betty.domain.board.provider.SuggestBoardProvider;
import com.koreate.betty.domain.board.vo.SuggestBoard;
import com.koreate.betty.global.util.Criteria;
import com.koreate.betty.global.util.SearchCriteria;

@Mapper
public interface SuggestBoardRepository {
	
		// 건의사항 등록
		@InsertProvider(type=SuggestBoardProvider.class, method="suggestRegist")
		@Options(useGeneratedKeys = true , keyProperty = "bno")
		public void suggestRegist(SuggestBoard vo);
		
		// 답변글 등록
		@InsertProvider(type=SuggestBoardProvider.class, method="suggestRegist")
		public void suggestReply(SuggestBoard vo);
		
		// 업데이트 오리진
		@UpdateProvider(type=SuggestBoardProvider.class, method="updateOrigin")
		public void updateOrigin();
		
		// 건의사항 삭제
		@UpdateProvider(type=SuggestBoardProvider.class, method="suggestRemove")
		public void suggestRemove(SuggestBoard vo);
		
		// 건의사항 수정
		@UpdateProvider(type=SuggestBoardProvider.class, method="suggestUpdate")
		public void suggestUpdate(SuggestBoard vo);
		
		// 건의사항 상세
		@UpdateProvider(type=SuggestBoardProvider.class, method="suggestDetail")
		public SuggestBoard suggestRead(SuggestBoard vo);
		
		// 건의사항 목록 출력
		@SelectProvider(type=SuggestBoardProvider.class, method = "suggestList")
		public List<SuggestBoard> SuggestList(SearchCriteria cri);
		
		// 전체 게시글 개수
		public int listCount(SearchCriteria cri);

}
