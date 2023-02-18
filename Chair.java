package com.test.obj;

public class Chair {
	
	private int a;		//멤버 변수 <- 객체를 생성할때 따라오는 변수
	
	//클래스 멤버 변수의 생명 주기
	//- 지역변수는 변수 선언문이 실행될때 변수가 태어남
	//- 멤버변수는 객체를 생성할 때 멤버 변수도 같이 생성
	//- new Chair(); 구문이 실행될때가 변수가 태어남 <- 딱 떨어지게 이렇게 말할 순 없지만 객체를 생성할 때 멤버변수가 생성된다고 보면 됨
	//- 반복문에서는 메소드 블럭이나 제어문이 빠져나갈때 죽음
	
	
	
	
	
	
	
	
	
	public void test(int b) { //지역변수(매개변수)
		
		int c; //지역변수					
		
		//int b;
		
		if (true ) { 
			
			int d;
			
		}
		
		//루프 변수 i의 생명 주기 : for 시작 ~ 끝
		for(int i=0; i<10; i++) {	//10번이 다 실행 되어야 죽음
			
			//for내의 변수 e의 생명 주기 : for 1바퀴 > 시작 ~ 끝
			int e; //i가 한 번 돌때마다 태어나고 끝날때마다 죽음
				   //10번 살아났다가 10번 죽음
			
			
		}
//		while(true) {
//			
//			int i; //while이 끝날때까지 계속 태어나고 죽고 태어나고 죽고
//			
//			
//			
//		}
//		System.out.println(i); 	//for문 밖으로 나갈 수 없음
//		System.out.println(e);
//		
		
		class Test{
		
		
		
			
		//자료형 변수 = 객체생성연산자 생성자();	
		Test t = new Test();		//new는 우리가 건들 수 없는 완성된 것. 그 옆 Test는 우리가 건드려야 함
		
		
		//Sub s = new Sub();
		
		//Test.Sub s = new Test.sub();
	}
		
		//객체(=Object)
		//- 실존하고, 다른 객체와 구분되어지는 객체
		
		
		//인스턴스
		//- 객체
		//- 메모리에 실체화 된 객체
		
		//개발자 입장에서는 객체와 인스턴스를 크게 구분하진 않음
		
		
		
		
		
		
	
}
}		
		
		
		//내부 클래스, 중첩 클래스
		class Sub{
		
		public void ccc() {
			
			Sub s = new Sub();
			
			
		}
		
	
	

}
