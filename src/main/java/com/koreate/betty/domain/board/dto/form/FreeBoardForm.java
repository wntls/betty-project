package com.koreate.betty.domain.board.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.koreate.betty.domain.board.vo.FreeBoard;

import lombok.Data;

@Data
public class FreeBoardForm {
	
	@NotBlank
	private String memberId;
	
	@Size(max = 50)
	@NotBlank
	private String tag;
	
	@Size(max = 50)
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;

	// image
	
	public FreeBoard createFreeBoard() {
		return FreeBoard.builder()
				.memberId(memberId)
				.tag(tag)
				.title(title)
				.content(content)
				.build();
	}
}

