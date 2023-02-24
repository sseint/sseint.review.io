package com.test.collection;

import java.util.Stack;

public class Ex76_Stack {
	
	public static void main(String[] args) {
		
		//Ex76_Stack.java
		
		
		/*
		
		ADT
		- Abstract Data Type : 추상적인 자료형
		- Stack, Queue
		- 물리적인 특성은 배열과 동일한데, 사용법이 특별한 자료형
		
		
		Stack
		- 후입선출 : 나중에 넣은걸 먼저 뺌
		- LIFO, Last Input First Output
		- ex) 메모리 구조(Stack)
		- ex) 되돌리기(ctrl + Z), 다시하기(ctrl + Y)
			- 집어넣은 입력값 중 마지막으로 했던걸 꺼내서 삭제하니까, 또 ctrl+z 누르면 또 마지막으로 들어갔던걸 꺼내서 삭제함
			- 다시 되돌리고 싶어서 ctrl+Y를 누르면 꺼냈던 것 중 마지막꺼를 다시 가져옴
		- ex) 웹 브라우저 뒤로가기, 앞으로 가기	
			- 뒤로가기에 갔던 주소들을 저장하는데 뒤로가기를 실행하면 마지막으로 저장한 주소를 꺼내옴
			- 뒤로가기를 누르면 지금 열려져있던걸 앞으로가기에 저장하고, 다시 앞으로 가기를 누르면 가장 마지막으로 넣었던 주소를 꺼냄
			
			
		Queue
		- 선입선출 : 먼저 넣은걸 먼저 뺌
		- FIFO, First Input First Output
		- ex. 줄서기(먼저 온 사람이 먼저 식당 들어감)
		
		
		
		*/
		
		//후입선출
		Stack<String> stack = new Stack<String>();	//문자열 배열
		//안에는 배열이 들었지만 배열처럼 사용을 못함. 사용법을 제한한 것
		
		//1. 요소 추가하기
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");
		
		//2. 요소 개수 확인
		//ArrayList는 개수 확인 시 size()사용
		System.out.println(stack.size()); 		//3
		
		//3. 요소 읽기(= 꺼내기  = 삭제하기)
		System.out.println(stack.pop()); 		//파랑. 가장 마지막에 넣은 값이 튀어나옴
		System.out.println(stack.size()); 		//2. 파랑을 꺼냈으니 2개만 남음
		
		System.out.println(stack.pop());		//노랑. 파랑 바로 전에 들어갔던 노랑 나옴
		System.out.println(stack.size());       //1
		
		System.out.println(stack.pop()); 		//빨강
		System.out.println(stack.size()); 		//0
		
//		System.out.println(stack.pop()); 		//EmptyStackException. 꺼낼게 없음
		
		//집어넣는건 pop down 꺼내는건 pop up
		
//		while(stack.size() > 0) {				//stack 값이 1개라도 있으면
//			System.out.println(stack.pop());	//pop으로 꺼내기
//		}
		
		
		//4. 스택이 비어있는지?
		System.out.println(stack.size() == 0);	//stack.size() 값이 0이면 true 출력
		System.out.println(stack.isEmpty());	//배열이 비어있으면 true 출력
		
		
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");
		
		
		//5.
		System.out.println(stack.peek()); 		//파랑. pop()이랑 같은 역할
		System.out.println(stack.size());		//3. pop처럼 꺼내는게 아님
		
		System.out.println(stack.peek());		//파랑. 계속 파란색만 반환
		System.out.println(stack.peek()); 		//파랑.
		
	}//main
	
	
	
	
	
	
	
	

}//main class
