package com.koreate.betty.domain.member.dto.form;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

import com.koreate.betty.domain.member.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinForm {
	
	@NotBlank
	String memberId;
	
	@NotBlank
	String pw;
	
	@NotBlank
	String repw;
	
	@NotBlank
	String nickname;
	
	@NotBlank
	String name;
	
	@NotBlank
	String gender;
	
	@NotBlank
	String birth;
	
	@NotBlank
	String addr;
	
	@NotBlank
	String phone;
	
	@NotBlank
	String email;
	
	@NotBlank
	Integer rights;
	
	public Member createMember() {
		return Member.builder()
				.id(memberId)
				.pw(pw)
				.nickname(nickname)
				.name(name)
				.gender(gender)
				.birth(Timestamp.valueOf(birth + " 00:00:00"))
				.addr(addr)
				.phone(phone)
				.email(email)
				.rights(rights)
				.build();
	}	
}