package com.koreate.betty.domain.board.vo;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@EqualsAndHashCode
public class FreeBoard {

	private int bno;
	private String memberId;
	private String tag;
	private String title;
	private String content;
	private Timestamp regdate;
	private int viewcnt;
	private char showboard;
	
}
