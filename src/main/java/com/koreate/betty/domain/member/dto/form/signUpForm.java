package com.koreate.betty.domain.member.dto.form;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.koreate.betty.domain.member.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class signUpForm {
	
	@NotBlank
	String id;
	
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
	
	@NotNull
	Integer rights;
		
		public Member convertToMember(){
			Member member = new Member();
			member.setId(id);
			member.setPw(pw);
			member.setNickname(nickname);
			member.setName(name);
			member.setGender(gender);
			member.setBirth(Timestamp.valueOf(birth+ " 00:00:00"));
			member.setAddr(addr);
			member.setAddr(addr);
			member.setPhone(phone);
			member.setEmail(email);
			member.setRights(rights);;
			return member;
		}
		
		
}