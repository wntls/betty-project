package com.koreate.betty.domain.board.provider;

import static com.koreate.betty.domain.model.TableConst.NOTICE_BOARD_TBL;

import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.board.vo.NoticeBoard;
import com.koreate.betty.global.util.SearchCriteria;

public class NoticeBoardProvider {
	
		// 공지사항 등록
		public String noticeRegist(NoticeBoard vo) {
			return new SQL().INSERT_INTO(NOTICE_BOARD_TBL)
					.INTO_COLUMNS("member_id","title","content")
					.INTO_VALUES("#{memberId},#{title},#{content}")
					.toString();
		}
		
		// 공지사항 수정
		public String noticeUpdate(NoticeBoard vo) {
			return new SQL().UPDATE(NOTICE_BOARD_TBL)
					.SET("title = #{title}, content = #{content}")
					.WHERE("bno = #{bno}")
					.toString();
		}
		
		// 공지사항 삭제
		public String noticeRemove(int bno) {
			return new SQL().UPDATE(NOTICE_BOARD_TBL)
					.SET("showboard = 'n'")
					.WHERE("bno = #{bno}")
					.toString();
		}
		
		// 공지사항 상세보기
		public String noticeDetail(int bno) {
			return new SQL().SELECT("*")
					.FROM(NOTICE_BOARD_TBL)
					.WHERE("bno = #{bno}")
					.toString();
		}
		
		// 조회수 증가
		public String updateCnt(int bno) {
			return new SQL()
					.UPDATE(NOTICE_BOARD_TBL)
					.SET("viewcnt = viewcnt + 1")
					.WHERE("bno = #{bno}")
					.toString();
		}
		
		// 공지사항 목록 출력
		public String noticeList(SearchCriteria cri) {
			SQL sql = new SQL().SELECT("*");
			sql.FROM(NOTICE_BOARD_TBL);
			sql.ORDER_BY("bno DESC");
			getSearchWhere(cri, sql);
			sql.OFFSET(cri.getStartRow());
			sql.LIMIT(cri.getPerPageNum());
			return sql.toString();
		}
		
		
		// 전체 게시물 개수
		public String listAllCount(SearchCriteria cri) {
			SQL sql = new SQL().SELECT("count(*)");
			sql.FROM(NOTICE_BOARD_TBL);
			getSearchWhere(cri, sql);
			return sql.toString();
		}
	
		// 검색
		private void getSearchWhere(SearchCriteria cri, SQL sql) {
			String titleQuery = "title LIKE CONCAT('%','"+cri.getKeyword()+"','%')";
			String contentQuery = "content LIKE CONCAT('%',#{keyword},'%')";
			String writerQuery = "member_id LIKE CONCAT('%',#{keyword},'%')";
			if(cri.getSearchType() != null && !cri.getSearchType().trim().equals("")
					&& !cri.getSearchType().trim().equals("n")) {
				if(cri.getSearchType().contains("t")) {
					sql.OR().WHERE(titleQuery);
				}
				if(cri.getSearchType().contains("c")) {
					sql.OR().WHERE(contentQuery);
				}
				if(cri.getSearchType().contains("w")) {
					sql.OR().WHERE(writerQuery);
				}
			}
		}
		
		
		
}
