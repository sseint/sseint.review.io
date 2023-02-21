package com.test.obj.cast;

public class Ex62 {
	
	public static void main(String[] args) {
		
		//AAA a = new AAA();
		//a.test();
		
		
		BBB b = new BBB();
		
		
		
		
		
	}

}


//상속 + 접근 지정자
class AAA{	//new AAA();
	
	//(★★★)접근 지정자와 상관없이 모든 멤버는 상속된다. -> 상속된다고 private이 public으로 바뀌거나 하지 않음
	public int a;
	private int b;	//상속받은 자식조차 접근불가
	
	
	public AAA(int a, int b) { //만약 그냥 AAA()를 만들면 오류가 없는데 BBB에는 
		super();
		this.a = a;
		this.b = b;
	}

	

	public void test() {
		
		//같은 클래스 내에서는 접근 지정자 > 무의미
		System.out.println(this.a);
		System.out.println(this.b);
	}
	
}


class BBB extends AAA{
	
	public int c;
	private int d;
	
	
	
	public BBB(int c, int d) {
		super(); //개발자가 직접 만드는게 아니라 자바가 어떤 환경을 동작시키기 위해서 자기 스스로 객체 만들일이 있을땐 인자값이 없는채로 생성
				 //TODO 인자가 없어서 에러가 나는것? AAA에 인자있는게 생성돼있었어서 인자가 있는 
		this.c = c;
		this.d = d;
	}








	//상속
	//- a(+), b(-)
	
	public void test() {
		
		//부모로부터 물려받은 a와 b를 출력
		System.out.println(this.a);
//		System.out.println(this.b);	왜 this.a는 보이고 this.b는 안보이는가?
		//a와 b는 자식이 아니라 부모의 울타리 속에 있음. c와 d는 자식의 울타에 포함되어 있음
		//a는 public이니까 다 보임. b는 부모의 울타리 속에 있으니까 사용자가 밖에서 자식을 통해 볼 때 못봄
		//(★★★) 부모에서 private으로 걸어버리면 오로지 본인만 접근 가능. 자식도 접근 불가.
		//getter/setter를 통해서만 자식이 접근 가능
	}
	
}