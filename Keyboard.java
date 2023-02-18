package com.test.obj;

public class Keyboard {
	
	
	
	//클래스의 멤버변수에 붙이는 접근 지정자는 특별한 일이 없는이상
	//1. private으로 지정한다.(웬만하면 private으로 설정 > 유효하지 않은 값이 들어갈까봐)
	//2. public 메소드를 선언 > private 변수를 접근한다.
	
	
	private String model;
	private int price;
		
//	private으로 만들어서 다른 클래스에서 접근을 못하게 함
		
	//외부에서 직접 접근이 불가능한 private 변수를
	//public 메소드가 중간에서 연결 > 일종의 중개인이라고 생각
	
//	public void aaa(String a) {	//메소드 생성 	
//		
//		model = a;  //전부 다 한 클래스 내에서 쓴 것(자기 동네에서 자기꺼 쓴 거)
//					//같은 class 내에선 public, private 상관 없음
//	}
//	
//	
//	
//public String ccc() {
//		
//		return model;
//	}
//	
//	public void bbb(int b)	{
//		
//		//유효성 검사
//		if(b >= 0 && b <= 200000) {
//		price = b;
//		} else {
//			System.out.println("가격 오류!!");
//		}
//		
//	}
//	
//	public int ddd() {
//		
//		return price;
//		
//	}
//		
	
	
	//public void add(String a)
	
	//- set멤버변수명
	//- 쓰기 작업하는 메소드 > Setter 라고 부름 : 감춰줘 있는 멤버의 값을 넣어주는 public 메소드
	public void setModel(String model) {	//매개 변수 = 지역 변수
		
		//멤버변수(model) = 매개변수(model)			무조건 멤버변수(메소드를 다 포함하는 클래스)가 매개변수(메소드)보다 넓음
				model     =     model;	
//			private model	메소드 인자리스트에 있는 model
//			매개변수값에 있는걸 자기한테 덮어씌움 -> 아무 효과 없음
				this.model = model;	//this를 안쓰면 지역변수라는 뜻. this를 붙여야 멤버변수
//			private model	메소드 인자리스트에 있는 model
//				this : 객체 접근(지정) 연산자 > 객체 자신을 가리키는 표현 > "나"
			
			//model > 멤버 변수 vs 지역 변수 > 충돌 발생!!
				
			//서울 사는 홍길동	> 멤버변수
			//역삼동에 사는 홍길동 > 지역변수 > 더 구체적(지역이 더 좁기 때문에)
				
				
			//영역이 좁은 지역 변수가 무조건 이김. 더 디테일하고 구체적인게 이김
			//this.model = model;	-> this를 안쓰면 지역변수 = 지역변수로 됨
			
			//			k2  		  == 			this
			//		  홍길동 		  == 			 나
			//다른 사람이 부르는 이름    내가 스스로를 부르는 이름
			//남이 부르는 나 : 외부의 참조변수를 통해 접근
			//대명사처럼 자기자신을 칭하는 표현을 만들어둠 => this
			//객체 멤버변수를 접근하는 방식
				
				
				
	}
	
	
	
	//- get멤버변수명
	//- 읽기 메소드 > Getter
	public String getModel() {
		
		return this.model;	// this를 가지면 무조건 멤버변수
//	=	return model		// 메소드 이름이 model이 아니라 getModel이라서 충돌이 안나니까
		
	}
	
	
	public void setPrice(int price) {
		
		this.price = price;
		
	}
	
	public int getPrice() {
		
		return this.price;
		
	}
	
	/*
	데이터 집합을 만들어 하나의 세트로, 단위로 관리
	데이터를 넣고 빼는 작업이 오가다 보면 집어넣으면 안되는 데이터를 넣을 수 있음
	사용자의 실수나 문제점을 미연에 방지하기 위해 데이터에 바로 집어넣는걸 할 수 없도록
	public 메소드로 getter나 setter를 세팅해놓고 이 데이터에 올바르지 않은 데이터를 넣었을때
	중간에 개입해서 유효성 검사를 하거나 값을 넣고 뺄때 동반되는 추가적인 통제를 하기 위해
	멤버변수는 private으로 막고 대신 public으로 getter나 setter를 넣어 구체적으로 구현
	*/
	
	
	
	
	
	
	

	}