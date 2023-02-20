package com.test.obd.inheritance;

public class Ex49_Inheritance {
	
	public static void main(String[] args) {
		
		//Ex49_Inheritance
		
		/*
		객체 지향 프로그래밍, Object Oriented Programming, OOP
		- 클래스 > 객체 중심의 프로그래밍
		
		
		상속, Inheritance	//객체지향 중 가장 어려운 파트
		- 부모가 가지는 재산을 자식에게 물려주는 행동
		
		부모? 자식? 재산?
		- 부모 : 클래스
		- 자식 : 클래스
		
		-> 부모(클래스)가 가지는 재산(멤버 변수, 멤버 메소드)을 자식(클래스)에게 물려주는 행동
		
		**참고
		- 부모 -> 자식 가리킬 수 없음(자식 태어나지도 않음)
		- 자식 -> 부모 가리킬 수 있음(부모 미리 있었음)
		- 클래스 다이어그램 참고
		- 부모에 딸린 자식 클래스는 무제한으로 만들 수 있음
		
		
		상속하는 이유(목적)?
		- 비용 절감
		- 코드 재사용
		- 이전에 만든 클래스와 유사한 부분이 많으면 가져와서 베이스로 삼고 그 위에 확장하는 식으로 클래스 만들기
		
		
		상속 관계에 있는 클래스에 대한 호칭(다 똑같은 말임)
		- 부모 클래스 <- 자식 클래스	(표현 : 상속이라는 표현 때문에)
		- 슈퍼 클래스 <- 서브 클래스	(위치 : 클래스 다이어그램을 보면 부모클래스가 위에 있어서 슈퍼 클래스)
		- 기본 클래스 <- 확장 클래스	(기능 : 기본 베이스를 두고 더 확장, 기능을 다양하게 만들기 때문)
		- 기본 클래스 <- 파생 클래스	(							"								   )
		
		
		
		
		
		*/
		
		Parent p = new Parent();	
		
		p.a = 10;	//Parent의 a에 10을 넣음
		p.b = 20;
		p.ccc();	//Parent의 ccc 메소드를 가져옴
		
		
		
		Child c = new Child();
		
		c.a = 10;	//Child 클래스 안에는 int a, b가 없지만 Parent 클래스가 갖고있는걸 모두 똑같이 쓸 수 있음
		c.b = 20;
		c.ccc();
		
		c.d = 30;
		c.e = 40;
		c.fff();
		
	}
}	//main class


class Parent {		//부모를 정의할때는 자식을 정의할 수 없음(아직 자식이 태어나지도 않았는데 뭔 줄 알고?)
	
	public int a;
	public int b;
	
	public void ccc() {
		System.out.println("ccc");
	}
	
}



//클래스 상속(extends Parent)
//- Child > 자식 클래스
//- Parent > 부모 클래스
//- 부모클래스(Parent)가 가지는 모든 멤버를 자식클래스(Child)에게 물려준다.
//-> 부모클래스가 가진 모든 소스를 자식클래스에게 복사해서 준다(ctrl c, v)
class Child extends Parent {  //Parent = 위에 만든 클래스 이름(부모)
							  //자식은 부모가 미리 만들어져 있기 때문에 누군지를 앎 -> 부모를 지정할 수 있음
	
	
	/* 실제로 Child 안에는 아무것도 안쓰여 있지만 암시적으로는 부모클래스에 있는 걸 모두 갖고 온 것. 
	 * 상속을 받으면 복붙과는 다름. Child는 Child만의 멤버를 또 만듦
	 * Parent에서 가져온 것 + Child가 만든 것
	public int a;
	public int b;
	
	public void ccc() {
		System.out.println("ccc");
	}
	*/
	
//	a = 10; TODO 왜 그대로 a를 바꿀 수 없는거지 Parent에서 int a를 가져왔을 텐데
	
	
	
	public int d;
	public int e;
	
	public void fff() {
		System.out.println("fff");
	}
	
}



//사이트 회원(카페)
//1. 일반 회원
// - 이름
// - 아이디
// - 암호
// - 이메일


//2. 관리자 회원
// - 이름
// - 아이디
// - 암호
// - 등급


//3. 임시 회원
// - 이름
// - 아이디
// - 암호
// - 유효기간(ex. 이 아이디는 일주일만 사용가능~)




/*
class User{				//일반 회원
	
	//생각해야 함 > 이 3개의 변수가 일반회원에도 있고, 관리자회원에도 있는게 우연인가? 필연인가?
	public String name;			//우연도 있긴 하지만 지금은 필연임
	public String id;			//기본으로 유사한 관계 및 필요한 정보이기 때문
	public String pw;			
	
	public String email;
	
	
}
	
class Administrator{	//관리자 회원
	
	public String name;			//반복되는 애들은 최대한 줄여야 함 -> 상속으로 해결
	public String id;			//교집합을 찾은 후 새로운 클래스로 만들어서 부모클래스로 지정해야 함
	public String pw;
	
	public String level;
	
}

			↓↓↓↓↓

*/

class Member {							//부모	<- 자식은 무제한으로 만들 수 있음
	
	public String name;			
	public String id;			
	public String pw;		
	
	
	
}


class User extends Member {				//자식1 - 일반 회원
	
	//부모가 준 재산 상속 받고
	
	public String email;	//User가 추가로 쌓은 재산
	
	
}
	
class Administrator extends Member {	//자식2 - 관리자 회원
	
	//부모가 준 재산 상속 받고
	
	public String level;	//Administrator가 추가로 쌓은 재산
	
}


class Temp extends Member{				//자식3 - 임시 회원
	
	//부모가 준 재산 상속 받고
	
	public String exDate;	//Temp가 추가로 쌓은 재산
	
}








