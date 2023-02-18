package com.test.obj;

import java.util.Calendar;

public class Member {
	
	private String name;		//회원 이름
	private String id;			//회원 ID
	
	private Calendar regdate; //가입날짜
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public Calendar getRegdate() {
//		return regdate;
//	}
//
//	public void setRegdate(Calendar regdate) {
//		this.regdate = regdate;
//	}
	
	
	public void setRegdate(int year, int month, int date) {		
		
		Calendar regdate = Calendar.getInstance();
		
		regdate.set(year, month-1, date); //외부에서 넣을때는 month-1
		
		this.regdate = regdate;
		
		
	}
	
	public String getRegdate() {
		
		return String.format("%tF", this.regdate);	//2023-02-17로 깔끔하게 바꿔서 출력하게끔 돌려주기
		
	}
	
	//조금이나마 사용자가 편리하고 단순하게 이용할 수 있도록 세팅에서 불편하더라도 자세하게 작성해야 함
	
	
	
	
	
	
	
	

}
