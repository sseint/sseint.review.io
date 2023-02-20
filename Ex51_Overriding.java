package com.test.obd.inheritance;

public class Ex51_Overriding {
	
	public static void main(String[] args) {
		
		//Ex51_Overriding.java
		
		/*
		 * (오버로딩 != 오버라이딩)	
		   // 기술면접때 둘의 차이를 설명하라는 게 나올때도 있음 -> 말도 안되는 질문
		   //  치킨은 왜 맛있고 컴퓨터는 왜 비싸냐? 이런 급의 질문인것임
		 
		  
		 
		메소드 오버로딩, Method Overloading
		- 사전적 의미) 과적하다
		- 메소드 이름 동일 x N개 생성(+인자 리스트)
		
		
		
		
		메소드 오버라이딩, Method Overriding
		- 사전적 의미) 기각[무시]하다. 우선하다.	-> 부모메소드를 무시하고 자식메소드를 우선한다.
		- 클래스 상속시에만 발생
		- 메소드 재정의 > 상속 받은 메소드를 수정하는 기술
		
		
		*/
		
		
		//상황] 길을 가다가 아빠랑 아들을 마주침
		
		OverridingParent hong = new OverridingParent();
		
		hong.name = "홍길동";	//parent 멤버변수 String name에 "홍길동"을 넣어줌
		hong.hello();			//"안녕하세요. 좋은 아침입니다. 저는 홍길동입니다."
		
		OverridingChild jhong = new OverridingChild();
		
		jhong.name = "홍철수";	//parent 멤버변수 String name에 "홍철수"를 넣어서 child로 가져옴
//		jhong.hello();			//"안녕하세요. 좋은 아침입니다. 저는 홍철수입니다."
//		jhong.hi();				//"Hello~ My name is 홍철수"
		jhong.hello();			//<- hi()로 독립했어도 상속받은 hello()가 여전히 남아있어서 사용자는 혼란
								// 		> 자식 객체의 행동을 모호하게 만듦
		
		
		jhong.hello(); 			// - 아빠가 만든 hello()가 아니라 아들이 만든 hello()가 호출됨
								// - 아빠가 만든 hello()는 호출 못함
		//사용자 입장에서는 메소드를 다시 만든 것처럼 보임(수정된 줄 앎) > 메소드를 재정의
		//실제로는 다시 만든 것 X. 메소드를 새로 만든 것임
		//사용자가 볼 땐 형식의 변화가 없으니까 구분이 안돼서 똑같은 메소드가 내용이 바꼈네? > 수정했네?
		
		
		OverridingChild2 yhong = new OverridingChild2();	//다른 자식 클래스에서는 영향 없음. 부모꺼 가져옴
		yhong.name = "홍영희";
		yhong.hello();			//"안녕하세요. 좋은 아침입니다. 저는 홍영희입니다."

		
		
		
	}	//main

}	//main class


//상황] 동네 사람
// - 아빠
class OverridingParent {
	
	public String name;
	
	public void hello() {
		System.out.printf("안녕하세요. 좋은 아침입니다. 저는 %s입니다.\n"
							, this.name);
	}
	
}

// - 아들
class OverridingChild extends OverridingParent {
	
	//4살 꼬맹이 > 시간이 흘러 중 2학년이 됨	>	 아빠가 하는건 다 싫어!!
	//아빠의 인사방식에 불만을 갖기 시작함 > 자기 방식대로 인사를 하고 싶다.
	// 	> 아빠의 방식을 그대로 사용한 이유 : hello()를 상속받았기 때문
	
	//(★★★★★) 클래스 상속 > 부모가 물려준 멤버를 자식이 상속 거부할 능력이 없다.
	//						   > 무조건 100% 상속받아야 함. 부분 상속이란 없음.
	//						   > 상속은 받되 안쓸래!
	//(★★★★★) 부모로부터 상속받은 메소드가 맘에 안든다고, 아래처럼 동일한 일을 하는 메소드를 따로 구현하면 절대 안됨
	//						   > 나중에 객체 사용 시 어떤 메소드가 올바른 메소드인지 구분할 수 없다((★★★★★)	
	
	
//	public void hello() {				<- 아빠랑 똑같아서 독립한 의미가 없음
//	public void hi() {	//자신만의 방식	<- 메소드 이름을 바꿔서 만들음
//		System.out.printf("Hello~ My name is %s\n", this.name);
		
//	}
	
	
	//(★★★) 이제 내가 문제
	//- 이전에는 같은 핏줄인 홍길동과 홍철수가 모두 hello()를 사용해서 인사했었음
	//		> 같은 상속관계에 있는 클래스(객체)는 인사메소드를 할 때 hello()메소드를 쓴다는 규칙
	//- 지금은 같은 집안이라도 달라졌음. 아빠는 hello(), 아들은 hi()
	//		> 외부에서 사용하는 사용자들은 불편해짐(클래스마다 방식이 다르니까)
	
	
	//아빠꺼가 맘에 안들면 내껄 만들긴 해야 함
	//부모가 물려준 메소드와 동일한 형식의 메소드를 선언
	//- 부모의 메소드를 무시하고 자식의 메소드를 사용한다.(무조건 자식 메소드 우선 호출)
	//- 부모의 hello()는 더이상 자식에게는 필요가 없다고 판단.
	public void hello() {	//남들이 헷갈릴거같으면 그냥 아빠가 준거랑 이름을 똑같이 만들음
		
		System.out.printf("Hello~ My name is %s\n", this.name);
		//자식 객체 내에는 hello() 메소드가 2개 있다.
		//- 부모로부터 상속받은 hello()
		//- 자신이 선언한 hello()
	
	
		
	//오버로딩이었으면 매개변수가 달라져야 하는데 매개변수도 똑같이 만들음	
		
		
	}



}

class OverridingChild2 extends OverridingParent {
	
	
}






