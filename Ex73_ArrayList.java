package com.test.collection;

import java.util.ArrayList;
import java.util.Calendar;

public class Ex73_ArrayList {
	
	public static void main(String[] args) {
		
		//Ex73_ArrayList.java
		
		/*
		컬렉션, Collection
		- JCF, Java Collection Framework
		- (향상된) 배열
		- 기존의 순수 배열 > 성능, 사용법 등 개량 > 클래스
		- 길이가 가변적임 > 방의 개수를 마음대로 늘리거나 줄이는게 가능
		
		(★★★) 컬렉션 종류(legacy 제외한 종류들은 외워야 함)
		1. List 계열
			- ArrayList(★★★★★) <- 가장 많이 씀
				- Serializable, Cloneable, Iterable<E>
				- Collection<E>, List<E>, RandomAccess
			- LinkedList
			- Queue
			- Stack
			- Vector(legacy) > legacy : 많이 사용되지 않아서 도태될수도...
			
			
		2. Set 계열
			- HashSet(★★★)
			- TreeSet
			
			
		3. Map 계열
			- HashMap(★★★)
			- TreeMap
			- Properties(legacy)
			- HashTable(legacy)
		
		
		ArrayList 클래스
		- 순수 배열하고 구조가 가장 유사함
		- 사용 빈도가 가장 높음
		- 첨자(index)를 사용해서 요소(element)에 접근
		
		
		
		*/
//		m1();
//		m2();
		m3();
		
		
	}

	private static void m3() {
		
		//순수배열과 ArrayList로 배열 만들기
		// 정수 배열
		int[] ns1 = new int[3];								//순수 배열
		ArrayList<Integer> ns2 = new ArrayList<Integer>();	//ArrayList
		
		//실수 배열
		double[] fs1 = new double[3];						//순수 배열
		ArrayList<Double> fs2 = new ArrayList<Double>();	//ArrayList
		
		//논리 배열
		boolean[] bs1 = new boolean[3];						//순수 배열
		ArrayList<Boolean> bs2 = new ArrayList<Boolean>();	//ArrayList
		
		//문자열 배열
		String[] txt1 = new String[3];						//순수 배열
		ArrayList<String> txt2 = new ArrayList<String>();	//ArrayList
		
		//참조형(클래스) 배열
		Calendar[] cs1 = new Calendar[3];					//순수 배열
		ArrayList<Calendar> cs2 = new ArrayList<Calendar>();//ArrayList
		
		
//		↓↓↓↓↓
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();		//int형 배열을 만듦
		
		//- add(value) : Append
		//- add(index, value) : Insert
		
		for(int i=0; i<10; i++) {
			
			list.add((int)(Math.random()*100));
			
			
		}
		System.out.println(list);				//배열 생성해서 배열의 길이를 구할 수 있음
		
		for(int i=0; i<list.size(); i++) {
			System.out.printf("list.get(%d) = %d\n", i, list.get(i));
		}
		
		
		
	} //m3
	
	
	
	
	
	
	
	
	
	
	
	
	

	private static void m2() {
		// ArrayList 사용법
		//1. 생성하기
		ArrayList<String> list = new ArrayList<String>(); //문자열 배열
		
		//2. 요소 추가하기-맨 끝에 추가(append)
		//- boolean add(T value)		T value : type을 고정할 수 없음
		//- 배열의 맨 마지막에 추가하기 > Append Mode
		list.add("바나나");
		list.add("딸기");
		list.add("귤");
		list.add("포도");
		list.add("파인애플");
		
		
		//3. 요소의 개수
		//- int size()
		System.out.println(list.size()); 		//5
		
		
		//4. 요소 읽기
		//- T get(int index)
		System.out.println(list.get(0));
		System.out.println(list.get(4));
//		System.out.println(list.get(5));	//IndexOutOfBoundsException
											//list[5]번방은 없음
		System.out.println(list.get(list.size()-1));	//마지막 방 요소
		
		
		//5. 요소의 수정
		//- list[0] = 10;	대입 or 수정(처음에 썼으면 대입, 나중에 썼으면 수정)
		//- T set(int index, T newValue)
		
		System.out.println(list);
		String temp = list.set(0, "망고");	//몇 번째 방을 뭐로 바꿀건지? -> [0]번 방을 "망고"로 수정
		System.out.println(temp);			//지워진 값 추출
		System.out.println(list);
		
//		System.out.println(list.get(0));
		
		
		//6. 요소의 삭제
		//- 순수 배열은 방을 삭제 불가능
		//- 컬렉션은 방을 삭제 가능
		//- T remove(int index)
		//- (★★★) 주의!! 레프트 시프트가 발생한다!!! > 삭제된 방 이후의 모든 요소는 방 번호가 -1 감소
		
		System.out.println();
		System.out.println(list);
		System.out.println("삭제 전 3번째 방: " + list.get(3));
		
		list.remove(2);						//[2]번째 방 값 삭제
		
		System.out.println("삭제 후 3번째 방: " + list.get(3));
		
		System.out.println(list.size()); 	//4. 길이가 5였던 배열이 줄어듦
		System.out.println(list); 			//[2]에 있던 "귤"이 삭제됨
		
		//배열안에 있던 값 중 하나가 사라지면 빈자리로 다른 값들이 방을 이동
		//-> 방번호가 삭제된 배열부터 하나씩 당겨짐
		
		
		//7. 요소의 탐색
		//- 루프
		for(int i=0; i<list.size(); i++) {
			System.out.printf("list.get(%d) = %s\n", i, list.get(i));
		}
		System.out.println();
		
		for(String name : list) {
			System.out.println(name);
		}
		System.out.println();
		
		
		
		//8. 요소의 검색
		//- int indexOf(T value);
		//- int lastIndexOf(T value)
		//- boolean contains(T value)
		System.out.println(list.indexOf("사과"));
		System.out.println(list.indexOf("딸기"));
		System.out.println(list.lastIndexOf("딸기"));
		System.out.println(list.contains("사과"));
		System.out.println(list.contains("딸기"));
		
		
		
		//9. 초기화
		//- 모든 요소 삭제 > 모든방.remove()
		//- void clear()
		list.clear();	//싹 다 지우는거라서 조심히 써야함
		
		System.out.println(list.size());	//0. 다 지워짐
		System.out.println(list);
		
		
		//10. 빈배열 확인
		//- boolean isEmpty()
		System.out.println(list.isEmpty());		//true
		System.out.println(list.size() == 0);	//true
		
		list.add("코코아");
		
		System.out.println(list.isEmpty());		//false
		System.out.println(list.size() == 0);	//false
		
		
		
		//11. 요소 추가 - 중간 삽입
		//- 중간에 삽입
		//- void add(int index, T value)
		//- (★★★★★) 우측 시프트 발생 > 삽입한 위치 이후의 모든 요소의 방번호 + 1
		list.add("바나나");
		list.add("딸기");
		list.add("귤");
		list.add("포도");
		list.add("파인애플");
		
		System.out.println();
		System.out.println(list);
		
		list.add(2, "수박"); 		//[2]번째 방에 "수박" 삽입
		
		System.out.println(list);
		//주의할 점 (★★★) 삽입하면 그 뒤에 있는 값들의 방 번호가 바뀜
		
		
		
		
		
		
		
	}//m2
	
	
	
	
	
	
	
	
	
	
	

	private static void m1() {
		
		//순수배열
		//- 타입 명시(int)
		//- 길이 명시(3)
		int[] nums1 = new int[3];
		
		//요소 접근 > 첨자(index) 사용
		nums1[0] = 10;
		nums1[1] = 20;
		nums1[2] = 30;
		
		System.out.println(nums1[0]);	//[첨자] > 인덱서(Indexer)
		System.out.println(nums1[1]);
		System.out.println(nums1[2]);
		
		System.out.println(nums1.length);
		System.out.println();
		
		
		//컬렉션
		//- 타입 명시 > 제네릭(Integer)
		//- 길이 명시 > ??? > 가변
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		
		//요소 접근	> Append > 차례대로(순서대로) 넣어라
		nums2.add(10);		//자동으로 0번째 방에 추가
		nums2.add(20);		//1번째 방에 추가
		nums2.add(30);		//2번째 방에 추가
		
		System.out.println(nums2.get(0)); 		//nums2[0] 몇번째 방을 가져오고 싶다고 해야함
		System.out.println(nums2.get(1));   	//nums2[1]
		System.out.println(nums2.get(2));	 	//nums2[2]
		
		System.out.println(nums2.size());   	//배열길이 : 3. 배열 길이를 length가 아닌 size로 부름
		
		for(int i=0; i<nums2.size(); i++) {
			System.out.println(nums2.get(i));
		}
		System.out.println();
		
		nums2.add(40);
		nums2.add(50);
		
		System.out.println(nums2.size()); 		//배열길이가 계속 늘어남 > 가변적
												//용량제한없이 배열길이를 늘릴 수 있음
		
		
		
	}
	
}
	
class 컬렉션{
	private int[] nus = new int[3];
	
}

















