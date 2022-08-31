package com.koreate.betty.jaemin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestTest {

	public static void main(String[] args) {
		// /betty /staff/books/
		String message = "/betty/staff/books/";
		String cp = "/betty";
		String trans = message.substring(cp.length());
		System.out.println(trans);
		System.out.println(cp.length());
		System.out.println(trans.startsWith("/staff"));
		System.out.println();
		System.out.println();
		System.out.println();
	}
}
