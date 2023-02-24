package com.test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import com.sun.java.util.jar.pack.ConstantPool.Entry;

public class Ex78_HashMap {
	
	public static void main(String[] args) {
		
		//Ex78_HashMap.java
		
		/*면접질문
		
		- ArrayList vs HashMap 
			- ArrayList와 HashMap을 설명하고 둘이 어떻게 다른지, 둘 중 어떤걸 왜 선택하는지에 대해 자주 물어봄
			- 둘은 불과 물, 검정과 하양 같은 느낌
		
		- List vs Map
			- ArryaList(iphone14) vs HashMap(galaxy ultra 23)	- 좀 더 디테일하게
			- List(iphone) vs Map(galaxy)	- 좀 뭉뚱그려서
			
			- ArryayList(C) > List(I)
			- HashMap(C) > Map(I)
			
			
		- 둘은 양 극단에 있음. ArrayList의 장점 -> HashMap의 단점 / ArryaList의 단점 -> HashMap의 장점
			
		ArrayList
		- 배열의 요소를 접근할때 첨자(index) 사용	
		- list[0], list[1], list[2] ...	
		- 순서가 있는 데이터의 집합(방번호 == 요소의 순서)	
		ex) 1 강의실, 2 강의실, 3 강의실...
		- 장점 : 방번호에 루프 적용하기 쉬움
		- 단점 : 방 번호의 의미를 알기 어려움
		- ex) 1~5반 중에 python을 수업하는 반이 어딘지 알 수 있는지? > 번호만으로는 알 수 없음
		- 요소(방) > 첨자(index) + 값(value)
		- 첨자(index)는 유일하다.(중복 첨자 X)	arr1, arr1, arr2 (X)
		- 값(value)는 중복이 가능하다. arr1={1, 2, 3}, arr2{1, 2, 4} (O)  >  방 번호가 유일하기 때문에
			
		HashMap	
		- 배열의 요소를 접근할 때 키(key) 사용
		- list["햇님"], list["달님"], list["별님"] ... 방을 구분하는 식별자가 번호가 아니라 방에 번호를 붙임	
		- 순서가 없는 데이터의 집합 > 방 번호가 없음> 순서를 알 수 없음
		- 장점 : 방에 이름이 있기 때문에 방의 의미가 명확해짐
		- ex) 햇님반, 달님반, 별님반... / python반, java반, kotlin 방...
		- 단점 : 방 이름 때문에 루프를 못달음
		- 요소(방) > 키(key) + 값(value)
		- 키(key)는 유일하다.(중복 키 X) > 햇님반, 햇님반, 달님반 (X)
		- 값(value)는 중복이 가능하다. 햇님반={김철수, 이영희, 홍길동}, 달님반 = {김철수, 이영희, 아무개} > 키가 유일하기 때문에
		
		
		*/
		
		
//		m1();   // Class와 HashMap의 차이점
//		m2();   // HashMap 사용법
		m3();   // HashMap이 for문을 돌 수 있는지?
		
		
		
		
		
		
	}

	private static void m3() {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("red", "빨강");
		map.put("yellow", "노랑");
		map.put("blue", "파랑");
		
		//HashMap을 루프 탐색하기
		
		//Integer : 숫자 쓸거면 ArrayList씀 > 숫자형 쓰는건 미련한 짓
		HashMap<Integer, String> map2 = new HashMap<Integer, String>();	//배열명에 거의 문자열만 씀
		
		map2.put(0, "빨강");	//방 이름이 정수형일 수 있음
		map2.put(1, "노랑");
		map2.put(2, "파랑");
		
//		System.out.println(map2.get(0));
		
		for(int i=0; i<3; i++) {
			System.out.println(map2.get(i));
		}
		//for문을 돌긴 돌음. 근데 이럴거면 (★★★)ArrayList를 쓰지 HashMap을 쓸 이유가 없음. 절대 이렇게 사용 안함
		System.out.println();
		
		
		//Boolean : 평생 데이터를 딱 2개만 가질 수 있다. > 굳이 배열 만들 필요가 없음
		HashMap<Boolean, String> map3 = new HashMap<Boolean, String>();
		
		map3.put(true, "홍길동");
		map3.put(false, "아무개");
//		map3.put(true, null);
		
		
		
		//HashMap을 루프 탐색하기
		Set<String> set = map.keySet();		//키값(방 이름)들만 모아놓은 배열을 반환
		
		for(String item : set) {			//향상된 for문을 사용. 일반 for문으로는 못돌림
			System.out.println(item);		//red, blue, yellow
		}
		System.out.println();
		
		
		Collection<String> values = map.values();	//값(value)들만 모아놓은 배열 반환
		
		for(String value : values) {
			System.out.println(value);		//빨강, 파랑, 노랑
		}
		System.out.println();
		
		
		Set<String> set2 = map.keySet();
		
		for(String item : set2) {								//뺑뻉이 돌려서 조합할 수는 있음
			System.out.println(item + ":" + map.get(item)); 	//red: 빨강 blue: 파랑 yellow: 노랑
		}
		
		
		//HashMap은 평상시에 루프 돌릴 일이 거의 없음. 무리해서 굳이 하게 되는 것
		
		
		//HashMap을 탐색하는 가장 정석법
		Set<Entry<String, String>> eset = map.entrySet();	//2차원 배열
		
		for(Entry<String, String> item : eset) {
			System.out.println(item.getKey() + ":" + item.getValue());
		}
		
		
	}//m3
	
	
	
	
	
	
	
	
	

	private static void m2() {
		
		//HashMap 사용법
		HashMap<String, String> map = new HashMap<String, String>();
		
		//1. 요소 추가하기
		map.put("red", "빨강");
		map.put("yellow", "노랑");
		map.put("blue", "파랑");
		
		
		//2. 요소 개수
		System.out.println(map.size());
		System.out.println();
		
		
		//3. 요소 읽기
		System.out.println(map.get("red"));
		System.out.println(map.get("yellow"));
		System.out.println(map.get("blue"));
		System.out.println();
		
		
		//4. 수정 (String, int) 중 String은 수정 대상이 아님. int만 수정 대상
		map.put("yellow", "샛노랑");	//추가(X), 수정(O) 그냥 배열에 바로 값을 넣어서 덮어씀
		//ArrayList의 list.set(0, "우하하");랑 같은 것 같음. 방 번호가 숫자인지 이름인지 정도만 다를뿐
		
		System.out.println(map.get("yellow"));	//샛노랑
		System.out.println();
		
		
		//5. 요소 검색
		//- contains (indexOf() 는 방 번호를 알려주는 것)
		System.out.println(map.containsKey("yello")); 	//key(방 이름)들 중에 "yello"가 있느냐?
		System.out.println(map.containsValue("노랑"));  //value(값)들 중에 "노랑"이 있느냐?
		System.out.println();
		
		
		//6. 요소 삭제
		map.remove("yellow");	//ArrayList에서는 list.remove(1); 로 방 번호를 입력해서 삭제함
		System.out.println(map.size());
		System.out.println();
		System.out.println(map.get("yellow")); 		//HashMap은 없는 방(key)를 입력해도 에러는 안남. null값을 뱉음
		System.out.println();
		
		
		//7. 초기화
		map.clear();
		System.out.println(map.size());
		System.out.println();
		
		map.put("red", "빨강");
		map.put("yellow", "노랑");
		map.put("blue", "파랑");
		
		System.out.println(map);	//{red=빨강, blue=파랑, yellow=노랑}
		System.out.println();
		
		System.out.println(map); 	//toString() 오버라이딩 > 덤프
		System.out.println();
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("빨강");
		list.add("노랑");
		list.add("파랑");
		
		System.out.println(list);	//[빨강, 노랑, 파랑]
		System.out.println();
		
		//HashMap은 빨강, 파랑, 노랑 / ArrayList는 빨강, 노랑, 파랑
		//HashMap은 내부에서 어떤 규칙에 의해 순서를 정함. 우리가 그 상황을 접근할 순 없음. HashMap이 알아서 하게 둬야 함
		//-> 순서가 없는 집합이라고 부름(우리는 알 바 아니다!)
		//순서를 규정해서 지키고 싶으면 절대 HashMap은 사용해서는 안됨. ArrayList를 사용해야 함
		
		//초기화, 빈 집 확인
		map.clear();
		System.out.println(map.isEmpty());
	}//m2
	
	
	
	
	
	
	
	

	private static void m1() {

		//요구사항] 학생 1명의 국, 영, 수 점수 저장
		
		//1. 각각의 변수
		//2. 배열
		//3. ArrayList
		//4. 클래스
		//5. HashMap(가장 마지막에 나왔다고 제일 좋다는 것은 아님)
		
		
		
		//1. 각각의 변수
		// - 간편함, 비권장
		int kor = 100;
		int eng = 90;
		int math = 80;
		
		int kor2 = 100;
		
		
		//배열 vs ArryaList
		//- 길이 고정 vs 가변
		
		//Class vs HashMap
		//- 데이터의 개수(학생 수)
		//- 개수가 적으면 HashMap
		//- 개수가 많으면 Class
		
		
		//2. 배열(집합) : 번호로만 되어있음 > 과목 모호...
		int[] score = new int[3];
		score[0] = 100;
		score[1] = 90;
		score[2] = 80;
		
		
		//3. ArrayList > 과목 모호
		ArrayList<Integer> score2 = new ArrayList<Integer>();
		score2.add(100); 	//score2.get(0)	> 0번째가 국어인지, 수학인지 모름
		score2.add(90); 	//score2.get(1)
		score2.add(80); 	//score2.get(2)
		
		
		//4. 클래스(집합) : 이름을 붙여서 접근 > 과목 명확!!
		Score score3 = new Score();
		score3.kor = 100;
		score3.eng = 90;
		score3.math = 80;
		
		
		//5. HashMap(Generic 자료형이 2개) 집합. 과목 명확
		HashMap<String, Integer> score4 = new HashMap<String, Integer>();
		
		score4.put("국어", 100);	//앞에 있는 게 방 이름, 뒤에 있는 게 넣을 값
		score4.put("영어", 90);
		score4.put("수학", 80);
		
//		System.out.println(score4.get(0));	순수배열
		System.out.println(score4.get("국어"));
		System.out.println(score4.get("영어"));
		System.out.println(score4.get("수학"));
		
		
		HashMap<String, Integer> score5 = new HashMap<String, Integer>();
		score5.put("국어", 99);
		score5.put("영어", 88);
		score5.put("수힉", 77);	//수힉으로 오타가 나도 에러가 안남 > 그냥 방 번호가 "수힉"이라고 인식 > 틀이 없다.
		
		
		//요구사항] 학생 1명(★★★)의 국, 영, 수 저장 > HashMap이 편함
		//클래스로 해결하려면 클래스를 만들어야 함 > 클래스 설계 비용 들어감
		//- 붕어빵 1개 먹고싶어서 붕어빵 틀을 삼
		//- 캠핑하고 싶은데 경험이 없어서 > 텐트 장비만 300만원어치 삼 > 1박하고 안맞아서 그만둠
		//- 학생 100명의 국, 영, 수 저장 > Class사용
		
		//-> 여러개를 할거면 클래스를 사용, 한 번만 사용 시 클래스 사용은 과한 행동
		
	}//m1

}

class Score{
	public int kor;
	public int eng;
	public int math;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

















