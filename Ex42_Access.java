package com.test.obj;


public class Ex42_Access {
	
	public static void main(String[] args) {
		//Ex42_Access.java
		
		Cup c1 = new Cup();
		
		c1.setColor("white");				// > 읽기, 쓰기 모두 가능한 멤버 > 프로퍼티
		System.out.println(c1.getColor());
		
		
		//Setter > 쓰기 전용 멤버	> 쓰기 전용 프로퍼티
		c1.setWeight(500);			//setWeight에 500을 넣음
//		System.out.println(c1.get); // getter가 없어서 불러올 수 없음
		
											
		
		//Getter > 읽기 전용 멤버 > 읽기 전용 프로퍼티
		System.out.println(c1.getPrice());  //100. price의 멤버변수에서 초기값을 100으로 넣었기 때문에 100이 나옴
											// > 읽기 전용 멤버
		
		
		//계산된 프로퍼티
		System.out.println(c1.getLevel());
		//private에 getLevel이 있다고 생각할 수 있는데 실제로는 없음
		// > 실제로 멤버안에 어떤 멤버가 있는지 밖에서는 알수가 없음
		//  	> 밖에서 알 필요 없다는 뜻
		
		
		
		//자바 용어	> 자바 공식 도움말
		//- c1.type 		> field(필드) : public 변수
		//- c1.getType() 	> property(프로퍼티) : private 변수를 가져오는 setter/getter를 말하는 것
		
		
		
		
		
		
		//new Chair(); > 멤버 변수 생성
		
		//c2(main)의 지역 변수
		Chair c2 = new Chair();	//멤버변수 > 세트(집합)
		//객체안에 들어있던 멤버변수들은 main메소드가 끝날때 사용했던 모든 지역변수가 소멸되는데,
		//c2인 지역변수만 소멸되는거지 객체는 안죽음
		//객체는 모든 참조값이 끊기는 순간 가비지가 되고 가비지 컬렉터가 수거(객체를 소멸시킨다)하는 순간이 메모리에서 사라짐
		//가비지 컬렉터가 언제 올지는 모름
		
		//멤버변수 > 세트(집합)
		
		
		//지역변수 > 단독
		int a;
		
		
		
		
	}
	
	
	
	

}
