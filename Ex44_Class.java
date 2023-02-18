package com.test.obj;

import java.util.Calendar;

public class Ex44_Class {
	
	public static void main(String[] args) {
		
		//Ex44_Class.java
		
//		Member hong = new Member();
//		
//		hong.setName("홍길동");
//		hong.setId("hong");
//		
//		Calendar regdate = Calendar.getInstance();
//		regdate.set(2023, 0, 10);	//날짜 수정
//		
//		hong.setRegdate(regdate);	//비교
//		
//		System.out.printf("%tF\n", hong.getRegdate());	//가져와서 출력
		
		Member lee = new Member();
		
		lee.setName("이순신");
		lee.setId("lee");
		lee.setRegdate(2023, 2, 17);
		
		System.out.println(lee.getRegdate());
		
	}

}
