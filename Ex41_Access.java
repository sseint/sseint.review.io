package com.test.obj;

public class Ex41_Access {
	
	public static void main(String[] args) {
		
		//Ex41_Access.java 여기부터 중요!!!
		
		//Ctrl + Tap : 탭간 이동
		//Window + Preference + Keys : 단축키 설정
		
		
		/*
		접근 지정자(제어자), Access Modifier
		- 클래스 멤버 변수에 붙여 사용한다. 	public int a = 100;
		- 클래스 멤버 메소드에 붙여서 사용한다. public static void method();
		- 클래스 자체에 붙여서 사용한다.		public class Ex41_Access
		- 멤버를 외부에 노출할지 말지 결정하는 역할
		- 멤버의 노출 수위를 조절하는 역할 > 외부에 공개할지 말지 공개여부를 조절하는 역할
		- 어디를 경계(★★★)로 공개할지 말지를 결정하는지? > 클래스가 경계선 역할
		
		
		1. public 		> 외부에 100% 공개
		2. private		> 외부에 100% 비공개
		--------------
		3. protected
		4. default
		
		*/
		
		
		//생성자 -> 객체 초기화를 위해 씀
		Book b1 = new Book();
		
		b1.a = 10;
//		b1.b = 20;	//The field Book.b is not visible	//field Book.b가 보이지 않음
					//b를 field라고 부름 .계열에 length변수를 자바에서는 필드라고 불렀음
					//b라는 필드가 있는데 안보임
		
//		b1.c = 30;	//c cannot be resolved or is not a field
					//c라는 필드가 없음
					//있는데 안보이는게 아니라 c는 아예 존재하지 않음
			
		System.out.println(b1.a);
//		System.out.println(b1.b);
		
		//b1을 통해 a를 찾아서 10을 넣음(public 선언되었기 때문에)
		//b1을 통해 b를 찾아서 20을 넣으려 함. 근데 안보임(private 선언되었기 때문에)
		
		
		
		
		
		//키보드
		Keyboard k1 = new Keyboard();
		
//		k1.model = "K810";
//		k1.price = 150000;
//		
//		System.out.println(k1.model);
//		System.out.println(k1.price);
		
		
		
		
		Keyboard k2 = new Keyboard();
		
//		k2.model = "K380";
//		k2.price = 2000000000;	//컴파일 에러(X), 런타임 에러(X), 그러나 올바른 가격인가? -> 클래스 설계를 잘못한 것
//								//물리적으로 String이나 int를 벗어나지 않으면 프로그램으로서 문제 X
//								//private으로 설정해놔서 다른 클래스로 가져올 수 없음
								//변수를 직접 받아옴
//		
//		System.out.println(k2.model);
//		System.out.println(k2.price);
		
//		k2.aaa("K380");			//메소드를 통해 받아옴
//		k2.bbb(-35000);			//가져온 메소드에서 가격범위를 설정해놓음 Keyboard 참고
		
//		System.out.println(k2.ccc());
//		System.out.println(k2.ddd());
		
		
		k2.setModel("K380");
		//.을 찍으면 model, price 안보임(private이니까)
		System.out.println(k2.getModel());	//K380
		
		k2.setPrice(20000);
		System.out.println(k2.getPrice());	//20000
		
		
	} //main
	
	
	
	
	
	
	

} //class
