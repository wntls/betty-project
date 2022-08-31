package com.koreate.betty.domain.member.vo;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inquiry {

	@NotBlank
	private String memberId;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
}
