package com.test.collection;

import java.util.ArrayList;

public class Ex74 {
	
	public static void main(String[] args) {
		
		//꼭 다시 처음부터 해봐야 함
		
		
		//선생님 > 3명			고정 > 순수 배열 사용
		//학생 > 30명
		
		Teacher t1 = new Teacher("홍길동", "hong", "1111", "국어");
		
		t1.login();
		t1.test();
		t1.check();
		t1.logout();
		System.out.println();
		
		Student s1 = new Student("아무개", "test", "1111");
		
		s1.login();
		
		s1.setKor(100);
		s1.setEng(90);
		s1.setMath(80);
		
		s1.score();
		s1.logout();
		System.out.println();
		
		
		String[] name1 = { "김", "이", "박", "최", "정", "연", "조", "정", "유", "양" };
		String[] name2 = { "수", "경", "동", "재", "진", "아", "지", "태", "재", "우", "소", "기", "연", "효", "정", "우", "현", "채", "수", "원", "민" };
		
		String[] subject = {"국어", "영어", "수학"};
		
		String temp = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwsyz";
		
		
		//1. 길이 고정(순수 배열) vs 가변(ArrayList)
		//2. 사용법(아직 안배움)
		
		
		//선생님 배열 > 고정적이라 치고 > 순수 배열로 설정
		Teacher[] tlist = new Teacher[3];
		
		for(int i=0; i<tlist.length; i++) {
			
			String name = "";
			String id = "";
			String pw = "1111";
			
//			name = name1[(int)(Math.random() * name1.length)]
//				  +name2[(int)(Math.random() * name2.length)]	
//			      +name2[(int)(Math.random() * name2.length)];
			
//			↓↓↓↓↓ Refacor > Extract Method
			
			name = generateName(name1, name2);
			
//			id += temp.charAt((int)(Math.random() * temp.length()));
			id = generateId(temp, id);
			
			slist.add(new Student(name, id, pw));
			
		}
			
		for(int i=0; i<slist.size(); i++) {
			
			//slist[i].setKor()
			slist.get(i).setKor((int)(Math.random() * 41) + 60);
			slist.get(i).setEng((int)(Math.random() * 41) + 60);
			slist.get(i).setMath((int)(Math.random() * 41) + 60);
			
			
		}
		
			//죄종 결과
//			for(변수 : 배열) {
			for(Teacher t : tlist) {	
				System.out.println(t);
			}
			System.out.println();
			
			for(Student s : slist) {
				System.out.println(s);
			}
			
			
//			for(int j=0; j<(int)(Math.random() * 6) + 5; j++) {
				//랜덤범위라서 몇 바퀴 돌 지 모름 > 문자가 몇 글자 생성될 지 모름
				//이러면 루프값이 통제가 안돼서 문제생김
				//2번째 j for문을 돌때는 난수가 고정된게 아니라 루프 돌때마다 난수가 생성돼서 범위가 바뀔 수가 있음
				
			int max = (int)(Math.random() * 6) + 5;
			
			for(int j=0; j<max; j++) {
				//미리 정수로 난수를 특정범위로 지정해서 고정해 두고 그걸 가져와서 j범위로 설정해야 논리오류가 안생김
				//초기식은 상관없음. 조건식에 넣는 식들이 고정값이 아닌 코드를 넣을 경우 에러 발생
				
				id += temp.charAt((int)(Math.random() * temp.length()));
				
			}
			tlist[i] = new Teacher(name, id, pw, subject[i]);
			
		}
//		System.out.println(tlist[0]);
//		System.out.println(tlist[1]);
//		System.out.println(tlist[2]);
		
		
		
		//학생 배열 > 수가 들쑥날쑥 하다고 치고 > 컬렉션으로 만들기
		ArrayList<Student> slist = new ArrayList<Student>();
		
		for(int i=0; i<30; i++) {
			
			String name = "";
			String id = "";
			String pw = "1111";
			
			name = generateName(name1, name2);
		}
		
		
		
		
	

	private static String generateId(String temp, String id) {
		id += temp.charAt((int)(Math.random() * temp.length()));
		return id;
	}

	private static String generateName(String[] name1, String[] name2) {
		String name;
		name = name1[(int)(Math.random() * name1.length)]
			   +name2[(int)(Math.random() * name2.length)]	
			   +name2[(int)(Math.random() * name2.length)];
		return name;
	}

}


//온라인 교육] 회원
//1. 선생님
//2. 학생



//부모 역할
//1. 클래스
//2. 추상 클래스
//3. 인터페이스
interface User {
	void login();
	void logout();
	void info();
}

//중간에 추상메소드 삽입. User -> AbstractUser -> Teacher, Student에게 상속
abstract class AbstractUser implements User {
	private String name;
	private String id;
	private String pw;
	private String subject;
	
	//private이라 상속받은 애들이 멤버변수에 값을 집어넣고 하기 어려우니까 setter,getter 생성해줌
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}


class Teacher extends AbstractUser {
	
//	private String name;		공통 멤버변수라 부모로 올림
//	private String id;
//	private String pw;
	
	private String subject;
	
	
	public Teacher(String name, String id, String pw, String subject) {
//		this.name = name;
//		this.id = id;
//		this.pw = pw;
		setName(name);
		setId(id);
		setPw(pw);
		
		this.subject = subject;
	}	
	
	//입력한 값 중 하나를 바꾸고 싶을때? 확인/수정할 일 있을것같으면 setter/getter로 만들어야 함
	//필요없으면 굳이 setter/gette 안만들어도 됨
	
	//디버깅용. 고객에게 보여주면 안되는 식임. 고객에게는 결과만 보여주고 이 식은 개발자만 보기
	public String toString() {
		return "Teacher [name=" + getName() + ", id=" + getId() + ", pw=" + getPw() + ", subject=" + subject + "]";
	}
	
	
	
	public void login() {
		System.out.printf("%s(%s) 선생님이 로그인했습니다.\n", getName(), getId());
		
	}
	
	public void logout() {
		System.out.printf("%s(%s) 선생님이 로그아웃했습니다.\n", getName(), getId());
		
	}
	
	public void info() {
		System.out.println("[교사정보]");
		System.out.println("이름: "+ getName());
		System.out.println("아이디: "+ getId());
		System.out.println("담당과목: "+ getSubject());
		
	}
	
	//↑↑↑↑↑ 선생님으로서 한 일이 아니라, 온라인 교육사이트 회원(부모 클래스)으로서 한 일
	
	//↓↓↓↓↓ 선생님으로서 할 일(자식 클래스 개성)
	
	public void test() {
		System.out.println("시험을 출제합니다.");
	}
	
	public void check() {
		System.out.println("학생 성적을 점검합니다.");
	}
	
	
	
}


class  Student extends AbstractUser{
	
	//학생이 처음부터 갖고있는 기본값(상속됐으니까) -> 추상클래스로 올림
//	private String name;
//	private String id;
//	private String pw;
	
	//시험을 봐야만 생기는 데이터(시험 안보면 안생겨도 되는 데이터. 또 시험을 여러번 보면 어떻게 매번 값을 갱신?
	//-> 지속적으로 이 멤버변수를 써야한다고 할 때 이렇게 사용하는게 사실 좋은 방법은 아님
	private int kor;
	private int eng;
	private int math;
	
	
	//기본정보이기 때문에 생성자로 넣어줌
	public Student(String name, String id, String pw) {
//		this.name = name;
//		this.id = id;
//		this.pw = pw;
		setName(name);
		setId(id);
		setPw(pw);
	}
	
	
	
	//사건이 생겨야만 추후에 생길 데이터기 때문에 setter로 만들음(점수 안꺼내볼 예정이라 getter는 안만들었음)
	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}
	

	public void login() {
		System.out.printf("%s(%s)학생이 로그인했습니다.\n", getName(), getId());
	}
	
	public void logout() {
		System.out.printf("%s(%s)학생이 로그아웃했습니다.\n", getName(), getId());
	}
	
	public void info() {
		System.out.println("[학생 정보]");
		System.out.println("이름: " + getName());
		System.out.println("아이디: " + getId());
		
	}
	
	public void score() {
		System.out.printf("[%s 성적]\n", getName());
		System.out.println("국어: " + this.kor);
		System.out.println("영어: " + this.eng);
		System.out.println("수학: " + this.math);
	}
	
	
	
}










