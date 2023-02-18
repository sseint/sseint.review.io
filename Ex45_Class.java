package com.test.obj;

public class Ex45_Class {
	
	public static void main(String[] args) {
		
		//Ex45_Class.java
		
		
		Employee e1 = new Employee();
		
		e1.setName("홍길동");
		e1.setDepartment("영업부");
		e1.setPosition("과장");
		
		
		
		Employee e2 = new Employee();
		
		e2.setName("아무개");
		e2.setDepartment("영업부");
		e2.setPosition("대리");
		
		e2.setSuperior(e1);	//다른 object들이 어떤 멤버의 object 중 하나가 될 수 있음
		
		System.out.println(e2.getSuperior().getPosition());	
		//TODO setter를 통해 Superior에 e1 클래스를 넣음 그런데 왜 getSuperior를 하면 주소값만 출력되는지?
		//- 뒤에 .을 찍고 데려오면 e1에서 값을 가져올 수 있음
		// e2.getSuperior().getPosition() = e1.getPosition()
		
	}

}
