package com.koreate.betty.domain.member.dto.form;

import javax.validation.constraints.NotBlank;

public class InquiryForm {

	@NotBlank
	private String memberId;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
}
