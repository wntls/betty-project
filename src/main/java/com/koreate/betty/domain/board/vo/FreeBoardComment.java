package com.koreate.betty.domain.board.vo;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class FreeBoardComment {
	
	private final Integer cno;
	private final Integer freeBno;
	private final String memberId;
	private final String comment;
	private final Integer origin;
	private final Integer depth;
	private final Integer seq;
	private final Timestamp regdate;
	private final String showboard;		
	
	
}
