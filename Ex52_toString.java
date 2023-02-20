package com.test.obd.inheritance;

import java.util.Calendar;
import java.util.Date;

public class Ex52_toString {
	
	public static void main(String[] args) {
		
		//Ex52_toString.java
		
		//자주하는 오버라이딩
		
		Time t1 = new Time(2, 30);
		System.out.println(t1.info());	//2:30
		System.out.println(t1); 	//com.test.obd.inheritance.Time@2a17b7b6	<- Object가 물려준 메소드
		System.out.println(t1.toString());	// toString : Object클래스가 물려준 메소드
		System.out.println(t1.toString());	// 자식 메소드에서 Object가 준 메소드를 .info랑 똑같이로 바꿈									
		
		System.out.println(t1.toString()); 	//Time [hour=2, min=30]	<-맨 밑에 자동으로 생성한 오버라이딩
		System.out.println();
		
		
		
		
		//Calendar와 Date는 c1과 d1이라는 변수 출력 > 진짜 변수를 출력한게 아니라 컴파일러가 얘를 번역할때
		//c1.toString() / d1.toString()이라고 번역해주는 것	> toString : Object클래스가 물려준 메소드
		Calendar c1 = Calendar.getInstance();
		System.out.println(c1);		//java.util.GregorianCalendar[time=1676864150096,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=22,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2023,MONTH=1,WEEK_OF_YEAR=8,WEEK_OF_MONTH=4,DAY_OF_MONTH=20,DAY_OF_YEAR=51,DAY_OF_WEEK=2,DAY_OF_WEEK_IN_MONTH=3,AM_PM=1,HOUR=0,HOUR_OF_DAY=12,MINUTE=35,SECOND=50,MILLISECOND=96,ZONE_OFFSET=32400000,DST_OFFSET=0]
		System.out.println(c1.toString());	//Calendar의 toString은 자기가 다시 만들어서 덮어쓰기 한 것임
		System.out.println();
		
		
		
		
		Date d1 = new Date();
		System.out.println(d1);		//Mon Feb 20 12:35:50 KST 2023
		System.out.println(d1.toString());	//Date의 toString은 자기가 다시 만들어서 덮어쓰기 한 것임
		
		
		
		
		
	}

} // main class

class Time{
	
	private int hour;
	private int min;
	
	public Time(int hour, int min) {
		this.hour = hour;
		this.min = min;
	}
	
	//덤프
	public String info() {
		return this.hour + ":" + this.min;
	}

	
	//Object가 물려준 메소드
	//> 더 이상 Object.toString()을 사용하지 않고, 자신이 직접 만든 toString()을 사용한다.
	//toString : 덤프 전용 메소드(객체를 문자열로 바꾸는 메소드)
	//- (★★★★★) 모든 개발자는 이 toString()을 재정의할 때 항상 덤프를 구현한다.
//	public String toString() {
		
		//2:30
		//2시간 30분
		//hour(2), min(30)
		
//		return this.hour + ":" + this.min;
//	}
	
	
	//역할
	//- info()의 역할 == toString()의 역할
	//- 무조건 toString() 사용
	//	1. info() > 나만 아는 메소드
	//	2. toString() > 전세계 개발자가 다 아는 메소드
	
	
	@Override
	public String toString() {
		return "Time [hour=" + hour + ", min=" + min + "]";
	}
	
	
	
	
	
	
}
