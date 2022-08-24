package com.koreate.betty.domain.board.provider;

import static com.koreate.betty.domain.model.TableConst.FREE_COMMENT_TBL;
import static com.koreate.betty.domain.model.TableConst.SUGGEST_BOARD_TBL;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.board.vo.FreeBoard;
import com.koreate.betty.domain.board.vo.FreeBoardComment;

public class FreeBoardCommentProvider {
	
	// 댓글 작성
	public String commentAdd(@Param("cvo") FreeBoardComment cvo, @Param("fvo") FreeBoard fvo) {
		SQL sql = new SQL();
		sql.INSERT_INTO(FREE_COMMENT_TBL);
		sql.INTO_COLUMNS("free_bno, comment");
		if(cvo.getOrigin() != 0) {
			sql.INTO_COLUMNS("origin,depth,seq");
		}
		sql.INTO_COLUMNS("member_id");
		sql.INTO_VALUES("#{fvo.bno}, #{cvo.comment}");
		if(cvo.getOrigin() != 0) {
			sql.INTO_VALUES("#{cvo.origin},#{cvo.depth},#{cvo.seq}");
		}
		sql.INTO_VALUES("#{cvo.memberId}");
		return sql.toString();
	}
	
	// 댓글 수정
	public String commentModify(String loginUser, FreeBoardComment cvo) {
		return new SQL().UPDATE(FREE_COMMENT_TBL)
				.SET("comment = #{comment}")
				.WHERE("cno = #{cno}")
				.WHERE("member_id = " + loginUser)
				.toString();
	}
	
	// origin column 값 수정
	public String updateOrigin() {
		return new SQL().UPDATE(FREE_COMMENT_TBL)
				.SET("origin = LAST_INSERT_ID()")
				.WHERE("cno = LAST_INSERT_ID()")
				.toString();
	}
	
	
	// 댓글 삭제
	public String removeComment(String loginUser, FreeBoardComment cvo) {
		return new SQL().UPDATE(FREE_COMMENT_TBL)
				.SET("showboard = 'n'")
				.WHERE("cno = #{cno}")
				.WHERE("member_id = " + loginUser)
				.toString();
	}
	
}
