package com.koreate.betty.jaemin;

import java.sql.Timestamp;
import java.util.Date;

public class Others {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		Date newDate = new Date(0);
		newDate.setYear(2000);
		System.out.println(newDate);
		Timestamp timestamp = new Timestamp(date.getTime());
		System.out.println(timestamp);
		System.out.println(timestamp.getTime());
		System.out.println(new Timestamp(newDate.getTime()));

		String post = "12345";
		String addr = "부산시 금정구 남산동";
		String addr_detail = "123번지";
		String result = String.format("[%s] %s %s", post, addr, addr_detail);
		System.out.println(result);
	}

}
