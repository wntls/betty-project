package com.koreate.betty.domain.board.dto;

import javax.validation.constraints.NotBlank;

import com.koreate.betty.domain.board.vo.FreeBoard;

import lombok.Data;

@Data
public class FreeBoardForm {
	
	@NotBlank
	private String memberId;
	@NotBlank
	private String tag;
	@NotBlank
	private String title;
	@NotBlank
	private String content;

	// image
	
	// 순수 vo 는 Builder 를 사용해서 setter 막기.
	public FreeBoard createFreeBoard() {
		return FreeBoard.builder()
				.memberId(memberId)
				.tag(tag)
				.title(title)
				.content(content)
				.build();
	}
}

