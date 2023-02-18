package com.test.obj;

public class Ex39_Class {

	public static void main(String[] args) {
		
		//Ex39_Class.java
		
		User u1 = new User();
		
		u1.name = "홍길동";	//표현법이 변수니까 변수처럼 쓴거고
		u1.age = 20;
		u1.hello();	 //"안녕하세요" <- 이 메소드에 안녕하세요라고 출력하도록 했으니까		
		//메소드니까 메소드처럼 쓴 것
		//바로 hello();로 호출할 수 없음
		
		
		User u2 = new User();
		
		u2.name = "아무개";
		u2.age = 25;
		u2.hello();
		
		
		User u3 = new User();
		
		u3.name = "하하하";
		u3.age = 23;
		u3.hello();
		
		//클래스를 저장한걸 각자 u1, u2, u3라는 이름으로 따로따로 가져옴
		//클래스 :: 사람 / 객체 :: u1 : 사람1, u2 : 사람2, u3 : 사람3 / 변수 :: name/age/hello : 각 사람이 가진 특징
		//클래스에서 정의된 변수들을 가져와서 각 객체마다 데이터값을 넣어줌
		//각 객체가 어떤 걸 하느냐에 따라 결과가 미묘하게 달라짐. 그 사람이 가지고 있는 성대의 길이나 굵기, 직경 등이 다르기 때문에
		
		
		
		
		
		
		
		
	}
	
	
}//class

class User {	//클래스 이름은 파스칼 표기법(대문자로 시작해야함)
	
	//멤버 선언
	//1. 멤버 변수
	//2. 멤버 메소드
	//
	
	public String name;		//이게 개성. 이걸 활용해서 메소드를 만들어야 가치가 올라감
	public int age;
	
	
	//메소드 > 구현 > 개성있는 행동 > 자신만이 가진 데이터를 활용해서 행동해야 함
	public void hello()	{	//왜 static없는지 검사
		
		//static이 있든없든 멤버 메소드라고 함
		
		//변화가 없는 코드 : 정적인 코드 -> 만드나 마나 잘 필요 없음
//		System.out.println("안녕하세요.");
		//hello라는 메소드 코드가 메모리를 만들어서 그 안에 들어가는게 아니라 소스 그대로 heap에 적힘
		//변수 메모리, 메소드 메모리 모두를 다 합쳐서 메모리에 저장하는게 클래스
		
		System.out.printf("안녕하세요. 저는 %s입니다. 그리고 제 나이는 %d살입니다.\n", name, age);
		//클래스에 있는 name, age를 가져옴
		//각각 위에서 User 클래스를 호출한 u1, u2, u3마다 자기가 갖고있는 데이터로 변형을 줌
		//동적이며 결과값이 다 다르게 나오기때문에 가치가 가장 높음
		
		
		//멤버변수가 구현된 행동을 하는게 좋음
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}