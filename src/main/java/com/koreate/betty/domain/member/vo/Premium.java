package com.koreate.betty.domain.member.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Premium {
	
	private final String grade;		
    private final int fee; 					
    private final int lendBookcnt; 
    private final int lendPeriod;
    private final int dueSale;
    private final int lendPrice;
	
}
