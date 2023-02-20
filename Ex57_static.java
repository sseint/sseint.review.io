package com.test.obd.inheritance;

public class Ex57_static {
	
	public static void main(String[] args) {
		
		//Ex57_static.java
		
		//요구사항]
		//1. 펜을 생산하세요. > class Pen > new Pen()...
		//2. 생산된 펜의 개수를 세시오.
		
		//Case 1.
		//- 간편함
		//- Pen과 count 변수 간의 관계가 매우 약함 > 둘의 연관성이 낮다.
		//- 중간에 빼먹어도 에러가 안나서 에러 발견을 못함
		/*
		int count = 0; //누적 변수
		
		Pen p1 = new Pen("MonAmi", "black");
		count++;
		
		Pen p2 = new Pen("MonAmi", "black");
		count++;
		
		Pen p3 = new Pen("MonAmi", "black");
		count++;
		
		System.out.println("볼펜 개수: " + count);
		*/
		
		
		//Case 2.
		//- Pen 클래스와 count 변수간의 관계를 강하게 연결
		//- count 변수가 객체마다 존재 > count를 개인 데이터로 취급
		//		> count는 개인 데이터가 아니다!! > 공용 데이터임
		/*
		Pen p1 = new Pen("MonAmi", "black");
		p1.count++;
		
		Pen p2 = new Pen("MonAmi", "black");
//		p2.count++;
		p1.count++;
		
		Pen p3 = new Pen("MonAmi", "black");
//		p3.count++;
		p1.count++;
		
		System.out.println("볼펜 개수: " + count);	//p1.count? p2.count? p3.count?
		//자기 혼자 한 명이라고만 센 것. 전체를 count한 게 아님
		//p1.count를 선택해 모두에게 적용해 하나씩 셈 > 왜 p1을 선택해야 함? > 정당성이 없음
		*/
		
		
		//Case 3. count를 static으로 만들기
		//- Pen 클래스와 count 변수간의 관계를 강하게 연결
		//- 공용 데이터 성격으로 count를 만듦 > static
		//- 가장 좋은 방법
		//- 문제점 : Case 1처럼 중간에 한 개를 누락해도 에러를 못잡아냄. 개수가 안맞아도 그냥 출력 됨
		/*
		Pen p1 = new Pen("MonAmi", "black");
		Pen.count++;
		
		Pen p2 = new Pen("MonAmi", "black");
		Pen.count++;
		
		Pen p3 = new Pen("MonAmi", "black");
		Pen.count++;
		
		System.out.println("볼펜 개수: " + Pen.count);
		*/
		
		
		//Case 4. 최종형태
		//- count++ 누락 방지
		//- 1. 객체를 만든다 2. count를 센다 -> 한 셋트로 합침
		Pen p1 = new Pen("MonAmi", "black");
		
		Pen p2 = new Pen("MonAmi", "black");
		
		Pen p3 = new Pen("MonAmi", "black");
		
		System.out.println("볼펜 개수: " + Pen.count);
		
		
		
		
		
		
	}//main

}//main class


class Pen {
	
	private String model;
	private String color;
	
	public static int count; //누적변수
	
	
	//정적 생성자	> static이 있는 생성자	> // 정적 멤버만 초기화(static이 붙은 애들만 초기화)
	static {		//우리가 못부름. 자동으로 생성되는 애임
		
		Pen.count = 0;		
		
	}
	
	
	
	
	
	//객체 생성자	> static이 없는 생성자	> 객체 멤버만 초기화(this가 붙은 애들만 초기화)
	public Pen(String model, String color) {				//<- 생성자 : 멤버변수 초기화
		
		
		this.model = model;
		this.color = color;
		
		Pen.count++; //펜을 만들 때마다 +1	//case 4.
		//초기화(X), 업무(O)
		
	}


	@Override
	public String toString() {
		return "Pen [model=" + model + ", color=" + color + "]";
	}



	
	
	
	
	
	
}
