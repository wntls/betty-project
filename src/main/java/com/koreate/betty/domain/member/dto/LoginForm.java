package com.koreate.betty.domain.member.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginForm {
	
	@NotBlank
	String memberId;
	
	@NotBlank
	String pw;
	
	@Nullable
	String loginCookie;
	
}
