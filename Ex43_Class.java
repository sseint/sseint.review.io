package com.test.obj;

import java.util.Arrays;

public class Ex43_Class {
	
	public static void main(String[] args) {
		
		//Ex43_Class
		
//		Person p1 = new Person();
//		
//		p1.setName("홍길동");
//		p1.setAge(20);
//		p1.setAddress("서울시");
//		
//		String[] nick = {"멍멍이", "왈왈이", "쫑쫑이" };	//미리 문자열 배열 준비 
//															// -> 인자리스트에 문자열 달라는 곳에 주기
//		
//		p1.setNick(nick);
//		
//		System.out.println(Arrays.toString(p1.getNick()));
//		//모든 참조형 다룰때 조심해야 함
//		
//		
//		
//		Person p2 = new Person();
//		
//		p2.setName("아무개");
//		p2.setAge(30);
//		p2.setAddress("부산시");
//		
//		String[] nick2 = {"강아지", "고양이", "송아지", "병아리", "망아지" };
//		
//		p2.setNick(nick2);
//		
//		
//		//위의 방식
//		//1. Person 클래스 제작자 > 제작자가 편함 
//		//2. Person 클래스 사용자 > 사용자가 불편함
//
//		//변경 방식
//		//1. Person 클래스 제작자 > 제작자가 불편함
//		//2. Person 클래스 사용자 > 사용자가 편함
		
		
		Person p1 = new Person();
		
		p1.setName("홍길동");
		p1.setAge(20);
		p1.setAddress("서울시");
		
		p1.addNick("멍멍이");		//setNick[0]
		p1.addNick("냐옹이");		//setNick[1]
		p1.addNick("병아리");		//setNick[2]
		p1.addNick("송아지");		//setNick[3]
		p1.addNick("물고기");		//setNick[4]
//		p1.addNick("망아지");		//setNick[5] <- 초과 "더이상 별명이 없습니다." 
		
//		System.out.println(Arrays.toString(p1.getNick()));
		
		System.out.println(p1.getNick()); //물고기	index--;이기 때문에 방번호 끝에서부터 호출
		System.out.println(p1.getNick()); //송아지
		System.out.println(p1.getNick()); //병아리
		System.out.println(p1.getNick()); //냐옹이
		System.out.println(p1.getNick()); //멍멍이
		
		p1.addNick("하하하");
		System.out.println(p1.getNick());
		System.out.println(p1.getNick());
	}
	
	
//	원하는 별명이 배열 몇번째에 있는지 모를때, 
	
	

}
