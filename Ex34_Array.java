package com.test.java;

import java.util.Arrays;
import java.util.Calendar;

public class Ex34_Array {

	public static void main(String[] args) {
		
		//Ex34_Array.java
		//2023.02.13
		
		
		/*
		
		(★★★★★)배열, Array(굉장히 중요한 파트)
		- 자료형 중 하나 > 데이터 저장 구조 + 규칙
		- 참조형
		- 집합 > 집합 자료형 > 데이터를 여러개 저장할 수 있는 자료형
		- (★★★)같은 자료형을 저장하는 집합 > 같은 자료형 변수들의 집합
		- (★★★) 방들은 연속으로 생성(★★★)
		
		
		동일한 성격 + 동일한 자료형 > 데이터가 여러개 > 배열 사용!!!!
		
		
		*/
		
		
//		m1();
//		m2();	//배열 선언
//		m3();
//		m4();
//		m5();
//		m6();
//		m7();
//		m8();
//		m9();
//		m10();
//		m11();
//		m12();
//		m13();
//		m14();
//		m15();
		
//		m16();	//다시 방송 돌려보기(230214)
//		m17();	//다시 보기
//		m18();	//깊은 복사 설명
//		m19();	//추출 메소드
//		m20();  //삽입
//		m21();  //삭제
		
		
		
		//(★★★) 자바의 식별자는 조합해서 만들어낼 수 없다.
		//(★★★) 자바의 식별자는 한 번에 만들어야 한다.
		
		
		int n1;
		
		String s1 = "n";
		String s2 = "1";
		
//		int s1 + s2; //int "n" + "1" > int n1 만들고 싶지만 불가능
		
		
		//유일하게 이 상황을 가능하게 만드는 딱 한가지 방법이 있음 > 배열
		
		int[] ns = new int[3];
		int index = 0;
		
		ns[0] = 100;
		ns[index] = 100;	//배열의 첨자는 변수/상수가 올 수 있다.
		//^방 번호를 고정적인게 아니라 그때 그때 다르게 넣을 수 있다.
		
		int m1;
		int m2;
//		int m3;
		
		//m1 > m2 > m3
		
		
		
		
		
		
	} //main
	
	
	
	
	
	
	
	private static void m21() {
		
		// - 삭제(★★★) //특별한 행동, 자주하는 행동이니까 면접이나 시험때 나올수도 있음
		// - 배열의 원하는 위치의 요소를 삭제
		// - Left Shift : 한 자리를 삭제하고 뒤의 값들을 삭제한 자리부터 한 칸씩 왼쪽으로 옮기기 떄문

		String[] list = {"A", "B", "C", "D", "E"};
		int index = 1;
		
		for(int i=index; i<list.length-1; i++) {
//			System.out.println(i); //1, 2, 3
			
			list[i] = list[i+1]; //오른쪽에 있는 방을 왼쪽으로 복사해라
			
			
		}
		
//		System.out.println(Arrays.toString(list)); 		//A,C,D,E,E  > C[2]가 B[1]자리에 복사되면서 B가 삭제됨
		
		list[list.length-1] = "";
		System.out.println(Arrays.toString(list));		//A, C, D, E, > 맨 끝번호에는 빈 문자열""을 삽입함
		
		
		
	} //m21


	
	





	private static void m20() {
		
		// - 삽입
		// - 배열의 원하는 위치에 요소를 중간삽입
		// - 1. 끼어들 위치부터 한칸씩 다른 값들이 이동 > 끼어들 위치가 빈 칸이 됨 > 원하는 요소 삽입
		// - Right Shift로 구현했다고 말함(오른쪽으로 이동하면서 복사했으니까)
					
		String[] list = {"A", "B", "C", "D", "E"};
		//끼어들 위치인 B부터 뒤로 한칸씩 밀기
		int index = 1; // [1]번째에 끼워넣고 싶음
		String value = "F"; //끼어들 값
		
		//B가 오른쪽으로 옮겨야 하니까 1, C가 오른쪽으로 옮겨야 하니까 2, D가 오른쪽으로 옮겨야 하니까 3이 필요
		//E는 밀려서 없어지니까 방번호 필요 X
//		for(int i=index; i<list.length-1; i++) {		//끝 방 번호는 필요가 없으니까 1을 빼줌
		for(int i=list.length-2; i>=index; i--) {		//복사해주는 순서를 바꿔야 함 오른쪽에 왼쪽값을 넣어주며 왼쪽으로 이동
		
			
//			System.out.println(i);  			// 1, 2, 3
			System.out.println(i); 				// 3, 2, 1
			list[i+1] = list[i];				//index가 1이면 i+1 위치에 넣어야 하니까
			
		}
		
		System.out.println(Arrays.toString(list));	//이대로 하면 A, B, B, B, B가 나옴
		//앞에서부터 복사하는게 아니라 맨 뒷자리에 뒤-1자리값을 복사, 뒤-1자리값에 뒤-2자리값을 복사... 삽입할 위치에는 요소 삽입
		list[index] = value;					//원하는 자리값에 F삽입(index는 1번째 자리에 끼우고 싶다고 위에서 말함)
		
		System.out.println(Arrays.toString(list));
		
		
		
		
		
	} //m20







	private static void m19() {
		
		// - 추출
		// - charAt(방번호) : 숫자를 입력하면 그 숫자 위치에 있는 문자를 호출
		// - 색상 colorAt(배열, 방번호)	<~한 배열의 몇 번째에 있는 값을 호출
		// - 배열 subArray(배열, 시작 방번호, 끝 방번호) //시작 방번호 ~ 끝 방번호 영역을 잡아서 돌려주기
		//		> 부분 집합 가져오기
		// 범위를 부분적으로 가져올때는 시작 인덱스는 포함하지만 끝나는 인덱스는 포함을 잘 안시킴
		//2번째 방에서 5번째 방을 가져오면 보통 5번째 방을 빼고 가져오게 됨
		//2~5번째 방을 가져와 달라고 하면 3개만 가져오게 됨 2, 3, 4번째 방
		// - 배열 subArray(배열, 시작 방번호) > 시작번호만 알려주면 거기서부터 끝나는 번호까지 가져와라
		
		String[] colors = {"yello", "red", "blue", "white", "black", "green", "purple", "gold", "silver"};
		
		System.out.println(colorAt(colors, 5));	//사실 메소드 만들기 민망한 방법
		System.out.println(colors[5]); //그냥 이것만 넣어도 나오긴 함
		
		String[]sub = subArray(colors, 1, 7);
				
		System.out.println(Arrays.toString(sub));	//방번호 1번인 red부터 7번인 puple까지 총 6개 추출
		
		sub = subArray(colors, 5);
		
		System.out.println(Arrays.toString(sub)); //방번호 5번인 green 부터 끝까지인 silver까지 추출
		
	} //m19
	
		public static String[] subArray(String[] colors, int beginIndex) {
		
//		endIndex 없음 > 배열 끝까지(length) 가져와라
		String[] temp = new String[colors.length - beginIndex]; //방길이 3개
		
		for (int i=beginIndex; i<colors.length; i++) {
			
		//추출하고 싶은 영역의 인덱스
//			temp[i] = colors[i];	colors에는 2, 3, 4가 있는데 temp에는 0, 1, 2만 있음 > 같은 자리에 복사할 수 없음
//										방 번호 간 보정이 필요함
			temp[i-beginIndex] = colors[i];
			
		}
		
		return temp;
		
	} //subArray
	
	
	
	
	
	
	
	
	
	
	public static String[] subArray(String[] colors, int beginIndex, int endIndex) {
		
//		String[] temp = new String[전체를 가져올때는 원본 배열 길이와 똑같은 길이]
		String[] temp = new String[endIndex - beginIndex]; //방길이 3개
		
		for (int i=beginIndex; i<endIndex; i++) {
			
		//추출하고 싶은 영역의 인덱스
//			temp[i] = colors[i];	colors에는 2, 3, 4가 있는데 temp에는 0, 1, 2만 있음 > 같은 자리에 복사할 수 없음
//										방 번호 간 보정이 필요함
			temp[i-beginIndex] = colors[i];
			
		}
		
		return temp;
		
	} //subArray
	
	
	
	public static String colorAt(String[] colors, int index) {
		
		return colors[index];
		
	}
	
	







	private static void m18() {
		// - 깊은 복사
		// - 배열 deepCopy(배열)
		
		String[] colors = {"yello", "red", "blue", "white", "black", "green", "purple", "gold", "silver"};
		
		String[] copy = deepCopy(colors);	//temp 주소값이 돌려졌음
	 // String[] copy = String[] temp;		//temp 주소값과 같아졌기 때문에 colors의 주소값과는 다름
											//  > colors의 데이터가 수정돼도 영향받지 않음
		
		//확인
		colors[0] = "빨강";
		System.out.println(Arrays.toString(colors));
		System.out.println(Arrays.toString(copy));
		
		
	} //m18
	
	
	public static String[] deepCopy(String[] colors) {
		
		
		String[] temp = new String[colors.length];//원본과 동일한 타입 + 동일한 길이의 배열 생성	
												  //	> 원본과는 다른 주소값을 가지게 됨
		
		//얕은 복사
		//temp = colors; //직접 방에 가서 파일 가져옴
		
		for(int i=0; i<colors.length; i++) {
			
			//String = String
			temp[i] = colors[i];		//주소값을 복사해와도 서로 다른 Heap 주소값을 가지고 있음
			
		
		}
		
		return temp;
		
		
	} //deepCopy
	
	
	
	
	
	
	
	
	
	
	
	


	private static void m17() {
		
		
		// - 검색
		// - int indexOf(배열, 검색대상)
		// - 검색대상이 배열의 몇번째 방에서 발견됐는지? 방번호 반환
		
		String[] colors = {"yello", "red", "blue", "white", "black", "green", "purple", "gold", "silver"};
		
		
		
	}


	private static void m16() {
		// 배열을 대상으로 자주하는 행동들 > 메소드로 구현
		//- 검색
		//- booleand contains(배열, 검색대상)  <- (메소드 형식은 이미 구현되어 있는 이름으로 메소드 만들기)
		
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
//		if(contains(nums, 5)) {		//발견함
		if(contains(nums, 11)) {	//발견못함
			
			System.out.println("발견함");
			
		}else {
			System.out.println("발견못함");
		}
		
		String[] colors = {"yello", "red", "blue", "white", "black", "green", "purple", "gold", "silver"};
				
			if(contains(colors, "yello")) {
				System.out.println("발견함");
			} else
				
				
				
		
		
		
		
		
	} //m16
	
	
	public static int indexOf(String[] colors, String color) {		//int로 돌려줘야 할 때
		
		for (int i=0; i<colors.length; i++) {
			
			if(colors[i].equals(color)) {
				
//				return true;
				return i; //찾은 방 번호 반환
			}
			
			
		}
		
		//return false;
//		return 0; <0은 String[0]이 되니까 [0]의 값을 주게 됨. 못찾았는데 방을 알려줄 순 없음 큰일남
//		return 9; //방번호는 [8]까지 있으니까 더 큰 수를 넣으면 해당 안되는 방번호이기 때문에 못찾았다는 의미로 받아들일 수 있음
			      //하지만 방번호가 몇 번 까지 있는지 모를수도 있어서 헷갈릴 수 있음
		return -1; //음수는 방번호로 존재할 수 없음. 자동으로 못찾는다는 의미가 됨
		
		
	}
	
	
	
	
	
	
	
	
	public static boolean contains(String[] colors, String color) {
		
		for (int i = 0; i<colors.length; i++) {
			
			if(colors[i].equals(color)) {
				
				return true;
			}
			
			
		}
		
		return false;
		
		
	} //contains color
	
	
	
	
	
	
	public static boolean contains(int[] nums, int num) {
		
		for (int i=0; i<nums.length; i++) {
			
			if(nums[i] == num) {
				
				//메소드 종료 + true 반환
				return true; 		// return : for 문 끝내면서 메소드 종료
				
			} //if
			
			
			
		} //for
		
		return false;
		
		
	}//contains


	private static void m15() {
		
		// 자바의 정렬 기능 사용
		
		int[] nums = {5, 3, 1, 4, 2};
		
		Arrays.sort(nums);	//오름차순 정렬 > Quick 정렬 알고리즘
		
		//Arrays.reverse(nums);	//reverse는 내림차순
		
		System.out.println(Arrays.toString(nums));	//덤프
		
		
		
		String[] names = {
				
				"홍길동",
				"아무개",
				"테스트",
				"유재석",
				"김철수",
				"나영희",
				"고길동"
				
		};
		
		Arrays.sort(names);
		
		System.out.println(Arrays.toString(names));
		
		
		
		
		Calendar[] list = new Calendar[5];
		
		list[0] = Calendar.getInstance();	//첫 번째 날짜
		list[0].add(Calendar.DATE, -2);		//이틀 전
		
		list[1] = Calendar.getInstance();	//두 번째 날짜
		list[1].add(Calendar.DATE, 1);		//내일
		
		list[2] = Calendar.getInstance();	//세 번째 날짜
		list[2].add(Calendar.DATE, -7);		//일주일 전
		
		list[3] = Calendar.getInstance();	//네 번째 날짜
		list[3].add(Calendar.DATE, 3);		//3일 뒤
		
		list[4] = Calendar.getInstance();	//다섯번째 날짜
											//오늘
		
		Arrays.sort(list);
		
		for(int i=0; i<list.length; i++) {
			
			System.out.printf("%tF\n", list[i]);
			
			
		}
		
		
		
		
	} //m15
	
	
	
	
	
	
	
	
	


	private static void m14() {


		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DATE, -1); 				//어제
		
		Calendar c2 = Calendar.getInstance();	//오늘
		
		
//		System.out.println(c1 > c2);	//불가능
		
		System.out.println(c1.getTimeInMillis() > c2.getTimeInMillis());
		//false -> c2가 더 크다는 뜻
		
		//날짜 비교
		System.out.println(c1.compareTo(c2)); 	//뒤가 더 크면 -1
		System.out.println(c2.compareTo(c1));	//앞이 더 크면 1
		System.out.println(c1.compareTo(c1));	//동일하면 0
		
		Calendar[] list = new Calendar[5];
		
		list[0] = Calendar.getInstance();	//첫 번째 날짜
		list[0].add(Calendar.DATE, -2);		//이틀 전
		
		list[1] = Calendar.getInstance();	//두 번째 날짜
		list[1].add(Calendar.DATE, 1);		//내일
		
		list[2] = Calendar.getInstance();	//세 번째 날짜
		list[2].add(Calendar.DATE, -7);		//일주일 전
		
		list[3] = Calendar.getInstance();	//네 번째 날짜
		list[3].add(Calendar.DATE, 3);		//3일 뒤
		
		list[4] = Calendar.getInstance();	//다섯번째 날짜
											//오늘
		
		
		
		//오름차순 정렬
		for(int i=0; i<list.length-1; i++) {
			
			for(int j=0; j<list.length-1-i; j++) {
				
				if(list[j].compareTo(list[j+1]) > 0) {
					
					Calendar temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			
		}
			System.out.printf("%tF\n", list[i]);
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	


	private static void m13() {
		
		// 문자열 정렬 + 버블 정렬
//		String s1 = "A";
//		String s2 = "B";
		
//		System.out.println(s1 > s2);
		//The operator > is undefined for the argument type(s) java.lang.String, java.lang.String
		//문자열은 비교할 수 없음
		
//		char c1 = 'A';
//		char c2 = 'B';
//		
//		System.out.println(c1 < c2); //char는 숫자형이기때문에 비교 가능
		
		//오름차순(가나다순으로): 아무개 > 홍길동
		String s1 = "홍길동";
		String s2 = "홍길동";
		
		System.out.println(compare(s1, s2));
		
		
		String[] names = {
				
				"홍길동",
				"아무개",
				"테스트",
				"유재석",
				"김철수",
				"나영희",
				"고길동"
				
		};
		
		for(int i=0; i<names.length-1; i++) {
			
			for(int j=0; j<names.length-1-i; j++) {
				
//				if(compare(names[j], names[j+1]) > 0) {

				if(names[j].compareTo(names[j+1]) > 0) {
				
					String temp = names[j];
					names[j] = names[j+1];
					names[j+1] = temp;
					
				}
				
			}
			
		}
		
		System.out.println(Arrays.toString(names));
		
	} //m13

	//두 문자열의 문자코드값을 비교하는 로직
	//1 : 앞이 큰 것
	//-1 : 뒤가 큰 것
	//0 : 동일
	private static int compare(String s1, String s2) {
		
		int length = s1.length() > s2.length() ? s2.length() : s1.length();
		
		
		for(int i=0; i<s1.length(); i++) {
			
			char c1 = s1.charAt(i); //'홍'		//괄호안 : String에서 몇번째 글자를 뽑아내느냐
			char c2 = s2.charAt(i); //'아
			
			if(c1 > c2) {	//'홍' > '아'
				return 1;
				
			} else if (c1 < c2) {
				return -1;
			} 
			
		}
		
		if (s1.length() > s2.length()) {
			return 1;
			
		} else if (s1.length() < s2.length()) {
			return -1;
		}
		return 0;
		
	} //compare
	
	
	
	
	
	
	
	
	
	


	private static void m12() {
		// 데이터 집합 or 배열 > 정렬
		//- 크기 비교 후 > 재배치
		
		//1. 오름차순
		//	a. 숫자: 작은 수 > 큰 수
		// 	b. 문자(열): 문자코드값 순으로
		// 	c. 날짜시간: 과거 > 미래
		
		
		//2. 내림차순
		// 	a. 숫자: 큰 수 > 작은 수
		//  b. 문자(열): 문자코드값 역순으로
		//  c. 날짜시간: 미래 > 과거
		
		
		
		// 정렬 > 기술 면접(코딩 테스트) 질문(★★★), 손코딩 문제 많이 나옴
		// 1. 직접 구현 > 정렬 알고리즘
		// 2. JDK 기능 사용
		
		int[] nums = {5, 3, 1, 4, 2}; //5
		int len = nums.length;
		
		System.out.println(Arrays.toString(nums));
		//배열의 길이가 5면 4번만 뽑으면 자동으로 마지막껀 정해지기때문에
		//length-1만큼 사이클이 돎
		System.out.println();
		
		for(int i = 0; i < nums.length-1; i++) { //0, 1, 2, 3 > N Cycle
			
			//i(0), j(0, 1, 2, 3)
			//i(1), j(0, 1, 2)
			//i(2), j(0, 1)
			//i(3), j(0)
			for(int j=0; j<nums.length-1-i; j++) {		//숫자를 탐색하면서
				
				if(nums[j] > nums[j+1]) {				//둘을 비교해서 
					
					//swap
					int temp = nums[j];					//숫자가 큰 걸 앞으로 옮기기
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
				
				System.out.println(Arrays.toString(nums));
				
			}
			System.out.println();
			System.out.printf("%d cycle\n", i+1);
			System.out.println(Arrays.toString(nums));
			
			
			
		}
		System.out.println();
		System.out.println("result");
		System.out.println(Arrays.toString(nums));
		
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	


	private static void m11() {
		// 배열 자동 초기화 > 초기화 리스트
		
		int[] nums1 = new int[5];
		System.out.println(Arrays.toString(nums1)); 
		
		//직접 초기화 : 직접 방마다 값을 다 하나하나씩 초기화 해주는 것 > 수정하기
		nums1[0] = 100;
		nums1[1] = 90;
		nums1[2] = 99;
		nums1[3] = 85;
		nums1[4] = 65;	//규칙이 없어서 for문 돌리기도 어려움
		System.out.println(Arrays.toString(nums1)); 
		
		
		//초기화 리스트 > 배열 생성과 동시에 초기화
		int[] nums2 = new int[] {96, 79, 99, 85, 65};		//방 번호를 안적음
		System.out.println(Arrays.toString(nums2));			//가장 안 씀
		
		int[] nums3 = {96, 79, 99, 85, 65};					//배열을 선언과 동시에 값을 넣어줘서 초기화 시켜줬다는 뜻. 가장 많이 사용
		System.out.println(Arrays.toString(nums3));			//이건 이 배열의 값을 가져와라 하는 뜻
		
		
		
		
		
		
		String[] name1 = new String[3];
		name1[0] = "홍길동";
		name1[1] = "아무개";
		name1[2] = "하하하";
		
		String[] name2 = {"홍길동", "아무개", "하하하"};
		
		
		System.out.println(Arrays.toString(name1));
		System.out.println(Arrays.toString(name2));
		
		
		
		
		
		
	} //m11
	
	
	
	
	
	
	
	
	
	


	private static void m10() {
		// The local variable a may not have been initialized
		// 로컬 변수는 초기화를 해야 함
		int a;
//		System.out.println(a);
		
		int[] nums = new int[3]; //int * 3
		System.out.println(nums[0]); //컴파일 오류(X), 런타임 오류(X), 0이 들어있음
		//int[] nums를 초기화 하지 않았는데 안에 허락없이 값이 들어있는 상황 발생
		
		//배열 자동 초기화
		//- 배열은 생성 직후에 개발자가 아무것도 안해도 자동으로 값이 초기화
		//- 생성자를 통해서 자동 초기화
		
		//초기화 규칙(★★★)
		//1. 정수배열 > 0
		//2. 실수배열 > 0.0
		//3. 문자배열 > \0
		//4. 논리배열 > false
		//5. 참조형배열 > null
		
		double[] nums2 = new double[3];
		System.out.println(Arrays.toString(nums2));
		
		char[] list1 = new char[3];
		System.out.println(Arrays.toString(list1));
		
		boolean[] list2 = new boolean[3];
		System.out.println(Arrays.toString(list2));
		
		String[] list3 = new String[3];
		System.out.println(Arrays.toString(list3));	// 다시 봐야함
		
		
		
	} //m10


	private static void m9() {
		
		// 유틸리티 클래스
		//- byte > Byte
		//- short > Short
		//- int > Integer
		
		//Arrays 클래스
		//- 배열과 관련된 작업(기능)들을 미리 제공해주는 클래스
		
		int[] nums = new int[3];
		
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		//배열의 상태? > 배열안에 데이터가 잘 들어있는지?
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		
		for(int i=0; i<nums.length; i++) {		//nums는 위에서 3개라고 지정되어있으니 i<3
			System.out.println(nums[i]);		//nums[0]값인 10, [1]값인 20, [3]값인 30이 차례로 출력
		}
		System.out.println();
		
		System.out.println(nums); //[I@59f95c5d(16진수) -> 10진수 > 1509514333
								  //배열값이 들어있는 nums의 진짜 메모리 주소번지
		System.out.println();
		
		
		printArray(nums); //int[] nums
		
		printArray(nums);
		
		printArray(nums);
	
		
		//Arrays.toString()
		//- 데이터를 가지는 공간내부의 상태를 문자열로 반환 > 행동 > 덤프(dump)
		System.out.println(Arrays.toString(nums)); //배열안에 있는 값을 예쁘게 나란히 출력
		
		
		//nums > copy 깊은 복사
		int[] copy;
		
		// 깊은 복사
		copy = Arrays.copyOfRange(nums, 0, 3);	//<- 3은 몇 번째 방 복사를 하는지 표시
		copy = Arrays.copyOfRange(nums, 0, nums.length);
		
		nums[0] = 100;
		
		
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(copy));
	
	}
	
	public static void printArray(int[] nums) {
		
		for(int i=0; i<nums.length; i++) {		
			System.out.printf("[%d] = %d\n", i, nums[i]);		
			
		}
	System.out.println();
		
		
		
		
		
		
		
		
	} //m9


	private static void m8() {
		
		
		// 배열 복사
		
		//1. 얕은 복사, Shallow Copy
		//- 주소값 복사
		//- Side Effect 발생(원본 <-> 수정본)
		//- 기본 동작
		
		//2. 깊은 복사, Deep Copy
		//- 실제 값 복사
		//- Side Effect 발생 안함
		
		
		int[] nums = new int[3];
		
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		//copy = nums;
		
//		int[] = int[] > 참조형 복사 > 주소값 복사 > 얕은 복사	<원본에 영향 o
//		int[] copy;
		
		//참조형끼리 복사, 참조형 변수끼리 복사
		//얕은 복사

		
		int[] copy = new int[3];
		
		//int = int > 값형 복사 > 값끼리 복사 > 깊은 복사		<원본에 영향 x
//		copy[0] = nums[0];										<깊은복사도 배열에서 쓰인다는데 어떻게 쓰이는거지?
//		copy[1] = nums[1];
//		copy[2] = nums[2];
		
		for(int i=0; i<nums.length; i++) {						//0~2만큼 회전
			copy[i] = nums[i];									//copy[0] = nums [0]  ~	copy[2] = nums[2]
		}
		
		
		nums[0] = 100;
		
		System.out.println(copy[0]);							//10
		
		
		
	} //m8


	private static void m7() {
		
		//(★★★★★★★★★★★★★★★★★★★★★★★★★★★)
		// 배열 복사(= 모든 참조형 복사)
		
		int a = 10;	//원본
		int b;		//복사본
		
		b = a;
		
		a = 20; //원본 수정 > b는 영향 없음
		//원본을 수정해도 복사본에는 영향을 주지 않는다. > Side Effect가 없다.
		
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println();
		
		
		//배열은 참조형끼리의 복사
		int[] nums = new int[3];
		nums[0] = 10;		//이 값은 직접 nums[0]에 들어있는 값이 아니라 nums[0]이 가져온 주소값 안에 있는 값
		nums[1] = 20;
		nums[2] = 30;
		
		int[] copy;
		
		//int[] = int[]
		copy = nums;	//nums가 가지고 있는 배열을 copy로 복사함
						//복사한 순간부터 둘은 한 몸으로 간주됨
		
		//원본을 수정하면 복사본도 수정이 된다. > Side Effect가 있다.
		nums[0] = 100;
		copy[2] = 300;	//수정본을 건드려도 원본이 바뀜
		//nums=copy라는 것은 값을 복사하는게 아니라(값은 다른데에 저장되어 있어서 nums가 가진것도 주소값일뿐)
		//nums가 가진 주소값을 copy가 복사해오는 거기 때문에 원본 데이터에 똑같이 영향을 받음
		
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println();
		
		System.out.println(copy[0]);	//copy는 안건드렸는데 nums(원본)값으로 바뀜
		System.out.println(copy[1]);
		System.out.println(copy[2]);
		
		
		int[] temp;
		
		temp = copy; //copy가 복사한 주소값을 복사해 오는 것이기 때문에 똑같이 원본들에 영향 줌
		
		
		
		
	}


	private static void m6() {
		
		//(★★★★★) 메모리의 공간은 한 번 할당되면 절대로 늘리거나 줄일 수 없다.
		
		int[] nums = new int[3]; //int * 3 = 4byte * 3 = 12byte
		
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		//사용하다보니 배열의 길이가 조금 부족함 > 배열 길이가 5개였으면 좋겠음
		// > 불가능!!!!!
		// > (★★★★★) 미리 예측하기!!! > 사용할 배열의 길이가 충분한지!!!
		
		//학생 성적을 처리하는 프로그램을 만들어야 함
		// > 교장 선생님을 찾아가서 > 학생 수가 몇 명? > 280명
		int[] kors = new int[3]; //3!!!! 할당된 배열 길이는 3으로 선언
		> int[] kors = new int[280]; //으로 바꾸면 좋겠다? > 불가능
		// >지금 학생 수 말고 해마다 평균 중 가장 많았을때랑 가장 적었을때가 언제?
		//  > 250~320명 > 맥시멈 값보다 좀 더 여유있게 잡음
		> int[] kors = new int[350];	//너무 많이 잡으면 못쓰고 버리는 메모리들이 낭비됨 
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

	private static void m5() {

		//성적표 만들기
		//- 10명
		//- 과목 : 국어, 영어, 수학 > 난수
		
		
		//2. 데이터 저장 > 배열
		int size = 10; //변수를 지정해놓고 배열에 넣어두면 나중에 학생수가 바뀔때 이것만 바꿔주면 자동으로 배열수정됨
		
		String[] name = new String[size]; //학생명
		int[] kor = new int[size]; //국어 점수		//size변수를 지정했기 때문에 나중에 변경 시 size값만 바꾸면 자동으로 수정
		int[] eng = new int[size]; //영어 점수
		int[] math = new int[size]; //수학 점수
		
		
		//3. 데이터 확보
		name[0] = "홍길동";		//String[] name에 값 입력
		name[1] = "아무개";
		name[2] = "유재석";
		name[3] = "임성빈";
		name[4] = "유찬욱";
		name[5] = "김한빈";
		name[6] = "유정목";
		name[7] = "이채린";
		name[8] = "차지니";
		name[9] = "송재경";
		
		for (int i=0; i<size; i++) {
			
			//60 ~ 100까지로만 범위설정
			//0 ~ 40까지를 60~100에서 빼줌
			kor[i] = (int)(Math.random() * 41) + 60;		//kor[]안에 60~100 중 난수를 값으로 넣고
			eng[i] = (int)(Math.random() * 41) + 60;		//size에 지정한 값 만큼 반복
			math[i] = (int)(Math.random() * 41) + 60;
			//Math.random 함수에 특정 양수를 곱하면 양수에 -1을 한 값이 최대값으로 나온다
			//Math.random * 41 = 0~40 출력
			//+60을 해주면 범위는 60~100으로 출력
			
			
		}
		
		//4. 점수 계산 > 총점, 평균
		//	a. 총점배열, 평균배열을 미리 계산해서 저장하면 됨
		//  b. 출력할 때 즉시 계산
		
		
		
		//1. 화면 설계
		System.out.println("==================================================");
		System.out.println("                     성적표");
		System.out.println("==================================================");
		
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
		
		int total = 0; //반 전체 평균
		
		for(int i=0; i<size; i++) {
		
			System.out.printf("%s\t%5d\t%5d\t%5d\t%5d\t%5.1f\n"
													, name[i]		
													, kor[i]		//위에서 넣은 난수값을 size값 만큼 출력
													, eng[i]
													, math[i]
													, kor[i] + eng[i] + math[i]
													, (kor[i] + eng[i] + math[i]) / 3.0);
			
			total += kor[i] + eng[i] + math[i];	//모든 학생의 총점 누적
			
		} //for문
		 System.out.println("-------------------------------------------------");
		
         System.out.printf("반평균\t\t\t\t\t%5.1f\n", total / 3.0 / 10);
		
		
	} //m5
	
	
	
	
	
	
	
	
	
	

	private static void m4() {
		// 각 자료형 > 배열
		// 정수 배열(byte, short, int, long)
		byte[] list1 = new byte[5];		//배열의 길이는 5
		list1[0] = 10;					//배열[0]의 값은 10
		System.out.println(list1[0]);	//배열[0]의 값을 내놔라
		
		
		//실수 배열(float, double)
		double[] list2 = new double[5];
		list2[0] = 3.14;
		System.out.println(list2[0]);
		
		
		//문자 배열(char)
		char[] list3 = new char[5];
		list3[0] = 'A';
		System.out.println(list3[0]);
		
		
		//논리 배열(boolean)
		boolean[] list4 = new boolean[5];
		list4[0] = true;
		list4[1] = false;
		System.out.println(list4[0]);
		System.out.println(list4[1]);
		
		
		//참조형
		String[] list5 = new String[5];
		list5[0] = "홍길동";
		System.out.println(list5[0]);
		
		
		Calendar c1; //변수
		c1 = Calendar.getInstance(); //값
		
		Calendar[] list6 = new Calendar[5];	//변수 * 5개 생성(0~4)> 아직 값이 들어간 게 아님
		list6[0] = Calendar.getInstance(); //값이 들어감
		
		
		
		
		
		
		
		
		
		
		
	} // m4
	
	
	
	
	
	
	
	
	
	

	private static void m3() {

		
		//- int[] > int 배열
		//- nums > 변수 > 배열
		//- 10 > 배열의 길이(=방의 개수)
		//- 방번호 > 첨자(index)
		//- 방 1개(=데이터) > 요소(element)
		int[] nums = new int[10];
		
		
		
		
		//배열의 길이 = 10
		//첨자의 범위 = 0 ~ 9	
		//첨자의 범위 = 0 ~ length-1	> 길이-1인 숫자가 마지막 방 이름
		
//		nums[0] = 10;
//		nums[4] = 50;
//		nums[9] = 100;
		
		//(★★★★★) 배열 사용 시 주의점!!!
		//-컴파일 에러(X) > 런타임 에러(O)
		//-컴파일 에러 : 문법 검사 시 실제 데이터의 가치를 따지지 않음. 10이 아니라 int라고만 인식
		
		//java.lang.ArrayIndexOutOfBoundsException
		//- Index 10 out of bounds for length 10
//		nums[10] = 110; //없는 방번호
		//방이 10갠데 10번방이 생길 수 없음
		
		//인덱서(Indexer)
		//- nums[0]
		
		//방 10개 > 하나씩;;
		
		//루프 변수의 초기값이 0인 이유 > 배열의 방번호가 0부터라서
		for(int i=0; i<=nums.length; i++) {
			
//			nums[i] = i;
			
			nums[i] = (int)(Math.random() * 10) + 1; //1~10
			
		}
		
		for(int i=0; i<nums.length; i++) {
			
			System.out.printf("nums[%d] = %d\n", i, nums[i]);
			
		}
		
		
	} //m3
	
	
	
	
	
	
	
	
	
	

	private static void m2() {
		// 요구사항] 학생 3명의 국어 점수와 총점, 평균 구하시오(소수 1자리까지)
		// 추가사항] 학생 수 증가 > 300명
		
		//배열 선언하기(생성하기)
		//- 자료형[] 배열명 = new 자료형[길이];
		
		
		//자료형(int[]) 변수명(kors);
		//int n;	//n의 자료형은? int
		//int[] kors;	//= int[]가 하나의 표현임
					//kors의 자료형은? int[](int 배열)
		
		//kors = new int[3]; //int 변수를 3개 만들어라!!
		
		
//		int[] kors = new int[3];
		int[] kors = new int[300];
		
		//변수 > 필드(field) >>> 프로퍼티(property), 속성(attribute)
		//kors 배열의 길이 == 방의 개수
		System.out.println(kors.length); //배열을 통해 3개의 변수를 만들었으니 방의 개수는 3개
		
		
		//배열의 방에 접근하기(데이터 입출력)
		//int[] = int
//		kors = 100;  //cannot convert from int(값) to int[](참조형)
					 //(★★★★★) 값형과 참조형은 형변환이 절대 불가능!!!
		//^ 방 3개중 어떤걸 가리키는게 아니라 방 전체를 가리키는 것임
		//kors = 100으로 놓으면 100을 어느방에 넣을지 어떻게 판단? > 내가 몇 번째 방에 넣으라고 알려줘야 함
		//방들의 이름이 없다 > 구분 불가능
		//방마다 방 번호를 만들어놓음. 방번호(index, 첨자)
		
		//int 방 = int 넣어야 함
		kors[0] = 100;
		kors[1] = 90;
		kors[2] = 80;
		//... + 297
		kors[299] = 60;			//방번호가 0번부터 시작하니까 구하는 방 개수 -1
		
//		int total = kors[0] + kors[1] + kors[2]; //+ kors[3] + ... + kors[299]
		
		int total = 0; //누적변수
		
		for(int i=0; i<kors.length; i++) {	//방 개수만큼 회전
			
			//i: 0 > 1 > 2
//			System.out.println(kors[1]);
			
			total += kors[i]; // 누적 == 총점	i의 사이클 범위만 수정해줘도 배열길이가 자동으로 늘어남
			
		}
		
		
//		double avg = total / 3.0;
		double avg = (double) total / kors.length;
		
		
		System.out.printf("총점: %d점\n", total);
		System.out.printf("평균: %.1f점\n", avg);
		
		
		
		
		
		
	} //m2
	
	
	
	
	
	
	
	
	
	

	private static void m1() {
		// 요구사항] 학생 3명의 국어 점수와 총점, 평균 구하시오(소수 1자리까지)
		// 추가사항] 학생 수 증가 > 300명
		
		int kor1;
		int kor2;
		int kor3;
		
		kor1 = 100;
		kor2 = 90;
		kor3 = 80;
		//+297
		int kor300;
		
		
		
		
		int total = kor1 + kor2 + kor3; // + kor4 + kor5 + ... + kor300
		double avg = total / 3.0;	//3.0 > 300.0
		//+297
		
		
		
		
		System.out.printf("총점: %d점\n", total);
		System.out.printf("평균: %.1f점\n", avg);
		//The method println(int) in the type PrintStream is not applicable for the arguments (int, int)
		//println은 인자리스트에 int, int를 넣을 수 없음
		
		
		
	} //m1
	
	
	
	
	
} //class
