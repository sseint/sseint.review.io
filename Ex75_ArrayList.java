package com.test.collection;

import java.util.ArrayList;

public class Ex75_ArrayList {
	
	public static void main(String[] args) {
		
		//Ex75_ArrayList.java
		
		
		
		m1();   //모든 컬렉션의 특징
		m2();
		
		
	}

	private static void m2() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		// 숫자 100개 저장
		for(int i=1; i<=100; i++) {
			
			list.add(i);	//add를 반복시키는건 컬렉션에서 좋은 방법이 아님
		}
		System.out.println(list);
		//배열 100번방까지 만들어서 안에 다 채움
		
		
		list.add(101); //숫자 1개만 더 추가하고 끝내고 싶다. 더 숫자 추가 안할거다(★★★)
		
		//기존 list[100]개 있는 방에 1개만 더 추가하려면 또 배열 100개길이의 방을 만들고 그 안에 101을 넣어야 함
		//-> 101번을 넣고 남은 99개의 방이 남아돌음
		
		list.trimToSize(); 			//trimToSize라는 101개짜리 방을 만든 후 기존 100개 배열 + 추가 1개 값을 넣고 기존꺼는 버림
									//남은 방들을 모두 제거하는 것(단, 숫자 추가할 일 없다는 전제하에 가능)
		
		list.add(102); 				//값을 또 넣으면 다시 낭비작업이 추가됨. 추가될 예정이 있으면 trimToSize 하지 말 것!!
	}

	private static void m1() {

		//ArrayList(컬렉션)의 특징
		//1. 내부에 배열을 가지고 있다. 그것을 ArrayList를 배열이라고 생각하자
		//2. ArrayList 클래스의 대부분의 기능은 내부 배열을 조작하는 기능들이다.
		//3. 컬렉션은 길이가 가변적이다. 데이터를 넣어도 계속 들어감. 어떻게 관리하길래 길이가 무제한이지?
		//4. 배열은 길이가 고정적이라고 배웠는데 어떻게 ArrayList는 데이터를 넣으면 무제한으로 길이가 증가하는지??
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		System.out.println(list.size());
		
		list.add(100);		//첫번째 요소 추가 > 길이 4 배열 생성
		
		System.out.println(list.size());
		
		list.add(200);
		list.add(300);
		list.add(400);
		
		System.out.println(list.size());
		
		list.add(500);		//길이 4 배열에서 길이 8 배열로 교체
		
		
	} //main

} //main class


//class ArrayList{
//	
//	private int[] list = new int[5];		//int형 5개길이 배열 선언
//	
//	public void add(int n)	{				//배열에 인자리스트에 입력받은 n을 값으로 넣는 메소드
//		this.list[0] = n;
//	}
//	
//}




















