package com.koreate.betty.example;

import java.sql.Timestamp;

/**
 * 간단한 메소드 테스트 하고 싶으면 이렇게 main 메소드 만들어서 ctrl+f11 하면
 * Spring, test 신경안쓰고 테스트해볼 수 있습니다.
 *
 */
public class TestApplication {

	public static void main(String[] args) {
		String str = "2022-07-05"+ " 00:00:00";
		Timestamp stam = Timestamp.valueOf(str);
		System.out.println(stam); 
	}
	
}
