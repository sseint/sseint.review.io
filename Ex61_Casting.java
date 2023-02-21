package com.test.obj.cast;

public class Ex61_Casting {
	
	public static void main(String[] args) {
		
		//Ex61_Casting.java
		
		//전자제품 사용 > 배ㅓ리 필요
		
		Duracell b1 = new Duracell();
		
		setPower(b1);
		
		//시간이 흘러... 듀라셀에서 네오로 변경
		Neo b2 = new Neo();
		
//		setPower(b2);	//에러. setPower에는 Duracell을 입력해야하니까
		setPower(b2);	//setPower 메소드를 업캐스팅해서 부모타입으로 변경했으니 하위 클래스인 듀라셀, 네오도 들어갈 수 있음
		
		
		
		//건전지 자판기
		Duracell b3 = getPower();
		
		setPower(b3);
		
		
		
		
		//- 최종적인 입장
		//	- 사용자 입장
		//		- "건전지를 사용한다."
		//		- 듀라셀이든 네오든 중요하지 않음. 전자제품이 동작만 되면 되기 때문에. 건전지면 된다.
		
		//추상화
		//여러 디테일한 점의 공통점을 뽑아서 두루뭉술하게 만든 것 > 행동을 단순하게 만듦
		Battery b4 = getPower(1); // 1을 넣으면 듀라셀, 2를 넣으면 네오가 나오도록
		
		setPower(b4);
		
	} //main
	
	private static Battery getPower(int sel){
		
		if(sel == 1) {
			return new Duracell();
		} else {
			return new Neo();
		}
		
		//서로 다른 자료형을 돌려주는 것임 Duracell 객체와 Neo 객체는 자료형이 다르니까
		
	}
	
	
	
	

	private static Duracell getPower() {
		
		Duracell b = new Duracell();
		
		return b;
	}





//	private static void setPower(Duracell b1) {
	private static void setPower(Battery b1) {
		//private static
		//private : 왜 public이 아닌지? 
		//- 뭔가 잘못됐을 때 피해가 가장 적기 때문에 private으로 하는 것
		//- 자동완성인데 public이면? 외부에 공개되면 안되는 메소드일때 피해볼 수 있음
		//static : static메소드는 static 변수밖에 호출을 못함. main은 static이기 때문에 메소드는 자동으로 static으로 설정
		
		System.out.println("전자 제품이 동작합니다.");
	}

} //main class

class Battery{
	
	public int price;
	public int capacity;
	
	
}




class Duracell extends Battery{
	
	public String color;
	
}


class Neo extends Battery{
	
	public int weight;
	
	
}