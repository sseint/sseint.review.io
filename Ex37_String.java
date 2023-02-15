package com.test.java;

public class Ex37_String {
	
	public static void main(String[] args) {
		
		//Ex37_String.java
		
		//모르면 창피할 상식 같은 것
		
		//문자열 성질을 제대로 알기 위한 수업
		
		//1. 메모리의 공간은 한 번 할당되면 더 이상 늘리거나 줄일 수 없다.
		//2. "문자열은 불변(Innutable)이다." > 한 번 만들어진 문자열은 절대 수정할 수 없다.
		//3. 문자열은 참조형이다. 
		
//		m1();		//문자열의 성질
//		m2();		//문자열 대상 하면 안되는 행동
//		m3();		//해결책
//		m4();		//String vs StringBuilder
		
		
		
		
		
		
	} //main
	
	private static void m4() {
		
		// String vs StringBuilder
		
		//long begin = System.currentTimeMillis();
		long begin = System.nanoTime(); //10억분의 1초 단위
		
		
		String txt1 = "홍길동";
		
		for(int i=0; i<100000; i++) {
			
			txt1 = txt1 + "."; //잦은 수정
			
		}
		
		long end = System.nanoTime();
		
		System.out.println(txt1.length()); //100003
		System.out.println(end - begin + "ns"); //4.5s
		//순수 문자열을 조작했을때의 상황
		
		
		begin = System.nanoTime();
		
		StringBuilder txt2 = new StringBuilder("홍길동");
		
		for(int i=0; i<100000; i++) {
			txt2.append(".");	//txt2 = txt2 + "."
		}
		end = System.nanoTime();
		
		System.out.println(txt2.length());  //100003
		System.out.println(end - begin + "ns"); //0.001s
		
		
		
		
		
		
	} //m4
	
	
	
	
	
	
	

	private static void m3() {
		// 문자열
		//1. String > 불변이라 조작에 비효율적
		//2. StringBuilder > 내부적으로 배열 처리 > 조작 가능
		//내부적인 공간에 직접적으로 조작이 가능하도록 특수하게 만들어짐
		//조작을 할 일이 없을땐 문자열쓰고, 극심한 조작 필요할땐 성능을 위해 StringBuilder쓰는게 나음
		
		
		
		String name1 = "홍길동";			 //혜택(값형 스타일)
		//참조형은 대부분 리터럴 표기법 X
		String name3 = new String("홍길동"); //원래 이게 정석
		
		StringBuilder name2 = new StringBuilder("홍길동");
		
		System.out.println(name1);
		System.out.println(name2);
		
		System.out.println(name1.equals(name2));
		//둘 다 홍길동이지만 비교를 해보면 자료형이 서로 달라서 false
		//그러나 둘은 거의 쌍둥이 같음. 둘이 기능이 비슷
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} //m3

	private static void m2() {
		
		// 문자열을 대상으로 하면 안되는 행동
		// 1. 큰 문자열 조작
		// 2. 잦은 문자열 조작
		
		String txt1 = "홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동";
		txt1 = txt1 + "님";
		
		
		String txt2 = "가나다";
		
		for(int i=0; i<100; i++) {
		txt2 = txt2 + "라";
		}
		System.out.println(txt2);
		
		
		
	} //m2
	
	
	
	
	
	
	
	
	
	

	public static void m1() {
	
		//1. 메모리의 공간은 한 번 할당되면 더 이상 늘리거나 줄일 수 없다.
		//3. 문자열은 참조형이다.
		
		
		//값형 > 자료형 > 메모리의 크기가 고정
		int a = 10;				//4byte
		char c = 'A';			//2byte
		
		
		//참조형 > 소유하고 있는 데이터의 크기에 따라 메모리 크기가 다르다.
		//			> 길이가 늘어나거나 줄어든다.(X)
		String b = "홍길동";	//6byte(2byte씩 3글자니까)
		String d = "안녕하세요";	//10byte(2byte씩 5글자니까)
		
		int[] ns1 = new int[3];		//12byte(int 크기의 방 3개니까 4*3)
		int[] ns2 = new int[5];		//20byte
		
		
		
		String name = "홍길동";
		name = name + "님";
		System.out.println(name);	//홍길동님
		//홍길동이라는 String 뒤에 님이 붙은게 아님
		//홍길동(6byte) 하나, 님(2byte) 하나, 홍길동님(8byte) 하나씩 각각 생김
		//생성된 8byte를 가져오게 되면 6byte, 2byte 데이터들이 참조가 끊기게 됨
		//참조가 끊긴 데이터(Garbage)
		
		
		name = "홍길동";
		name = "아무개";	//수정하기
		System.out.println(name);
		
		
		//
		
		String name1 = "홍길동";
		String name2 = "홍길동";
		String name3 = "홍";
		name3 = name3 + "길동";
		
		//(★★★) 모든 참조형 변수의 비교는 참조 데이터 비교가 아니라, 주소값을 비교한다.
		System.out.println(name1 == name2);		//true
		System.out.println(name1 == name3);		//false
		//문자열 부등호는 무조건 == 가 아니라 .equals를 써야 함
		System.out.println(name1.equals(name2));	//true
		//name1이 갖고있는 주소값과 name2가 갖고있는 주소값이 같은지를 비교
		
		System.out.println(name1.equals(name3));	//true
		//name1이 100번지를 갖고있다면 n3는 300번지(임의의 다른 번지) 주소값을 갖고있기 때문에 !=
		
		
		//똑같은 메소드 안에서 똑같은 상수를 선언하면 따로 만들지 않고 기존의 상수를 재활용함
		//name1과 name2는 한 몸. 하나의 배열을 두개 이상의 참조변수가 가리킬 수 있음
		//name3를 실행 -> 홍 이라는 새로운 상수 생성. name3에 상수의 주소값을 복사해서 넣음
		//"홍"이라는 상수와 "길동"이라는 상수를 각각 만들어서 더함 -> "홍길동"이 나옴
		//연산의 결과로 만들어진 "홍길동" != 기존의 "홍길동". 재사용 하지 않음
		//"홍"을 가져오던 기존의 200번지는 사라지고 "홍"+"길동"으로 이루어진 상수의 300번지가 됨
		
		
		
		String txt1 = "안녕하세요.";
		String txt2 = "안녕하세요.";
		//둘 다 동일한 상수인 "안녕하세요"의 주소값을 가져옴
		
		txt1 = "반갑습니다.";
		//txt1의 상수값을 안녕하세요->반갑습니다로 바꾸면 동일한 주소를 공유하던 txt2도 원본이 바뀌게 되는 것
		//문자열 > 참조형 > 예외를 둠 > 참조형이어도 1개를 건드리면 다른 1개는 자동으로 수정이 되지 않도록 바꿈
		
		
		String txt3 = "홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.";
		String txt4 = "홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.홍길동입니다.";
		
		//참조형은 만들면 데이터가 엄청 커짐. 
		
		//문자열은 불변이다.
		
		
		
		
		
		
		
		
		
		
		
		
				
		
	
	
	
	}
	
	
	
	
	
	
	
	
	
	

}
