package com.test.obj;

public class Cup {
	
	private String color;
	private int weight;
	private int price=100;
	
	//setter getter를 무작정 만드는것도 아님
	public void setColor(String color) {
		this.color = color;					
		// 내가 이해한 것 : private으로 가려져 있던 String color를 set메소드에서 호출하면 
		// main 클래스에서 setColor 메소드를 가져와서 입력값을 넣게 만들고,
		// 메인 메소드에서 setColor 메소드를 가져가서 값을 입력하면 여기 setColor 안의 color에 메인에서 넣은 입력값이 들어가고
		// 멤버변수 color에 메인에서 입력한 color값이 들어가는 것?
		// 그리고 get메소드에 그 값을 돌려주도록 하면 메인에서 getter로 남들 다 볼 수 있게 불러올 수 있다?
		
		
//		-> 멤버변수에 저장되지는 않는것? -> c1에서만 쓸 수 있음
//		   c2에서 꺼내올떄는 값이 초기화 되어있어서 다시 넣어야 함
		
		
		
		
		// TODO 그럼 지역변수 color는 왜 만들지 그냥 기본값..? 여기있는 color는 사실 private으로 감춰져있던 color다 라는 뜻?
		// TODO 꼭 멤버변수 먼저 쓰고 = 지역변수 써야하는지? 그런듯
								
	}
	
	//color > Setter + Getter
	public String getColor() {
		
		return this.color;
	}
	
	//weight > Setter			//// > getter가 없으니 값을 보여줄 수 없어서 그냥 쓰기전용
	public void setWeight(int weight) {
		
		this.weight = weight; 	//weight는 private으로 숨겨져있던 weight이란 뜻인가..?
	}							// TODO 어차피 메인에서 읽지 않을건데 왜 Setter를 만드는지? 
								// 		일단 값을 넣으면 멤버변수에 그 값이 저장되어있고 언젠가 꺼내서 쓸 날을 위해서?
								//	-> 멤버변수에 저장되는거 X c1에서 값을 넣었으면 c1에서만 나중에 꺼내쓸 수 있음
	
	//price > Getter			// > setter가 없으니 값을 넣을 수 없어서 그냥 읽기전용
	public int getPrice() {		
		
		return this.price;		// > TODO return으로는 멤버변수만 돌려줘야 하는건가? 지역변수는 그냥 Setter에서 입력값 넣는 용도로만 쓰이고 끝?
	}							// > TODO 메인에서 Setter를 통해 값을 넣고 그걸 멤버변수에 저장 후 Getter로 메인에 가져가거나
								//		  혹은 Setter가 없었으면 Getter에 초기값을 설정 후 메인에서 호출 시 초기값을 가져가기?
//									-> 멤버변수에 저장하는게 아님 c1에서 넣은 값은 c1전용으로만 저장되고 c2에서는 다시 값을 넣어야 함 붕어빵틀만 만들어준거라고 생각하면 됨
	//Getter
	public int getLevel() {
		
//		멤버변수에 getLevel이란게 없음
		
		if(this.weight < 500 && this.price < 1000) { //500g 미만, 1000원 미만
			return 1; //등급
		} else if (this.weight < 700 && this.price < 5000) {
			return 2;
		} else {
			return 3;
		}
		
		
	}
	
	
	
	
	
	
	

}
