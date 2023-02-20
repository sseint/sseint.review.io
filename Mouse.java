package com.test.obd.inheritance;

public class Mouse {
	
	private int a;
	public int b;
	
	

	public Mouse() {	//인자값 없는 생성자

		this(0, 0);	// 인자값 있는 생성자에 0을 넣어 int a와 int b을 0으로 만듦
		
	}
	
	
	public Mouse(int a, int b) {	//인자값 있는 생성자
		
		this.a = a;
		this.b = b;
	}
	
	
	
	public int getA() {
		return a;
	}


	public void setA(int a) {
		this.a = a;
	}


	public int getB() {
		return b;
	}


	public void setB(int b) {
		this.b = b;
	}

	
	public String info() {
		
		return this.a + ", " + this.b; 
		
	}
	
	

}
