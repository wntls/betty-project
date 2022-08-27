package com.koreate.betty.example;

import java.sql.Timestamp;

public class TestApplication {

	public static void main(String[] args) {
		String str = "2022-07-05"+ " 00:00:00";
		Timestamp stam = Timestamp.valueOf(str);
		System.out.println(stam); 
	}
	
}
