package com.test.obd.inheritance;

public class Ex50_Object {
	
	public static void main(String[] args) {
		
		//Ex50_Object.java
		
		
		/*
		(★★★★★) Object 클래스	<- 이름이 Object클래스라는게 있음
		- Object 클래스는 완전한 조상(단군 급). 모든 클래스의 기본 부모/조상 클래스
		- 상속을 명시하지 않는 클래스 선언은 자동으로(100%) Object 클래스로부터 상속받는다.
		- Object 클래스를 Tree 구조에 비교하면 Root Class/Root Node라고 부름
		  (상속 관계도를 거꾸로 뒤집어 보면 가장 바닥에 있기 때문. 
		  	> 가장 마지막으로 상속받는 클래스를 Leaf Node, 터미널 노드, 말단 노트라고 함)
		- Object가 가지고 있는 9개의 메소드는 세상 모든 클래스들이 조상으로 갖고있는 클래스기 때문에 매우 중요
		- Object안에 있는 equals, get, hash, toString 메소드만 다룸
		
		- 개발자가 만드는 모든 클래스는 따로 상속을 하지 않는 이상, 자동으로 Object 클래스를 상속받음
		- 모든 클래스의 근원 클래스 > Root Class
		- Object 클래스 기능(9개 메소드)는 모든 클래스에게 상속된다.
			> 모든 클래스는 9개의 메소드를 소유하고 있다.(공통 기능)
		- Class Object is the root of the class hierarchy.
		- Every class has Object as a superclass.
		- All objects, including arrays, implement the methods of this class.
		
		
		
		
		*/
		
		Object o1 = new Object();
		
		
		Test2 t2 = new Test2();
		t2.a = 10;
		t2.b = 20;
		/*t2.setA(3);
		System.out.println(t2.getA());
		Test(부모)로부터 상속받았기 때문에 Test에 setter/getter를 설정해 놓으면
		Test2에서도 Test에 setter/getter 삽입/추출 가능
		*/
		
		Test t1 = new Test();
		
		
		
		
		
	} //main

} // main class

//상속을 명시하지 않는 클래스 선언은 자동으로(100%) Object 클래스로부터 상속받는다.
class Test /*extends Object*/ {
	public int a;

	/*
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	*/
	
}




class Test2 extends Test { 	//부모 Test는 int a 하나만 물려줬음
	public int b;
}












