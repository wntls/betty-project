package com.koreate.betty.domain.board.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class SuggestBoardDTO {
	
	private int bno;
	private String memberId;
	private String title;
	private String content;
	private int origin;
	private int depth;
	private Timestamp regdate;
	private int viewcnt;
	private int recommend;
	private char showboard;
	
}
