package com.koreate.betty.domain.board.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

import com.koreate.betty.domain.board.provider.FreeBoardCommentProvider;
import com.koreate.betty.domain.board.provider.SuggestBoardProvider;
import com.koreate.betty.domain.board.vo.FreeBoard;
import com.koreate.betty.domain.board.vo.FreeBoardComment;

@Mapper
public interface FreeBoardCommentRepository {
	
	// 댓글 등록
	@InsertProvider(type=FreeBoardCommentProvider.class, method="commentAdd")
	//@Options(useGeneratedKeys = true , keyProperty = "cno")
	public int commentAdd(@Param("cvo") FreeBoardComment cvo, @Param("fvo") FreeBoard fvo);
	
	// 댓글 수정
	@UpdateProvider(type=FreeBoardCommentProvider.class, method="commentModify")
	public int commentModify(String loginUser, FreeBoardComment cvo);
	
	// 댓글 삭제
	@UpdateProvider(type=FreeBoardCommentProvider.class, method="removeComment")
	public int removeComment(String loginUser, FreeBoardComment cvo);
	
	// 업데이트 오리진
	@UpdateProvider(type=FreeBoardCommentProvider.class, method="updateOrigin")
	public int updateOrigin();

	
}
