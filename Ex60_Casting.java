package com.test.obj.cast;

public class Ex60_Casting {

	public static void main(String[] args) {
		
		//Ex60_Casting.java
		
		//총 결론] 업캐스팅 사용 예
		//업캐스팅은 형제뻘 클래스들을 부모 클래스를 통해 한 번에 관리하고 싶을 때 씀
		
		
		//상황] 대리점 운영 > 프린터 판매
		//1. HP600 * 5대, LG500 * 3대의 프린터가 있다고 할 때
		//2. 주기적으로 제품을 점검함(반복 행위)	
		
		//목적] 제품들을 주기적으로 점검할 때 어떻게 더 효율적으로 할지?
		//변경사항] 재고 증가 HP600 > 500대, LG500 > 300대	//case 2, case 3
		//변경사항] 브랜드 증가 > BenQ, ASUS, MS...			//case 3
		//변경사항] 점검 기능 > print(), selfTest(), call()
		
		
//		m1();
//		m2();	//재고가 늘어날때는 효율적이나 브랜드가 증가할때는 비효율
		m3();	//재고, 브랜드 증가할 때 효율적
		//(★★★★★) m3() 케이스는 잘 유의해야 함. 
		
	} //main
	
	
	private static void m1() {
		
		//Case 1. 너무 반복이 많음
		
		//재고 HP600*5, LG500*3 확보
		HP600 hp1 = new HP600("black", 250000, "ink");
		HP600 hp2 = new HP600("black", 250000, "ink");
		HP600 hp3 = new HP600("black", 250000, "ink");
		HP600 hp4 = new HP600("black", 250000, "ink");
		HP600 hp5 = new HP600("black", 250000, "ink");
		
		LG500 lg1 = new LG500("white", 350000, "lazer");
		LG500 lg2 = new LG500("white", 350000, "lazer");
		LG500 lg3 = new LG500("white", 350000, "lazer");
		
		//점검 * 반복(주기적으로 한다 생각)
		//프린트 기능이 잘 작동하는지?
		hp1.print();
		hp2.print();
		hp3.print();
		hp4.print();
		hp5.print();
		System.out.println();
		
		lg1.print();
		lg2.print();
		lg3.print();
		
	}
	
	private static void m2() {
	
		//Case 2. 배열
		//배열은 같은 자료형만 저장 가능
		//HP600 hp1 != LG600 lg1 자료형이 달라서 불가능
		//각각의 배열을 만들어야 함
		
		//재고 확보
		HP600[] hps = new HP600[5];
		
		for(int i=0; i<hps.length; i++) {
			hps[i] = new HP600("black", 250000, "ink");
		}
		
		
		LG500[] lgs = new LG500[3];
		
		for(int i=0; i<lgs.length; i++) {
			lgs[i] = new LG500("white", 350000, "lazer");
		}
	
		
		//점검 > 브랜드 1개 > 루프 1개
		for(int i=0; i<hps.length; i++) {
			hps[i].print();
			hps[i].selfTest();
		}
	
		for(int i=0; i<lgs.length; i++)	{
			lgs[i].print();
			lgs[i].call();
		}
	
	}
	
	private static void m3() {
		
		//Case 3. 형변환 사용
		//
		
		HP600 hp = new HP600("black", 250000, "ink");
		
		LG500 lg = new LG500("white", 350000, "lazer");
		
		Printer p1; //부모클래스
		
		
		//부모 = 자식	-> 자식을 부모로 바꿈
		//업캐스팅
		p1 = hp;	//hp타입 변수를 Printer 타입 변수에 넣은것임
		
		Printer p2 = lg;
		
		//업캐스팅
		p2 = lg;	//lg타입 변수를 Printer 타입 변수에 넣은것임
		
		Printer[] list = new Printer[2];
		list[0] = hp;
		list[1] = lg;
		
		//Printer list 배열은 HP와 LG를 한 번에 담은 배열이 됨
		//형변환을 이용했기 때문
		//형제뻘 객체들을 부모타입에 한 번에 넣을 수 있게 됨
		
		
		Printer[] ps = new Printer[8];	//HP 5대와 LG 3대를 한 번에 관리
		
		for(int i=0; i<ps.length; i++) {
			
			//앞 다섯대는 HP, 뒤 세대는 LG
			if( i < 5) {
				ps[i] = new HP600("black", 250000, "ink");
			} else {
				ps[i] = new LG500("white", 350000, "lazer");
			}
			
		}	//Printer ps 배열에 HP와 LG를 넣어줌
		
		
		//점검
		for(int i=0; i<ps.length; i++) {
			
			ps[i].print();	//에러남. ps[i]는 Printer 라는 껍데기. ps가 있는 Printer에는 print()메소드가 없음 
			//Printer에 print()메소드를 넣어주면 됨. 하지만 안에 빈 상태로 두면 자식 메소드들이 오버라이딩해서 지가 가진걸 내놓음
			//부모메소드가 둥지만 만들어주면 자식들이 알멩이는 알아서 채움
			
//			ps[i].	//selfTest(), call() 메소드가 없음 -> 부모 클래스에는 껍데기가 없기 때문
			
			
			//다운 캐스팅 > 평소에는 형제들과 같이 부모 배열에 넣어서 관리하다가 자식만이 가지는 고유기능을 사용해야 할 때
			//	> 다운 캐스팅을 사용해서 원래 타입 참조 변수로 형변환
//			if(i < 5) {
//				HP600 hp1 = (HP600)ps[i];
//				hp1.selfTest();		//안보였던 selfTest()메소드를 보여주기 위해서 다운캐스팅
//			//[i]가 5바퀴까지는 HP지만 6바퀴째부터는 LG로 바뀜
//			} else {
//				LG500 lg1 = (LG500)ps[i];
//				lg1.call();
//			}
			
//			System.out.println(ps[i] instanceof HP600);
			//앞에는 객체 변수, 뒤에는 클래스가 옴 : 앞에있는 객체가 뒤에있는 클래스타입의 인스턴스냔?
			//앞에있는 애를 뒤에 있는 변수에 집어넣을 수 있냐?
			//앞과 뒤의 자료형이 일치하면 true, 다르면 형변환을 해서라도 집어넣을 수 있냐? true
			//아무리 형변환해도 앞에있는걸 뒤에있는 타입에 못넣는다 하면 false
			//i가 5바퀴 돌때까지는 HP니까 HP600이 가능 -> true
			//i가 6바퀴부터는 LG니까 HP600에 못넣음 -> false(LG500 != HP600이니까 LG는 못넣음)
			
			if(ps[i] instanceof HP600) {
				HP600 hp1 = (HP600)ps[i];
				hp1.selfTest();
			} else if(ps[i] instanceof LG500) {
				LG500 lg1 = (LG500)ps[i];
				lg1.call();
			}
			
			//연산자
			//System.out.println(ps[i] instanceof HP600);
			
			
			
		}
		
		//한 번에 몰아서 쓰고싶다 > 업캐스팅(개성이 사라짐)
		//한 번에 몰아서 쓰다가 내 개성 표출하고 싶다 > 다운캐스팅(업캐스팅 후 다운캐스팅)
		
		
		
		
		
	}
	
	
} //main class


class Printer{		//HP와 LG의 공통적인 일을 수행하는 부모 클래스
	
	private String color;
	private int price;
	private String type;
	
	
	public Printer(String color, int price, String type) {
		super();
		this.color = color;
		this.price = price;
		this.type = type;
	}
	
	//둥지(껍데기)만 만들어주면 자식메소드들이 오버라이딩으로 알멩이 채움
	public void print() {
		//내용물은 없음.
	}
	
	
}







class HP600 extends Printer{
	
//	private String color;			//LG500과의 공집합이라 부모 클래스로 올림 > 어차피 균일하게 상속받음
//	private int price;
//	private String type;
	
	
	public HP600(String color, int price, String type) {
		super(color, price, type);
//		this.color = color;
//		this.price = price;
//		this.type = type;
	}


//	@Override
//	public String toString() {
//		return "HP600 [color=" + color + ", price=" + price + ", type=" + type + "]";
//	}
	
	public void print() {
		
		System.out.println("HP600으로 출력합니다.");
		
	}
	
	public void selfTest() {
		
		System.out.println("HP600의 자가진단을 시작합니다.");
		
	}
	
	
}	//HP600 class







class LG500 extends Printer{
	
//	private String color;
//	private int price;
//	private String type;
	
	
	
	public LG500(String color, int price, String type) {
		super(color, price, type);
//		this.color = color;
//		this.price = price;
//		this.type = type;
	}



//	@Override
//	public String toString() {
//		return "LG500 [color=" + color + ", price=" + price + ", type=" + type + "]";
//	}
	
	
	public void print() {
		
		System.out.println("LG500으로 출력합니다.");
		
	}
	
	public void call() {
		
		System.out.println("인공지능 AI와 연결합니다.");
		
	}
	
	
}























