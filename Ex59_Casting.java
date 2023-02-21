package com.test.obj.cast;

public class Ex59_Casting {
	
	public static void main(String[] args) {
		
		//Ex59_Casting.java
		
		
		/*
			형변환, Type Casting
			- 값형과 참조형끼리는 형변환 불가능
			
			1. 값형 형변환, Value Type Casting
				- 값형끼리의 형변환
				- int > double
				- char > int
				
				
			
			2. 참조형 형변환, Reference Type Casting
				- 참조형끼리의 형변환
				- 상속 관계에 있는 클래스끼리의 형변환 > 직계만 가능(방계는 불가능) <- 형제나 사촌간 형변환은 불가능
				- A클래스 > B클래스
				
				1. 업캐스팅, Up Casting
					- 암시적인 형변환
					- 자식 클래스 > (형변환) > 부모 클래스
					- 100% 안전
					- 형제뻘 되는 클래스들을 부모클래스로 불러서 한 번에 관리
				
				2. 다운캐스팅, Down Casting
					- 명시적인 형변환
					- 부모 클래스 > (형변환) > 자식 클래스
					- 100% 불가능한 작업
					- But, 조삼모사 방법은 가능(실제로 많이 씀)
					- 코드의 유연성 부여 > 팁처럼 사용
					- 자식을 만들어서 부모로 형변환 했다가 다시 자식으로 만드는 건 가능
		*/
		
		
		Parent p1 = new Parent();
		p1.a = 10;
		p1.b = 20;
		
		Child c1 = new Child();
		c1.a = 10;
		c1.b = 20;
		c1.c = 30;
		c1.d = 40;
		
		Parent p2;
		Child c2;
		
		c2 = new Child();	//원본
		
		//복사
		//Parent = Child	-> 왼/오 자료형이 다르면 안됨
		//에러가 안남 <- 암시적 형변환이 일어난 것
		//부모 클래스 = 자식 클래스		<- 자식클래스를 부모클래스 형태로 바꿈
		//업캐스팅(아래에서 위로 올라가서 형태를 바꾼거니까)	> 문제가 없음
		p2 = c2;
		p2 = (Parent)c2;	//원형
//		c2가 가지고 있던 주소값을 p2가 가질 수 있게 됨
		
		//복사 완료 > 제대로 복사가 됐는지 검증? > 복사본의 멤버가 모두 올바르게 사용되는지 확인?
		
		
		p2.a = 10;
		p2.b = 20;
//		p2.c && p2.d 는 안보임. 못불러옴
		//개발자는 stack에는 들어갈 수 있어도 Heap에는 못들어감. 오로지 stack에 있는것만 보임
		//Parent를 가지고 도착한 heap은 c2를 통해서 오면 인지하기를 내가 접근할 수 있는 객체는 child자료형을 가진 클래스구나 라고 인식함(int a, b, c, d를 다 접근할 수 있는 권한이 있는)
		//p2를 통해서 오면 개발자 눈에는 Parent 객체를 갖고 있다고 보기 때문에 parent자료형(a, b만 있는)을 가진 클래스를 통해 heap에 갈 수밖에 없음
		//TODO child의 c, d를 못가져올거면 왜 형변환 하는거지?
		
		
		
		System.out.println(p2.a);
		System.out.println(p2.b);
		
		
		
		
		
		
//		Parent p3;
//		Child c3;
//		
//		p3 = new Parent();	//원본
////		c3 = p3;	//Type mismatch: cannot convert from Parent to Child : 명시적 형변환 하라
//		
//		
//		//복사
//		//명시적인 형변환
//		//자식클래스 = 부모 클래스
//		//다운 캐스팅 ( 부모클래스를  자식클래스로 바꾼거니까 )
//		c3 = (Child)p3;
//		
//		//검증 > 눈 앞에 있는 c3를 사용하는데 지장이 없는지 사용?
//		c3.a = 10;
//		c3.b = 20;
//		c3.c = 30;
//		c3.d = 40;
//		
//		//c3를 만들면 p3의 a, b만 있는 Heap 객체의 주소값을 가짐 > p3는 c, d가 없기 때문에 c3에서 가져올 수 없음
//		// -> 개발자가 볼땐 c3에 4개(a, b, c, d)가 있다고 봤는데 불러오니까 2개(a, b)만 불러오고 나머지 2개(c, d)는 못불러옴
//		// 			> c3 전체가 문제다 라고 인식 
//		
//		
//		//런타임 에러
//		//java.lang.ClassCastException: class com.test.obj.cast.Parent cannot be cast to class com.test.obj.cast.Child
//		//Parent를 Child로 형변환 할 수 없다
//		System.out.println(c3.a);
//		System.out.println(c3.b);
//		System.out.println(c3.c);
//		System.out.println(c3.d);
		
		
		
		
		/*
		
		업캐스팅 : c3(자식) -> p3(부모)
		p3 = c3 일때 난 p3를 통해 c3를 가져온 건데 p3에는 변수가 2개, c3에는 변수가 4개 있더라도 p3를 통해 볼 수 있는 2개밖에 못봄
		
		다운캐스팅 : p3(부모) -> c3(자식)
		반대로 c3 = p3일 때 난 c3를 통해 p3를 가져온 건데 c3에는 변수가 4개 있어도 p3에 2개뿐이니까 가져올 수 있는건 p3의 2개뿐
		근데 난 c3를 통해 보는거니까 4개있을거라 기대했는데 2개밖에 못가져온다? 하자 있네 라고 인식
		
		
		
		*/
		
		
		
		Parent p4;
		Child c4;
		
		c4 = new Child(); //원본
		
		//업캐스팅 : 자식이 부모 형태로 변환(암시적 변환) (100% 안전)
		p4 = c4; //부모껍데기를 통해 찾아가면 자식이 있음
		
		
		
		Child c5;
		
		//자식 = 부모
		//다운캐스팅 : 부모가 자식 형태로 변환(명시적 변환만 가능)
		c5 = (Child)p4;	//실제로는 Child 객체를 다시 Child 변수로 참조한것 뿐
		//c4 -> p4 -> c5  :: c4 -> c5 처음에 p4를 c4로 형변환 만들어 놓았고 그 후 c5를 p4로 참조한것 = c5를 c4로 형변환..?
		//TODO 이해가 안감
		
		
		
		c5.a = 10;
		c5.b = 20;
		c5.c = 30;
		c5.d = 40;
		
		System.out.println(c5.a);
		System.out.println(c5.b);
		System.out.println(c5.c);
		System.out.println(c5.d);
		
		
		
		
		
		
		
		
		
		
	} //main

} //main class





class Parent{
	
	public int a;
	public int b; 
	
}


class Child extends Parent{

	public int c;
	public int d;
	
	
}














