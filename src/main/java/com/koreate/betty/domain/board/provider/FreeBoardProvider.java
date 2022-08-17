package com.koreate.betty.domain.board.provider;

import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.board.vo.FreeBoard;

public class FreeBoardProvider {

	public String save(FreeBoard board) {
		return new SQL().INSERT_INTO("free_board")
						.INTO_COLUMNS("member_id", "tag", "title", "content")
						.INTO_VALUES("#{memberId},#{tag},#{title},#{content}")
						.toString();
	}
	
}
