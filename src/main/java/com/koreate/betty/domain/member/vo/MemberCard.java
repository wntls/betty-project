package com.koreate.betty.domain.member.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberCard {
	
 	private final String memberId;
 	private final String premium;
    private final int demerit;
	
}
