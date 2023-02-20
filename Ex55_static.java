package com.test.obd.inheritance;

public class Ex55_static {
	
	public static void main(String[] args) {
		
		//Ex55_static.java
		
		
		
		
		
		
		
		
		
		
		
		
	} //main

} //main class

class StaticTest{
	
	private int a;			//객체 변수
	private static int b;	//정적 변수
	
	//멤버 초기화 > 생성자
	
	public void aaa() {
		
		//객체 메소드
		System.out.println(a);
		System.out.println(b);
		
		//   ↓↓↓↓↓ 원형
		
		
		//(★★★★★) static 메소드 내에서는 this 키워드를 사용할 수 없다.
		//				> 객체 변수나 객체 메소드를 호출할 수 없다.
		System.out.println(this.a);		//<- this.a
//		System.out.println(this.b); 	//<- this.b 아님. b는 static 변수 :: class 적어야 함
		System.out.println(StaticTest.b);
		
		
		
		bbb();	//부를 수 있음
		StaticTest.bbb();
		
		
		
	}
	
	public static void bbb() {
		
		//정적 메소드
		System.out.println(a);	//a가 에러 남. this.a이기 때문. Static 메소드 안에서는 this를 못 씀
		System.out.println(b);	//b는 static b 이기 때문에 가능. StaticTest.b를 불러온것이라 본 것이기 때문
		
		System.out.println(this.a);
		System.out.println(StaticTest.b);
		
		//(★★★) static 메소드 내에서는 static 변수만 접근할 수 있다.
		
		
//		aaa();	//부를 수 없음. this.aaa이기 때문
		
	}
	
	
	
	
	
	
	
}















