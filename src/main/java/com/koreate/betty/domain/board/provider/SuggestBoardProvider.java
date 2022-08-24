package com.koreate.betty.domain.board.provider;

import static com.koreate.betty.domain.model.TableConst.NOTICE_BOARD_TBL;
import static com.koreate.betty.domain.model.TableConst.SUGGEST_BOARD_TBL;

import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.board.vo.SuggestBoard;
import com.koreate.betty.global.util.SearchCriteria;

public class SuggestBoardProvider {
	
	// 건의사항 등록
	public String suggestRegist(SuggestBoard board) {
		SQL sql = new SQL();
		sql.INSERT_INTO(SUGGEST_BOARD_TBL);
		sql.INTO_COLUMNS("title,content");
		if(board.getOrigin() != 0) {
			sql.INTO_COLUMNS("origin,depth");
		}
		sql.INTO_COLUMNS("member_id");
		sql.INTO_VALUES("#{title},#{content}");
		if(board.getOrigin() != 0) {
			sql.INTO_VALUES("#{origin},#{depth}");
		}
		sql.INTO_VALUES("#{memberId}");
		return sql.toString();
	}
	
	// origin column 값 수정
	public String updateOrigin() {
		return new SQL().UPDATE(SUGGEST_BOARD_TBL)
				.SET("origin = LAST_INSERT_ID()")
				.WHERE("bno = LAST_INSERT_ID()")
				.toString();
	}
	
	// 건의사항 수정
	public String suggestUpdate(SuggestBoard vo) {
		return new SQL().UPDATE(SUGGEST_BOARD_TBL)
				.SET("title = #{title}, content = #{content}")
				.WHERE("bno = #{bno}")
				.toString();
	}
	
	// 건의사항 삭제
	public String suggestRemove(SuggestBoard vo) {
		return new SQL().UPDATE(SUGGEST_BOARD_TBL)
				.SET("showboard = 'n'")
				.WHERE("bno = #{bno}")
				.toString();
	}
	
	// 건의사항 상세보기
	public String suggestDetail(SuggestBoard vo) {
		return new SQL().SELECT("*")
				.FROM(SUGGEST_BOARD_TBL)
				.WHERE("bno = #{bno}")
				.toString();
	}
	
	// 전체 게시물 개수
	public String listAllCount(SearchCriteria cri) {
		return new SQL().SELECT("count(*)")
				.FROM(SUGGEST_BOARD_TBL)
				.toString();
	}
	
	// 건의사항 목록 출력
	public String suggestList(SearchCriteria cri, SuggestBoard vo) {
		return new SQL().SELECT("*")
				.FROM(SUGGEST_BOARD_TBL)
				.ORDER_BY("origin, depth")
				.WHERE("title LIKE CONCAT('%',#{title},'%')")
				.OFFSET(cri.getStartRow())
				.LIMIT(cri.getPerPageNum())
				.toString();
	}
	
	// 조회수 증가
	public String updateCnt(int bno) {
		return new SQL()
				.UPDATE(SUGGEST_BOARD_TBL)
				.SET("viewcnt = viewcnt + 1")
				.WHERE("bno = #{bno}")
				.toString();
	}
	
	// 추천수 증가
	public String updateRecommend(int bno) {
		return new SQL()
				.UPDATE(SUGGEST_BOARD_TBL)
				.SET("recommend = recommend + 1")
				.WHERE("bno = #{bno}")
				.toString();
	}
	
	
}
