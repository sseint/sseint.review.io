package com.test.obd.inheritance;

public class Ex53_final {
	
	public static void main(String[] args) {
		
		//Ex53_final.java
		
		
		/*
		
		final 키워드
		- 한 번 결정하면 바꿀 수 없다. > 프로그램의 안정성을 위해 사용
		
		1. 변수 적용
		  - 지역 변수
		  - 멤버 변수
		
		2. 메소드 적용
		  - 상속 + 오버라이딩
		  - 오버라이딩 금지 > 안정성 때문에(맘대로 자식들이 막 바꿔버리면 안되니까)
		  - 부모 메소드에 final을 적용하면 자식 메소드에서 상속받은 부모 메소드를 오버라이딩 할 수 없음
		  - final public int AAA = 3;	final과 접근제어자의 위치가 달라져도 됨. 자료형보다 뒤에는 안됨.
			> = public final int AAA = 3;			> public int final AAA = 3; <- 이건 안됨
		
		3. 클래스 적용
		  - 상속
		  - 상속 금지 > 안정성
		
		
		
		
		
		*/
		
		
		//지역 변수
		int a = 10;
		a = 20;
		a = 30;
		
		final int b = 10;
//		b = 20;			//변경 안됨
//		b = 30;
		
		//이 방식은 비권장 > 일반 변수처럼 보여서
		final int c;
		c = 10;
//		c = 20;
		
		//권장 > 선언과 동시에 초기화
		final int d = 10;
		
		//상수명은 모두 대문자로 작성 > 변수와 구분짓기 위해서
		final double PI = 3.14;
		
		
		FinalChild child = new FinalChild();
		
		child.test();
		
		
		
	} //main

}


class Gender {
	
	//남자(1), 여자(2)
	public final int MALE = 1;			//멤버변수에도 final을 붙일 수 있다
	public final int FEMALE = 2;
	
	
	
	public Gender() {
		
		//this.MALE = 3; <- 불가능. 멤버변수에서 이미 1로 설정함
		
	}
	
	
}



class FinalParent {
	
	//부모 클래스 설계중...
	//- test() 메소드 선언 > 나중에 혹시 이 클래스를 상속받는 클래스가 test()메소드를 
	//						 재정의(오버라이딩)하면문제가 발생할 것 같음
	
	public final void test() {
		System.out.println("부모가 만든 메소드");
		System.out.println(num()); 	//100 출력
	}
	
	public final int num() {
		return 100;
	}
	
	
}




class FinalChild extends FinalParent {
	
	//이클립스를 가지고 오버라이딩(부모 이름이랑 똑같은 메소드를 만드는 것) 할 때는
	//ctrl + space > test() : void 등 목록으로 뜸 > 찾아서 자동 입력
//	@Override
//	public void test() {
//		
//		System.out.println("자식이 재정의한 메소드");
//		System.out.println(num());
//		super.test();
//	}
	
	//Cannot override the final method from FinalParent
//	public int num() {		//부모 메소드에 final을 달아버리면 오버라이딩 할 수 없음
//		return 200;
//	}
	
	
}


//이 클래스가 누군가의 부모클래스가 됐을때 이 클래스가 부모 역할을 잘 할 수 있는가?
//클래스 선언 중 누군가의 부모역할이 되는것에 자신이 없을 때 > 상속 못하게 금지시킬 수 있음
final class FinalMember {	//class 앞에 final을 붙이면 누군가의 부모가 될 수 없음
							//final 처리 하면 절대적인 처리 속도가 빨라짐 > 큰 의미는 X
	
	
}

//The type FinalUser cannot subclass the final class FinalMember
class FinalUser extends FinalMember {	//FinalMember를 상속받을 수 없음
	
	
	
}



