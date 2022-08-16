package com.koreate.betty.domain.board.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.board.vo.FreeBoard;

public class FreeBoardProvider {

	public String save(FreeBoard board) {
		SQL sql = new SQL();
		return sql.INSERT_INTO("free_board")
				.INTO_COLUMNS("member_id", "tag", "title", "content")
				.INTO_VALUES("#{memberId},"
						+ "#{tag},"
						+ "#{title},"
						+ "#{content}"
				).toString();
	}
	
}
