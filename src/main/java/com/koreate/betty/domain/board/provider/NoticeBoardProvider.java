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
		public String noticeDetail(NoticeBoard vo) {
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
		public String noticeList(SearchCriteria cri, NoticeBoard vo) {
			return new SQL().SELECT("*")
					.FROM(NOTICE_BOARD_TBL)
					.ORDER_BY("bno DESC")
					.WHERE("title LIKE CONCAT('%',#{title},'%')")
					.OFFSET(cri.getStartRow())
					.LIMIT(cri.getPerPageNum())
					.toString();
		}
		
		
		// 전체 게시물 개수
		public String listAllCount(SearchCriteria cri) {
			return new SQL().SELECT("count(*)")
					.FROM(NOTICE_BOARD_TBL)
					.toString();
		}
		
		
		
		
}
