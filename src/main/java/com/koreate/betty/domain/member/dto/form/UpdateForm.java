package com.koreate.betty.domain.member.dto.form;

import java.io.File;
import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import com.koreate.betty.domain.member.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateForm {
	
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
	
	@Nullable
	MultipartFile img;
	
	public Member createMember() {
		
		String fileName =  memberId + "_" + img.getName();
		return Member.builder()
				.id(memberId)
				.pw(pw)
				.nickname(nickname)
				.name(name)
				.gender(gender)
				.birth(Timestamp.valueOf(birth + " 00:00:00"))
				.addr(addr)
				.img(fileName)
				.build();
	}
}