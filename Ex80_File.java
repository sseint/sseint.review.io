package com.test.file;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Ex80_File {
	
	private static int fileCount;	//메인에 공통으로 쓰일 수 있는 count변수 따로 빼기
	private static int dirCount;	//자식폴더 개수
	private static int length;		//파일 크기
	
	
	static {
		fileCount = 0;
		dirCount = 0;
		length = 0;
	}
	
	
	public static void main(String[] args) {
		
		//Ex80_File.java
		
		/*
		
		1. 파일/디렉토리 조작
			- 윈도우 탐색기로 하는 행동 > 자바로 구현
			- 파일(파일) > 정보 확인, 새로 만들기, 이름 바꾸기, 이동하기, 삭제하기 등...
			- 폴더(디렉토리) > 정보 확인, 새로 만들기, 이름 바꾸기, 이동하기, 삭제하기 등...
			
			
			
		2. 파일 입출력
			- 메모장으로 하는 행동
			- 텍스트 입출력(읽고 쓰기)
			- 메모장, 이클립스 등... 텍스트 편집기가 하는 일 > 자바로 구현 가능
			
			
			
			
			
			
		*/
		
//		m1();		//파일 정보 확인
//		m2();		//파일 정보 탐색
//		m3(); 		//파일 조작
//		m4();		//파일명 수정
//		m5();		//파일 이동하기(폴더 이동) - rename
//		m6();		//파일 삭제(영구삭제) - delete
//		m7();		//새 폴더 만들기 - mkdir, mkdirs
//		m8();		//1명당 1개의 폴더 생성
//		m9();		//날짜별로 폴더 생성
//		m10();		//폴더명 수정+이동
//		m11();		//폴더 삭제하기(delete) - 빈 폴더만 삭제 가능(자식 폴더가 있으면 못지움)
//		m12();		//폴더 내용 보기
//		m13();		//재귀 메소드 -> 가끔씩 쓰는앤데 대체제가 없음
//		m14();		//재귀 메소드 예시
//		m16();		//재귀 메소드 예시(팩토리얼)
//		m18();		//폴더 속 폴더 속 파일 가져오기
//		m19();		//m18()을 좀 더 가볍게
		m20();		//Q117 풀이
		
		
		//재귀 메소드는 트리구조 탐색(조작) 할 때 자주 쓰임
		
		
	}

	
	private static void m20() {
		// 폴더 삭제
		String path = "C:\\Users\\Yang Sein\\Desktop\\쌍용교육센터\\과제\\파일_디렉토리_문제\\폴더 삭제\\delete";
		File dir = new File(path);
		
		if (dir.exists()) {
//			System.out.println(dir.delete()); 		//false. 파일들이 남아있기 때문에
			
			delete(dir);
			
			
			
		}
	}
	
	private static void delete(File dir) {
		
		//1. 목록 가져오기
		File[] list = dir.listFiles(); 	
		
			//2. 파일 삭제하기 위해 파일 찾기
			for(File file : list) {		
				if(file.isFile()) {		
					file.delete();		//프로그램 사용중 빼고는 모든 파일은 지울 수 있음
				}
			}
			
			//3. 자식 폴더를 빈 폴더로 만들고 삭제하기 위해서
			for(File subdir : list) {
				if(subdir.isDirectory()) {
					delete(subdir);			//재귀 메소드
				}
			}
			
			//4. 호출된 폴더 > 파일 모두 삭제 + 자식 폴더는 없음 == 빈폴더
			dir.delete();
			
			
	}


	private static void m19() {
		// C:\class\dev\eclipse
		//- 파일 : 11,757, 폴더 2,501
		//- 730MB (765,853,013 바이트)
		
		String path = "C:\\class\\dev\\eclipse";	
		File dir = new File(path);	
		
		if(dir.exists()) {
			
			count(dir);
			
			
		}
		System.out.printf("총 파일 개수: %,d개\n", fileCount);
		System.out.printf("총 폴더 개수: %,d개\n", dirCount);
		System.out.printf("폴더 크기: %,dB\n", length);
		System.out.printf("폴더 크기: %,dMB\n", length / 1024 / 1024);
		
		
		
	}


	private static void count(File dir) {
		
		//1. 목록 가져오기
		File[] list = dir.listFiles(); 	
		
			//2. 파일 개수 세기
			for(File file : list) {		
				if(file.isFile()) {		
					fileCount++;
					length += file.length();
				}
			}
			
			//3. 자식 폴더 대상으로 방금 행동 반복
			//자식 폴더가 없을때까지 탐색
			for(File subdir : list) {
				if(subdir.isDirectory()) {
					dirCount++;
					count(subdir);	//재귀 메소드
				}
			}
			
	}


	private static void m18() {
		// C:\class\dev\eclipse
		//- 파일 : 11,598, 폴더 2,379
		//- 730MB (765,490,890 바이트)
		
		String path = "C:\\class\\dev\\eclipse";	//몇 단계까지 자식폴더가 있는지 어떻게 앎?
		File dir = new File(path);					//-> 언제까지 내려가야할지 불특정한 상황
													//	-> 더이상 자식폴더가 없을때까지 무한 루프, 조건에 걸리면 break
		int count = 0;	//누적변수
		if(dir.exists()) {
			
			//1. 목록 가져오기
			File[] list = dir.listFiles(); 	//부모 폴더
			
				//2. 파일 개수 세기
				//자식 파일 > 개수
				for(File file : list) {		//file에 list 복사
					if(file.isFile()) {		//파일만 고르기
						count++;
					}
				}
				
				//3. 자식 폴더 대상으로 방금 행동 반복
				//자식 폴더 > 탐색 + 파일 개수
				for(File subdir : list) {
					if(subdir.isDirectory()) {	//폴더니?
						
						//자식 폴더의 내용
						File[] sublist = subdir.listFiles();	//자식 폴더
						
						for(File subfile : sublist) {	//subfile에 sublist 복사
							if(subfile.isFile()) {		//파일만 고르기
								count++;
							}
						}
						
						//손자 폴더 > 탐색 + 파일 개수
						for(File subsubdir : sublist) {
							if(subsubdir.isDirectory()) {	//sublist 폴더 속 파일 찾기
								
								//손자 폴더의 내용
								File[] subsublist = subsubdir.listFiles();
								
								for(File subsubfile : subsublist) {
									count++;
								}
								
							}
						}
					}
				}
			System.out.printf("총 파일 개수: %,d개\n", count);
			
		}
		
		
	}


	private static void m16() {
		// 팩토리얼
		//4! = 4 * 3 * 2 * 1 = 24
		
		int n = 4;
		
		int result = m17(n);
		System.out.println(result);
		
		
		result = factorial(n);
		System.out.printf("%d! = %d\n", n, result);
		
		
	}
	
	private static int factorial(int n) {
		
		return (n == 1) ? 1 : n * factorial(n - 1);	//재귀 호출
	}


	private static int m17(int n) {
		
		System.out.println(n);

		int result = (n == 1) ? 1 : m17(n-1);	//n이 1이면 1, 아니면 n-1 돌려줌
		
		return result;
		
	}


	private static void m14() {
		
		int n = 1;
		m15(n);
		
	}

	private static void m15(int n) {
		
		//for문이나 while문이 재귀호출을 대체하지 못하는 때가 있음 > 그때 사용을 위해 배우기
		System.out.println(n);
		n++;
//		if(조건) {	//조건은 정해진게 없음
		if(n < 10) {
			m15(n); //재귀 호출
		}	//자기 자신을 호출하는데 호출하면서 점점 커짐(n++ 때문)
		
	}


	private static void m13() {
		// 메소드 사용 + 파일 디렉토리 조작
		
		//선언 + 호출
		//test();
		
	}
	
	
	//재귀 메소드(Recursive Method) <- 자기가 자기를 계속 호출하는 메소드
	public static void test() {
		
		System.out.println("메소드 호출");
		
		//java.lang.StackOverflowError
		test(); //자기가 자기를 호출 > 에러 발생(X) > 재귀 호출(Recursive Call)
		//쌍둥이를 부른거라고 생각 -> 같은 애는 아니지만 메소드를 계속 호출 : 무한 루프 > 메모리 영역이 계속 쌓이고 쌓임
		//뭔가를 반복적으로 하고 싶을때 함. 메소드 호출 특성을 통한 반복
		
		
		
	}

	private static void m12() {
		
		// 폴더 안의 내용을 보는 법
		String path = "C:\\class\\dev\\eclipse";
		File dir = new File(path);
		
		if(dir.exists()) {
			File[] list = dir.listFiles();
			
			for(File file : list) {
				System.out.println(file.getName()); 		//path안에 있는 파일들 이름
				System.out.println(file.isFile()); 		//path안에 있는 파일들 이름
				System.out.println(file.isDirectory()); 		//path안에 있는 파일들 이름
				System.out.println(); 		
			}
			
			for(File file : list) {
				if(file.isDirectory()) {		//폴더 목록 가져오기
					System.out.printf("[%s]\n", file.getName());
				}
			}
			
			for(File file : list) {
				if(file.isFile()) {				//파일 목록 가져오기
					System.out.printf(file.getName());
				}
			}
			
			
		}
		
		
		
		
		
		
		
	}

	private static void m11() {
		// 폴더 조작
		//- 폴더 삭제하기(delete) > 빈 폴더만 삭제 가능!
		File dir1 = new File("C:\\class\\code\\java\\file\\bbb");	//에러남
		
		
		if(dir1.exists()) {
			boolean result = dir1.delete();
			System.out.println(result);
		}
		System.out.println("종료");
		
	}

	private static void m10() {
		// 폴더 조작
		//- 폴더명 수정하기 + 이동하기(폴더 내 내용물이 있어도 폴더명 수정에는 영향 없음)
		//- member > 회원
		//- file\\회원 > move\\회원
//		File dir1 = new File("C:\\class\\code\\java\\file\\member");
//		File dir2 = new File("C:\\class\\code\\java\\file\\회원");
		File dir1 = new File("C:\\class\\code\\java\\file\\회원");
		File dir2 = new File("C:\\class\\code\\java\\move\\회원");
		
		if(dir1.exists()) {
			dir1.renameTo(dir2);	//dir1에 있는 파일들이 dir2로 이동
		}
		System.out.println("종료");
		
		
	}//m10
	
	
	
	

	private static void m9() {
		// 요구사항] 날짜별 폴더 생성
		//- "2023-01-01" ~ "2023-12-31" * 365 생성
		
		//- C:\class\code\java\file\plan\2023-01-01
		
		//루프 + Calendar
		
		Calendar c = Calendar.getInstance();
		c.set(2023, 0, 1);
		
		for(int i=0; i<365; i++) {
			System.out.printf("%tF\n", c);
			
			//C:\class\code\java\file\plan\2023-01-01
			String path = "C:\\class\\code\\java\\file\\plan" + String.format("%tF\n", c);
			File dir = new File(path);
			dir.mkdir();
			
			c.add(Calendar.DATE, 1);
		}
		System.out.println("종료");
	
	
		
		
	}//m9

	private static void m8() {
		// 요구사항] 회원 명단 > 개인 폴더 생성
		
		String[] member = {"홍길동", "아무개", "하하하", "호호호", "유재석", "강호동", "조세호", "이이경"};
		
		for(int i=0; i<member.length; i++) {
			
			//회원 1명당 1개의 폴더 생성
			String path = String.format("C:\\class\\code\\java\\file\\member\\[개인폴더]%s님", member[i]);
			
			File dir = new File(path);
			
			dir.mkdir();	//mkdirs도 가능하지만 속도가 느림
			
		}
		
		System.out.println("종료");
		
	} //m8
	
	
	
	

	private static void m7() {
		
		// 폴더 조작
		//- 새폴더 만들기
//		String path = "C:\\class\\code\\java\\file\\aaa";
//		File dir = new File(path);
//		
//		boolean result = dir.mkdir();	//하나만 만들때는 mkdir(make directory). 폴더속 폴더를 만들거면 mkdirs
//		System.out.println(result);     //이미 만들었는데 또 같은이름으로 만들면 false뜸
		
		String path = "C:\\class\\code\\java\\file\\bbb\\ccc\\ddd";		//ddd라는 폴더를 만드는 것. ddd가 중요한게 아니라 bbb와 ccc폴더가 중요
		File dir = new File(path);
		
		boolean result = dir.mkdirs();	//mkdirs : 현재 경로(path)중에 없는 폴더가 있으면 한번에 다 만들어줌
		System.out.println(result);
				
				
				
	}

	private static void m6() {
		
		// 파일 조작
		//- 파일 삭제하기(file.delete())
		String path = "C:\\class\\code\\java\\file\\test.txt";
		File file = new File(path);
		
		if(file.exists()) {
			
			//휴지통 삭제: "휴지통"폴더로 이동하기
			//진짜 삭제: 하드 디스크에서 소멸시킴
			boolean result = file.delete();	//진짜 삭제(복구 불가능)
			System.out.println(result);	
		}
		
		
		
	}//m6
	
	
	
	

	private static void m5() {
		// 파일 조작
		//- 파일 이동하기
		//- file 폴더 안에 있는 수업.txt 파일을 move 폴더로 이동
		
		//원본
		String path = "C:\\class\\code\\java\\file\\수업.txt";
		File file = new File(path);
		
		//이동할 폴더
		String path2 = "C:\\class\\code\\java\\move\\test.txt";		//폴더와 파일명을 모두 수정할 수 있다.
		File file2 = new File(path2);
		
		if(file.exists()) {
			boolean result = file.renameTo(file2);
			System.out.println(result);
		}
		
		//file.renameTo(file2) : 끝에 있는 파일만 바꾸는게 아니고 전체 경로를 바꾸는 것임
		
	}

	private static void m4() {
		
		// 파일 조작
		//- 파일명 수정하기
		//- 수업.txt > class.txt
		//-> 바꾸려는 파일명이 동일한 경로 내 중복되는 파일명이 이미 있으면 false
		
		//원본 참조객체 생성(수업)
		String path = "C:\\class\\code\\java\\file\\수업.txt";	
		File file = new File(path);
		
		
		//수정 후를 참조하는 객체 생성(class)
		String path2 = "C:\\class\\code\\java\\file\\class.txt";	//내가 바꾸려는 이름의 path를 만듦
		File file2 = new File(path2);
		
		if(file.exists()) {
			
			
			boolean result = file.renameTo(file2);	//원본파일.renameTo(수정파일);
							//앞에있는 파일의 경로와 파일을 인자값으로 들어간 값의 경로와 파일로 바뀜
			System.out.println(result);   //true. 파일 이름 수정이 성공했는지 실패했는지 알려줌
			//실패(false)하는 경우 : 이미 같은 경로 내 같은 이름의 파일이 있을때(중복됐을때 false)
		}
		
	
		
	}

	private static void m3() {
		
		// 파일 조작
		//- 새 파일 만들기
		
		String path = "C:\\class\\code\\java\\file\\수업.txt";
		
		File file = new File(path); 	//참조객체 생성
		
//		file.createNewFile();  <- 예외넘기기 > try객체로 감싸줘야 함
		
		try {
			System.out.println(file.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}	//참조객체가 알고있는 경로에 파일을 만들어 줌
		
		
		
		
		
	}

	private static void m2() {
		// 폴더에 접근해서 폴더 정보 알아보기
		//- 폴더(Folder), 디렉토리(Directory) (둘이 같은 말)
		//- 폴더는 공간이라고 보면 안됨. 폴더도 파일임. 폴더라는 파일 자체는 아무것도 가지고 있지 않아서 크기가 늘 0임
		
		//폴더 경로
		String path = "C:\\class\\code\\java\\file";
		
		//폴더 참조 객체 > 다시 클래스는 File로 해야 함
		File dir = new File(path);	//폴더 != 파일 인데 클래스명이 File임 > 디렉토리는 파일의 일종이다.
									//사실 폴더라는건 존재하지 않음. 폴더는 파일 중 하나
		
		if(dir.exists()) {
			System.out.println("폴더 있음");
			
			System.out.println(dir.getName());		//file
			
			System.out.println(dir.isFile());		//false
			System.out.println(dir.isDirectory());	//true
			
			//(★★★) 폴더 자체의 크기는 항상 0이다. 크기라는 개념이 존재하지 않음.
			System.out.println(dir.length());		//0			<- 폴더의 크기
			System.out.println(dir.getAbsolutePath());	//C:\class\code\java\file <- 처음 위치한 경로. path값
			
			//------------------------------------------
			
			System.out.println(dir.lastModified());	//1677218979274	<- 최종 수정한 날짜(초)
			System.out.println(dir.isHidden());		//false
			System.out.println(dir.getParent());	//C:\class\code\java
			
		}else {
			System.out.println("폴더 없음");
		}
		
		
		
		
		
		
		
		
		
	}

	private static void m1() {
		
		// 파일의 정보를 확인하는 일
		//C:\class\code\java\file\test.txt
		
		//자바 프로그램 > 외부에 존재하는 파일에 접근
		//1. 외부 파일을 참조하는 객체를 생성 > 참조객체를 만들어야 함(나 대신 그 파일을 접근할 수 있는 능력을 가진 대리인)
		//2. 우리는 그 파일을 직접 조작하는게 아니라 내 손에 있는 참조 객체를 조작 -> 외부 파일에 적용됨(like as 아바타)
		
		
		//파일 경로(문자열로 가지고 있어야 함)
		String path = "C:\\class\\code\\java\\file\\test.txt";		//escape 안되도록 \\
		
		//파일 참조 객체 > java.io.File 클래스
		File file = new File(path);		//참조객체를 인스턴스 만들어줌
		//file에 path 통로를 알려줬으니, 내가 File에게 명령 내리면 file이 path경로에 가서 건드림
		
		
		//해당 경로에 파일이 실제로 존재하는지?
		//System.out.println(file.exists());
		
		
		if(file.exists()) {	//파일이 있는지 확인해야 하는 작업이 무조건 선행 되어야 함
			
			//파일이 있으면 true라고 답함. true라고 답할때만 파일 조작 가능
			System.out.println("파일 있음");
			
			System.out.println(file.getName());		//test.txt
			
			System.out.println(file.isFile());		//true. 너 파일이니? 파일 -> true
			System.out.println(file.isDirectory());	//false. 너 폴더니? 폴더 아님 -> false
			
			System.out.println(file.length());		//19 : 파일 크기(byte)
			
			System.out.println(file.getAbsolutePath());	//C:\class\code\java\file\test.txt <- 처음 위치한 경로. path값
			
			//------------------------------------------
			
			System.out.println(file.lastModified());	//1677219019046	<- 최종 수정한 날짜(초 tick)
			System.out.println(file.isHidden());	//false. 숨김파일이니? 아니오 -> false
			System.out.println(file.getParent());	//C:\class\code\java\file. 현재 있는 파일의 상위 폴더경로
			
			//tick(초) > Calendar
			Calendar c1 = Calendar.getInstance();
			
			System.out.println(c1.getTimeInMillis()); 	//현재시간의 tick. get() 메소드
			
			c1.setTimeInMillis(file.lastModified()); 	//set() 메소드. tick > Calendar
			//기존 시간 대신 file.lastModified() 시간으로 바뀜
			System.out.printf("%tF %tT\n", c1, c1);
			
		} else {
			//false일땐 파일 조작 불가
			System.out.println("파일 없음");
		}
		
		
		
	}

}



















