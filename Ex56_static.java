package com.test.obd.inheritance;

public class Ex56_static {
	
	public static void main(String[] args) {
		
		//Ex56_static.java
		
		StaticStudent.setSchool("역삼 중학교");
		
		
		StaticStudent s1 = new StaticStudent();		//<- new를 만드는 것이 객체를 만드는 것 : this.x 를 만듦
		s1.setName("홍길동");
		
		StaticStudent s2 = new StaticStudent();
		s2.setName("아무개");
		
		
		
		//hello() 앞에 s1이 적혀있다.
		// > s1이라는 학생이 인사를 합니다. 		-> 개인이 하는 행동
		s1.hello(); 				//안되고(안되는건데 자바만 빨간줄 안쳐주는 것)
		//stack -> heap을 가서 hello를 찾지만 hello는 static에 있어서 못찾음
		
		
		
		
		//hello() 앞에 Student가 적혀있다.
		// > 학생(Student) 전체가 인사를 합니다. 	-> 집단이 하는 행동(대표)
		StaticStudent.hello(); 		//되고
		//아예 애초에 stack -> class가서 hello를 찾으면 있음
		
		
//		개인행동을 하고 싶으면 static 이 안붙은 메소드를 만들어야 함
//		집단이나 대표 행동을 하고 싶으면 static이 붙은 변수와 메소드를 만들면 됨
		
		
	}

}


class StaticStudent{
	
	private String name;			//개인 데이터
	private static String school;	//공용 데이터
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getSchool() {
		return school;
	}
	public static void setSchool(String school) {
		StaticStudent.school = school;
	}
	
	
	
	//학생에게 인사하는 메소드
	public static void hello() {		//static 붙일 수 없음. static 영역 안에서는 this.xx를 붙일 수 없기 때문
	//static이 붙으면 hello()는 정적메소드가 됨. -> 클래스를 붙여야 호출이 됨
		
		
//		System.out.printf("안녕하세요. 저는 %s입니다."
//									, this.name);	//this.xx : 개인 데이터. 서로 다른 이름을 가질 수 있음
		//static(집단)이 붙은 메소드에 개인이 하는 행동을 붙여놨다? 말이 안됨
		
		System.out.println("안녕하세요. 역삼중학교에 오신걸 환영합니다."); 
		//개인을 특정짓는 표현 X. 집단 내용이기 때문에 static에 사용 가능
		
		
	}
	
	public void hello2() {
		
//		System.out.println("안녕하세요. 역삼중학교에 오신걸 환영합니다.");
		//이것도 안맞음. 개인을 특정짓는 메소드에 대표가 할 만한 말을 하는 것은 문제가 있음
		
		System.out.printf("안녕하세요. 저는 %s입니다.", this.name);
		//개인만이 할 수 있는 인사. 얘는 static을 안붙이고 객체 메소드를 만들어서 붙일 수 있음
		
		System.out.printf("저는 %s에 다녀요.", StaticStudent.school); 	//공용데이터지만 붙일 수 있음
		//개인으로 보면 내가 다니는 학교이기도 하니까 개인데이터의 성질도 갖고 있음.
		//개인이 하는 일에는 정적 메소드도 쓸 수 있도록 오픈 시켜놓음. 객체 데이터처럼 취급 가능하기 때문
		
	}
	
	
	
	
}