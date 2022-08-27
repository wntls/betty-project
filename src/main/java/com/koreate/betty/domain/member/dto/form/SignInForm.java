package com.koreate.betty.domain.member.dto.form;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;

import com.koreate.betty.domain.member.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInForm {
	
	@NotBlank
	String id;
	
	@NotBlank
	String pw;
	
	@Nullable
	String loginCookie;
	
	public Member convertToMember(){
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		return member;
	}
	
}
