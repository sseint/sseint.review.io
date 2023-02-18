package com.test.obj;

public class Employee {
	
	private String name;			//직원명
	private String position;		//직급(사원, 대리, 과장, 차장, 부장..)
	private String department;		//부서(영업부, 총무부, 인사부..)
	
	//직속 상사-부하가 있는 수직적인 구조
	private Employee superior;		//상급자(직속상사)
	//자료형 : Employee? -> 클래스에 또다른 클래스의 변수를 만드는 것
	//Employee라는 객체 중 하나를 통으로 가져올 수 있음
	//Employee e1이라는 사람을 통째로 e2의 객체 중 하나로 가져올 수 있다는 것
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Employee getSuperior() {
		return superior;
	}

	public void setSuperior(Employee superior) {
		this.superior = superior;
	}
	
	

}
