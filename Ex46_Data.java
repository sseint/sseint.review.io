package com.test.obj;

public class Ex46_Data {
	
	public static void main(String[] args) {
		
		//Ex46_Data.java
		
		//프로그램 제작
		// > 데이터 확보
		//  1. 실제 데이터
		//  2. 가상 데이터 > 직접 만들기
		
		//학생 정보
		//- 중학교
		//- 1~3학년
		//- 학년당 5학급
		//- 학급당 30명
		//  - 이름
		//  - 나이
		//  - 학년
		//  - 반
		//  - 번호
		//  - 주소
		//- 450명
		//이렇게 만든 애들을 class로 만들고 배열로 만들어서 구체적으로 구축
		
		//더미 데이터
		
		/*
		//이름 : 난수로 문자열 만들기
		String[] name1 = { "김", "이", "박", "최", "정", "연", "조", "정", "유", "양" };
		
		String[] name2 = { "수", "경", "동", "재", "진", "아", "지", "태", "재", "우", "소", "기", "연", "효", "정", "우", "현", "채", "수", "원", "민" };
		
		
//		for(int i=0; i<10; i++) {	//여러명 만들때 for문 사용
		String name = "";
		
		name += name1[(int)(Math.random() * name1.length)]; //성 1글자
		name += name2[(int)(Math.random() * name2.length)]; //이름 2글자
		name += name2[(int)(Math.random() * name2.length)];
		
		System.out.println(name);
//		} //for(지금은 안씀)
		int age = 0; //나이
		age = 14;
		
		//학년, 반 번호는 다량으로 루프 돌릴 예정
		
		
		//주소
		String[] address1 = { "서울시", "인천시", "대전시", "광주시", "부산시", "제주시" };
		String[] address2 = { "강남구", "강동구", "강서구", "북구", "남구", "서대문구", "동작구", "은평구", "동대문구"};
		String[] address3 = { "역삼동", "대치동", "회기동", "휘경동", "이문동", "천호동", "둔촌동", "길동", "명일동" };
		
		String address = "";
		address += address1[(int)(Math.random()* address1.length)];
		address += " "; //띄어쓰기
		address += address2[(int)(Math.random()* address2.length)];
		address += " "; //띄어쓰기
		address += address3[(int)(Math.random()* address3.length)];
		address += " "; //띄어쓰기
		address += (int)(Math.random()* 40)+10+"번지"; //10~49번지
		
		System.out.println(address);
		
		*/
		
		
		
		String[] name1 = { "김", "이", "박", "최", "정", "연", "조", "정", "유", "양" };	//성씨
		String[] name2 = { "수", "경", "동", "재", "진", "아", "지", "태", "재", "우", "소", "기", "연", "효", "정", "우", "현", "채", "수", "원", "민" };
		
		String[] address1 = { "서울시", "인천시", "대전시", "광주시", "부산시", "제주시" };
		String[] address2 = { "강남구", "강동구", "강서구", "북구", "남구", "서대문구", "동작구", "은평구", "동대문구"};
		String[] address3 = { "역삼동", "대치동", "회기동", "휘경동", "이문동", "천호동", "둔촌동", "길동", "명일동" };
		
		
//		Student[] list = new Student[3 * 5 * 30]; 	//길이 450칸의 배열 만들기 -> 방번호 [0] ~ [449]
		
		//^위 식을 좀 더 쉽게 만들기
		//다차원 배열
		Student[][][] list = new Student[3][5][30]; 
									//[학년][반][학생]
		
		
		
		
		
		//학생 > 3학년 > 5학급 > 30명
		int index = 0; //방번호로 쓸 변수 만들기
		
		for(int i=1; i<=3; i++) {
			
			for(int j=1; j<=5; j++) {
				
				for(int k=1; k<=30; k++) {
					
					Student s = new Student();	//for문 안의 지역변수는 for문 한바퀴 다 돌면 사라짐
					
					s.setName(name1[(int)(Math.random() * name1.length)] 			//성씨에 랜덤
							+ name2[(int)(Math.random() * name2.length)] 		//이름 첫번째 글자에 랜덤
							+ name2[(int)(Math.random() * name2.length)]);		//이름 두번째 글자에 랜덤
					s.setAge(13 + i);
					s.setGrade(i);
					s.setClassNo(j);
					s.setNum(k);
					s.setAddress(address1[(int)(Math.random() * address1.length)]
							   + " "
							   + address2[(int)(Math.random() * address2.length)]
							   + " "
							   + address3[(int)(Math.random() * address3.length)]
							   + (int)(Math.random() * 40) + 10 + "번지");
					
//					list[index] = s;		//list[1] = 랜덤값 돌린 학생1	list[2] = 랜덤값 돌린 학생2 
//					index++;				//1->2							2->3 ...
						
					list[i-1][j-1][k-1] = s;	//i학년 j반 k학생
					
					
				} // for 3
				
			} //for 2
			
			
			
		} //for 1
		
		
//		//학생 출력 -> 오류남 랜덤 안돌려짐
//		for(int i=0; i<list.length; i++) {
//			
//			System.out.printf("%s\t %s\t %s\t %s\t %s\t %s\n"	//출력만 함. 뭘 더하는건 아님
//								, list[i].getName()				//[1]학생의 이름, [2]학생의 이름, [3]학생의 이름...
//								, list[i].getAge()				//[1]학생의 나이, [2]학생의 나이, [3]학생의 나이...
//								, list[i].getGrade()
//								, list[i].getClassNo()
//								, list[i].getNum()
//								, list[i].getAddress());
//			
//		}
		
		
//		//요구사항] i학년 j반 k학생들
//				for(int i=0; i<list.length; i++) {		//학년루프
//					
//					System.out.printf("■■■■■ %d학년 ■■■■■\n", i+1);	
//					
//					for(int j=0; j<list[0].length; j++) {	//반 루프
//						
//						System.out.printf("■■■■■ %d반 ■■■■■\n", j+1);
//						
//						for(int k=0; k<list[0][0].length; k++) {	//학생 루프
//							
//							System.out.printf("%s\t %s\t %s\t %s\t %s\t %s\n"	
//									, list[i][j][k].getName()				
//									, list[i][j][k].getAge()				
//									, list[i][j][k].getGrade()
//									, list[i][j][k].getClassNo()
//									, list[i][j][k].getNum()
//									, list[i][j][k].getAddress());
		
	
		//요구사항] 3학년 2반 학생들 -> 다시보기
		for(int i=0; i<30; i++) {		
			
			System.out.printf("%s\t %s\t %s\t %s\t %s\t %s\n"	
							, list[2][1][i].getName()				
							, list[2][1][i].getAge()				
							, list[2][1][i].getGrade()
							, list[2][1][i].getClassNo()
							, list[2][1][i].getNum()
							, list[2][1][i].getAddress());
				
		}
		
		
	} // main

} //class
