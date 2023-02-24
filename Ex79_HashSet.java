package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Ex79_HashSet {

	public static void main(String[] args) {
		
		//Ex79_HashSet.java
		
		/*
		
			컬렉션
			1. List 계열 : 첨자를 사용한 순서가 있는 데이터 집합
				- 순서가 있는 집합
				- 첨자(방번호)_index
				- 데이터 중복을 허용한다.
		
		
			2. Map 계열 : 키와 벨류로 이루어진 데이터 집합
				- 순서가 없는 집합
				- 키(방이름)_key
				- 데이터 중복을 허용한다.
		
		
			3. Set 계열 : 데이터 중복을 허용하지 않는 데이터 집합
				- 순서가 없는 집합
				- 식별자가 없다.(방번호 X, 방이름X) > 방과 방을 구분할 수 없다.
				- (★) 데이터 중복을 허용하지 않는다.
				
			
			
		
		*/
		
//		m1();
//		m2();
		m3();
		
		
		
	} //main

	private static void m3() {
		
		// 롯데마트에서 경품 행사
		//1등 : 아이패드
		//2등 : 에어팟
		//3등 : 참치세트
		//4등 : 김세트
		//5등 : 맥스봉
		
		String[] list = {"홍길동", "아무개", "하하하", "호호호", "후후후"
						, "유재석", "강호동", "박명수", "정형돈", "조세호" };
		
		//추첨
		//1. 중복 당첨 허용(O) : 한 사람이 1등도, 4등도 할 수 있음
		// >ArrayList
		
		for(int i=0; i<5; i++) {	//5명 뽑기
			System.out.println(list[(int)(Math.random() * 10)]);
			
		}
		System.out.println();
		
		
		
		HashSet<String> set = new HashSet<String>();
		
		while(set.size() < 5) {
			set.add(list[(int)(Math.random() * 10)]);
		}
		System.out.println(set);
		
		//2. 중복 당첨 허용(X) : 한 사람이 한 번 당첨되면 또 당첨될 수 없음
		// >HashSet
		
		
		
	}//m3
	
	
	
	
	
	
	
	
	
	
	

	private static void m2() {
		
		// 로또 번호 > 중복되지 않는 난수
		
//		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
//		for(int i=0; i<6; i++) {	//lotto 번호는 6개니까
//			int n= (int)(Math.random() * 45)+1;		//n = 45개의 숫자 중 무작위로 들어감
			
			//중복 검사 - 1
//			boolean flag = false;
//			
//				for(int j=0; j<i; j++)	{	//기존 숫자들
//					if(lotto.get(j) == n) {
//						flag = true;
//						break;
//					}
//				
//				}
//				if(!flag) {
//					lotto.add(n);	//중복이 안됐을 때
//				} else {
//					i--;		//중복이 됐을 때
//			}
			
			
			
			
			//중복검사 - 2
//			if(!lotto.contains(n)) { 	//lotto 안에 n 값이 있냐 없냐 false면 중복값이 없단 뜻
//				lotto.add(n);			//중복값이 없으면 lotto 배열에 n을 넣어라
//			} else {
//				i--;					//중복이 있으면 다시 방금 루프 초기화하고 돌아라
//			}
//		
//			System.out.println(lotto);
//			
//			//Arrays
//			//Collections
//			
//			Collections.sort(lotto);
//			System.out.println(lotto);
			
			
			
			
			//중복검사 - 3-1
			HashSet<Integer> lotto2 = new HashSet<Integer>();
			
//			while(true) {		//while의 무한루프
//				
//				int n = (int)(Math.random() * 45) + 1;
//				lotto2.add(n); 							//HashSet은 자율적으로 중복값 배제
//				
//				if(lotto2.size() == 6) {				//6개 값이 다 채워지면
//					break;								//멈추기
//			}
//		
//		}
			
			//중복검사 - 3-2
				
			while(lotto2.size() < 6) {					//아예 범위를 6이하로 하고 시작
				int n = (int)(Math.random() * 45) + 1;	//6개 미만이면 랜덤수 넣고
				lotto2.add(n);
				
				if(lotto2.size() == 6) {				//6개 되면 멈추기
					lotto2.add(n);
					break;
				}
			}
			
			
		System.out.println(lotto2);
		
		//정렬 못함
		//Set을 반드시 정렬 할 일이 있다? > Set을 List로 변환 후 정렬
		
		ArrayList<Integer> lotto3 = new ArrayList<Integer>(lotto2);	//HashSet lotto2를 ArrayList에 넣음
		
		Collections.sort(lotto3);
		System.out.println(lotto3);
		
		
		
		
		
	}

	private static void m1() {
		
		//수료 + 취업 후 > 업무 적응(1~2년)이 되고 나면 > 개발을 계속 할 경우
		//	> (★★★) 알고리즘, 자료구조, 디자인 패턴, Win32 API 공부 필요 (★★★)
		
		HashSet<String> set = new HashSet<String>();
		
		//1. 요소 추가하기
		set.add("사과");
		set.add("딸기");
		set.add("바나나");
		
		
		//2. 요소 개수
		System.out.println(set.size());	//3
		
		
		
		//3. 덤프
		System.out.println(set);	// [사과, 바나나, 딸기]
									// HashMap처럼 순서 달라짐 < 신경쓰지 마셈
		
		
		//4. 중복된 값 추가하기
		boolean result = set.add("사과");	//중복값이 들어간건지 확인하기 위해서 종종 확인 해야함
		System.out.println(result);	//false
		System.out.println(set); 	// [사과, 바나나, 딸기]
									// 추가한 안들어감(기존에 있는 값이니까 중복됨)
		
		
		//5. 검색
		System.out.println(set.contains("사과"));	//해당값이 있으면 true, 없으면 false
		
		
		//6. 삭제
		set.remove("사과");
		System.out.println(set); 			//[바나나, 딸기]
		
		
		
		//7. 요소 읽기 > 오로지 탐색을 통해서만 가능 > 향상된 for문을 통해서만 읽을 수 있음 > 순서도 지정 못함
		for(String item : set) {			//for문을 시작할 때 이터레이터를 생성한다. 
			System.out.println(item);
		}
		for(String item : set) {			//  > 커서가 계속 위로 올라가기 때문에 중복으로 사용해도 됨
			System.out.println(item);
		}
		//-> 쓰기 편하게 포장된 것임
		System.out.println();
		
		
		
		/*
		
		//위의 향상된 for문의 탐색 > 원본
		
		//이터레이터 > 데이터 집합을 탐색하는 도구 > 탐색기
		//(★★★★★) 한 번 끝까지 읽고 나면 다시 읽을 수 없다. 맨 끝에 도달하면 다시 맨 위로 올릴 수 있는 방법 X
		Iterator<String> iter = set.iterator();
		//검색할 값을 가리키는 커서(전진 커서)가 값보다 한 칸 위에 있음
		
		while(iter.hasNext()) {					//커서를 다음칸으로 내려서 0번에 있는 값을 가리킴
			System.out.println(iter.next()); 	//바나나. 0번에 있는 데이터 읽음
		}
//		System.out.println(iter.next()); 		//에러. 이미 커서가 끝까지 다 내려가있는데 또 데이터를 달라고 하면 안됨
		
		
		iter = set.iterator();	//다시 처음부터 읽고싶으면 다시 이터레이터를 생성 > 커서가 처음위치에서 다시 시작
		
		System.out.println(iter.next());		//바나나. 처음값에서 다시 시작함
		
		
//		iter.hasNext();						//다음칸으로 이동해라 > 커서가 한 칸 내려와서 데이터가 있는지 없는지 검사
//						
//		System.out.println(iter.hasNext());	//true	//데이터 값이 있으면 true, 없으면 false < boolean 형식
//		
//		iter.next();	//커서가 가리키는 곳의 값
//		
//		System.out.println(iter.next());	//딸기
//		
//		System.out.println(iter.hasNext());	//false
		*/
		
		
		
		
		
		
		
		
		
		/*
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("사과");
		list.add("사과");
		list.add("사과");
		
		System.out.println(list);
		*/
		
		
		
		
		
	}
	
	
	
	
}//main class
