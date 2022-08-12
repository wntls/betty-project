package com.koreate.betty.domain.temp;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Alias("Temp")
@Getter
@Setter
public class Temp {

	private String iD;
	private String pW;
	
}
