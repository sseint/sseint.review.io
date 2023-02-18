package com.test.obj;

public class Person {
	
	private String name; 	//이름
	private int age;		//나이
	private String address;	//주소
	
	
//	private String nick1;	//별명(여러개 저장)
//	private String nick2;
//	private String nick3;	-> nick이 몇개일지도 모르고, 없는 사람도 있으면 메모리 낭비
	
	
//	private String[] nick;	//배열이 올 수 있음
//	private String[] nick;	= new String[5];
	
//	private String[] nick = new String[5]; //배열길이를 미리 설정해봤자 큰 의미가 없음
//	private String[] nick;
	
	public String[] nick = new String[5];
	private int index = 0;	//별명 배열의 방번호 제어
	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


//	public String[] getNick() {
//		return nick;
//	}


//	public void setNick(String[] nick) {
//		this.nick = nick;
//	}
	
	
	public void addNick(String nick) {	//Setter 하나씩 집어넣음
		
		//사용자가 첫번째 별명을 넣어주면 우리가 가지고 있는 배열의 0번째에 그 닉네임을 넣어줄 것임
		//사용자가 두번째 별명을 넣어주면 우리는 배열의 1번째 방에 넣어줄 것 ~~
		//외부에서 닉네임만 넣어주면 내부에서 배열 방에 하나씩 넣어줄 것임
		
		//index가 5가 되는순간 배열이 꽉참
		if(this.index < this.nick.length) {
			//방번호가 최대 방번호보다 작으면
			this.nick[this.index] = nick;
			this.index++;
			
			
		} else {
			System.out.println("별명을 추가할 수 없습니다.");
		}
		
		
		
	}
	
	public String getNick() { 	//별명 한개만 돌려줄거라서 return값이 다름
//		몇 번째 별명을 보고싶은지 알려달라고 요청하거나 내가 알아서 앞/뒤부터 돌려주도록 순서를 처리하거나
		
		
		//끝에서부터 하나씩 돌려주기
		//return this.nick[4]~[0] 순으로 돌려주자
		
		if(this.index == 0) {
			this.index--;		//index에서 1을 빼면 마지막 방번호
			String nick = this.getNick()[this.index];
			return nick;
		} else {
			System.out.println("더이상 별명이 없습니다.");
			return null;
		}
		
		
		
	}
	
	
	
	
}
