package com.koreate.betty.domain.member.vo;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
	
	private final String id;
	private final String pw;
	private final String nickname;
	private final String name;
	private final String gender;
	private final Timestamp birth;
	private final String phone;
	private final String addr;
	private final String email;
	private final Timestamp regDate;
	private final String del;
	private final String img;
	
}
