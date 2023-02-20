package com.test.obd.inheritance;

public class Ex54_static {
	
	//1. 클래스 로딩, Class Loading
	//- 프로그램을 실행하기 전에, 현재 프로젝트 내의 모든 클래스의 정의를 
	//  미리 읽어서 메모리에 올려놓는 작업을 함  >  설계도를 자바가 인식하는 작업
	//- 설계도를 미리 읽어서 언제든지 사용 가능하게 메모리에 올려놓는 작업
	//- 클래스를 로딩하는 과정 중에 클래스 내부에 있는 모든 static 키워드를 검색
	//		> 메모리에 구현한다.(★★★★★)  <- static이 붙은건 우선 실행함
	
	
	//2. 메인 메소드() 실행
	
	
	
	
	public static void main(String[] args) {
		
		//Ex54_static.java
		
		//상속 얘기 X
		
		/*
		
			static 키워드						
			1. 멤버 변수에 붙이거나
			2. 멤버 메소드에 붙이거나
			3. 클래스에 붙이거나(잘 안 씀)
			
			
			객체 변수 : 개인 데이터. 사람마다 갖고있는 자신의 값(개성, 특성)
			정적 변수 : 공용 데이터.
		
		
		
		
			static 변수 > 공용 변수(정적 변수)		<-> 	객체 변수
			 > 하나의 클래스로부터 만들어진 모든 객체가 공통으로 관리하는 데이터
				> 공용 데이터
		
			객체간에 갖고있는 똑같은 데이터들을 각자 저장하지 않고 하나의 공간에서
			공통적으로 관리하자는 것
			
			우리 학원에 있는 사람들이 공통적으로 갖고있는 
			'사람', '국적(대한민국)'이라는 데이터를 따로 저장할 필요는 없음
			
			
			
			
		
		*/
		
		//상황] 학생 3명	> 300명으로 늘 때
		//- "역삼 중학교" > 절대 규칙 > 개명 > "대명 중학교"
		
		Student.setSchool("역삼 중학교");
		
		
		Student s1 = new Student();
		s1.setName("홍길동");
		s1.setAge(15);
//		s1.setSchool("역삼 중학교");	
		
		Student s2 = new Student();
		s2.setName("아무개");
		s2.setAge(14);
//		s2.setSchool("역삼 중학교");
		
		Student s3 = new Student();
		s3.setName("하하하");
		s3.setAge(16);
//		s3.setSchool("역삼 중학교");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		
	} //main

} //main class

class Student{	//사용빈도 : 객체 멤버 >>> 정적 멤버
	
	//객체 멤버 변수(서로 다 다른 데이터를 갖고있음)
	private String name;
	private int age;
	
//	private String school;
	private static String school;	//<- 변수에 static만 붙이면 됨
	//정적 멤버 변수, 공용 멤버 변수(모든 학생이 다 같은 값을 갖고있는 데이터)
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	public String getSchool() {
//		return school;
//	}
//	public void setSchool(String school) {
//		this.school = school;
//	}
	
	public static String getSchool() {		//getter/setter 에 static 붙음
		return school;
	}
	public static void setSchool(String school) {
		Student.school = school;	//this.school이 아니라 Student.school임
		//new를 선언해서 실행한 애들만 객체 <- this는 객체껄 말하는 것
		//static 영역 안에서는 this라고 해도 누군지 모름. 클래스로 접근해야 하니까
		//객체.변수(this.school)가 아니라 클래스.변수(Student.school) 로 한 것
		//static이 붙은애는 클래스 로딩 과정중에 먼저 만들어놨기 때문에 객체에는 안만들어짐
		//getter/setter 만들때도 static 메소드는 미리 빠졌기 때문에 안만들음
		//-> 객체를 만들때는 static이 안붙은 애들만 만듦
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
	}
	
	
	

}
