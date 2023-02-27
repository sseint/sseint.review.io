package com.test.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex81_File {
	
	private final static String SCORE = ".\\dat\\score.txt";	//공용이니까 static 으로 사용
	
	
	public static void main(String[] args) {
		
		//Ex81_File.java
		
		/*
		
			1. 파일/디렉토리 조작
			2. 파일 입출력
				a. 텍스트 입출력(수업)
					- 메모장
					- 응용 프로그램 <-> (데이터) <-> 보조기억장치
				b. 비텍스트 입출력
					- 그림판(이미지 데이터 출력)
					- 동영상 플레이어(영상 데이터 출력)
					- 음악 플레이어(소리 데이터 출력)
				
			저장 장치
			- 하드디스크는 데이터를 1, 0으로 저장함	
			- 데이터 자료형 존재(X) > 모든 걸 문자열로 저장 > 물리적으로는 문자 코드로 변환해서 저장
			  (저장된 데이터에 이전 언어의 흔적이 묻어있으면 다른 데이터가 왔을때 이해를 못하게 됨)
			  (우리가 쓰는 프로그램은 그 어떤 언어와 호환되지 않고 독립적, 자체적으로 존재)
			  	
			인코딩, Encoding
			- 문자 코드(우리가 사용하는 데이터_응용 프로그램 데이터)를 부호화(1, 0) 시키는 작업
			- 어떤 하나의 플랫폼(자바 환경 등)에 있는 데이터를 
			- 자바 프로그램에서 사용하던 "홍길동" 같은 파일들을 하드디스크에 저장하기 위해 텍스트파일(100100100010) 등으로 변환 시키는 작업
			
			
			
			디코딩, Decoding
			- 부호화 된 데이터를 문자 코드로 다시 변환하는 작업(복호화)
			- 텍스트파일(100100100010) > 자바 프로그램("홍길동")
			
			
			자바랑 하드디스크는 데이터를 저장하는 방식이 별개임

			
			인코딩/디코딩 규칙(3종류라고 생각)
			1. ANSI
			4. ISO-8859-1
			5. EUC-KR
			6. MS949
			-> 이 4개가 우리나라 입장에서는 성격이 똑같음(한글 데이터 조작 시 구분 없음)
			------------------------------------------------------------
			2. UTF-8
			------------------------------------------------------------
			3. UTF-16
			
			
			
			(★★★) 
			ANSI(미국 표준)
			- 영어(서유럽 문자, 숫자, 특수문자, 제어문자 등): 1byte (3칸 길이)
			- 한글(일본어, 한자 등) : 2byte (6칸 길이)
			
			UTF-8(거의 국제 표준). 자바, 오라클 > UTF-8을 쓰도록 기본환경 설정됨
			- 영어: 1byte (3칸 길이)
			- 한글: 3byte (9칸 길이)
			
			UTF-16
			- 영어: 2byte (6칸 길이)
			- 한글: 2byte (6칸 길이)
			
			어떤 방식을 선택하든 자유
			그러나 UTF-8을 반 강제적으로 사용해야 함(거의 국제 표준 수준이기 때문)
			
			
			만약 UTF-8로 한글 데이터 100MB를 저장하면
			같은 데이터를 ANSI로 저장하면 2/3 수준으로 줄어들음
			- UTP-8은 한글이 3byte, ANSI는 2byte이기 때문
			
			ANSI(한글 2byte)로 한글 데이터를 작성했는데 다른 사람이 UTF-8(한글 3byte)로 읽을 시 한글이 깨짐
			저장할 때 사용한 byte와 읽을 때 사용한 byte가 다르면 무조건 깨짐
			
			영어도 ANSI(영어 1byte)로 작성했는데 UTP-16(2byte)로 읽으면 또 무조건 깨짐
			
			읽을때 규칙 = 쓸 때 규칙 이어야 함
			
			그런데 혹시라도 byte가 어긋났을 시 인코딩/디코딩 처리를 해줘야 함
			
			
			
			[ANSI] 영어.txt
			[ANSI] 한글.txt
			
			
		*/
		
		
//		m1();			//쓰기스트림 - FileOutputStream
//		m2();			//읽기스트림 - FileInputStream
//		m3();			//쓰기 간편 버전 - FileWriter
		
//		m4();			//메모장에서 글 쓰는 작업 FileWriter
//		m5();			//메모장에서 글 읽는 작업 FileReader
//		m6();			//FileReader 입력받아서 읽기
		
//		m7();			//BufferedWriter/Reader == FileWriter
//		m8();			//BufferedReader 향상된 reader라 쓸만 함
		
		
		//잘 모르겠다 싶으면 Buffered로 짝맞춰서 연습하는게 좋음
		//FileWriter == BufferedWriter 기능 차이가 아예 없음
		//FileReader << BufferedReader 무조건 BufferedReader가 편함(줄 단위로 읽기 때문)
		
//		m9();			//루프에 index 넣어서 숫자 붙이는 법
		
//		m10();			//더미 데이터 만들기
		
		m11();
		
		
	} //main

	private static void m11() {
		
		//더미 데이터 읽기 + 출력
		
		try {
			
			
			BufferedReader reader = new BufferedReader(new FileReader(SCORE));
			
			
			System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
//				System.out.println(line);
				
//				line = 홍길동, 100, 90, 80
				
				String[] temp = line.split(",");	//line을 ,로 구분해서 덩어리들을 배열에 배정
				
				int kor = Integer.parseInt(temp[1]);	//temp[0]은 이름
				int eng = Integer.parseInt(temp[2]);
				int math = Integer.parseInt(temp[3]);
				int total = kor + eng + math;
				double avg = total / 3.0;
				
				System.out.printf("%s\t%5d\t%5d\t%5d\t%5d\t%5.1f\n"
									, temp[0]
									, kor
									, eng
									, math
									, total
									, avg);
				
			}
			reader.close();
				
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}//m11
	
	
	

	private static void m10() {
		
		//더미 데이터 만들기
		String[] names = {"김","이","박","최","정","현","민","유","재","신"};
		
		 try {
	         
	         //. : 현재 프로그램이 있는 폴더
	         //자바 콘솔 프로그램 > 현재 위치 > 프로젝트 폴더
	         BufferedWriter writer 
	            = new BufferedWriter(new FileWriter(SCORE));
	         
	         for (int i=0; i<30; i++) {
	            
	            String name = "";
	            
	            name = names[(int)(Math.random() * names.length)]
	                  + names[(int)(Math.random() * names.length)]
	                  + names[(int)(Math.random() * names.length)];
	            
	            int kor = (int)(Math.random() * 61) + 40;
	            int eng = (int)(Math.random() * 61) + 40;
	            int math = (int)(Math.random() * 61) + 40;
	            
	            writer.write(String.format("%s,%d,%d,%d\r\n"
	                                 , name, kor, eng, math));
	         	}
	            
	            writer.close();
	            
	            System.out.println("더미 데이터 생성 완료!!!");
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	         
	      }//m10
		
		
		
		
		
		
	
	
	
	
	

	private static void m9() {
		 
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\code\\java\\JavaTest\\src\\com\\test\\file\\Ex81_file.java"));
			
			String line = null;
			int lineNumber = 1;
			
			while((line = reader.readLine()) != null) {
				System.out.printf("%03d: %s\n", lineNumber, line);
				lineNumber++;		//숫자 index 추가하는 법
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}//m9
	
	
	
	

	private static void m8() {
		
		try {
			
			//알멩이만 갈아끼는 도구 -> ()안에 들어가는거에 따라 사용 가능
//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("C:\\class\\code\\java\\file\\data4.txt"));
			
//			String line = reader2.readLine();	//한 줄씩 읽음
//			System.out.println(line);
//			
//			line = reader2.readLine();	//한 줄씩 읽음
//			System.out.println(line);
//			
//			line = reader2.readLine();	//더 읽을 줄이 없음
//			System.out.println(line);	//null
			
			
			//루프
			String line = null;
			while((line = reader2.readLine()) != null) {
				System.out.println(line);
			}
			
			reader2.close();
			
			
		
			
			
			
			reader2.close();
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	} //m8
	
	
	
	
	
	
	
	

	private static void m7() {
		
		//FileOutputStream > FileWriter(전용) > BufferedWriter(범용)
		//FileInputStream  > FIleReader(전용) > BufferedReader(범용)
		
		//파일 쓰기
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\class\\code\\java\\file\\data4.txt"));
			//기존에 있던 FileWriter를 한 번 더 감싼 것
			
			writer.write("안녕하세요.");
			writer.write("\r\n");
			writer.write("홍길동입니다.");
			writer.newLine(); 	//= \r\n 작성
			writer.write("반갑습니다.");
			
			writer.close();
			
			System.out.println("완료");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}//m7

	private static void m6() {
	
		try {
			
			//파일 읽기 > 파일 경로 입력
			Scanner scan = new Scanner(System.in);
			
			System.out.print("파일 경로: ");
			String path = scan.nextLine();
			
			FileReader reader = new FileReader(path);
			
			int code = -1;
			
			while((code = reader.read()) != -1) {
				System.out.print((char)code);
			}
			
			reader.close();
			scan.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}//m6
	
	
	
	

	private static void m5() {

		try {
			
			//한 쌍
			//FileWriter
			//FileReader
			
			FileReader reader = new FileReader("C:\\class\\code\\java\\file\\data.txt");
			
//			int code = reader.read();
//			System.out.println(code);	//65
//			
//			code = reader.read();
//			System.out.println(code); 	//66
			
			int code = -1;
			
			while((code = reader.read()) != -1) {	
				System.out.print((char)code	);		//한글을 읽을 수 있음
			}
			
			reader.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

	private static void m4() {
		// 메모장 콘솔 버전 > 쓰기
		
		try {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("저장할 파일명: ");
			String fileName = scan.nextLine();
			
			
			//프로그램 사용자 환경
			//1. CLI	>	Command Line Interface > 콘솔창
			//2. GUI	>	Graphic User Interface > 현재 대부분 프로그램
			
			
			FileWriter writer = new FileWriter("C:\\class\\code\\java\\file\\" + fileName);
			
			boolean loop = true;
			
			while(loop) {
				
				System.out.println("입력: ");
				String line = scan.nextLine();
				
				if(line.equals("exit")) {		//그만두기라는 명령어 -> 메모장에 exit 적으면 입력 정지
					break;
				}
				
				writer.write(line); 		//한 줄 입력 > 텍스트 파일 한 줄 쓰기 추가
				writer.write("\r\n"); 		
				
			}
			
			//자원 해제 코드(Clean up code)
			scan.close();
			writer.close();
			
			System.out.println("쓰기 종료");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

	private static void m3() {
		
		
		// FileOutputStream 불편해서 개량 > FileWriter
		
		
		try {
			
			//문자 단위 쓰기(2byte)
			FileWriter writer = new FileWriter("C:\\class\\code\\java\\file\\data3.txt");
			
			writer.write("ABC"); 	//for문이나 배열 안돌려도 바로 문자열 입력 가능
			writer.write("홍길동"); //한글도 입력 가능
			
			writer.close(); 		//닫아야 함
			System.out.println("완료");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//m3
	
	
	
	
	
	
	
	

	private static void m2() {
		
		// 파일읽기
		//- 읽기 스트림 객체
		
		File file = new File("C:\\class\\code\\java\\file\\data.txt");
		
		try {
			
			if(file.exists()) {
				
				FileInputStream stream = new FileInputStream(file);		//읽어오는거니까 output의 반대
				
//				int code = stream.read();	//read 메소드로 1byte씩 읽을 수 있음
//											//문자 코드값 반환(int로 받으니까)
//				System.out.println(code); 	//65
//				
//				code = stream.read();		//또 읽으면 2번째 문자
//				System.out.println(code);	//66
//				
//				code = stream.read();		//또 읽으면 3번째 문자
//				System.out.println(code);	//67
//				
//				code = stream.read();		//또 읽는데 더이상 읽을 값이 없으면 -1 반환
//				System.out.println(code);	//13(-1의 문자코드값)
				
				
				//(★★★) 루프 암기!!!
				int code = -1;
				
				while((code = stream.read()) != -1) {	//-1이 아니면(값이 있으면) 읽어라
//					System.out.println(code);			//모든 문자를 문자코드값으로 반환
					System.out.print((char)code);		//문자로 가져옴(한글은 안됨)
				}
				
				
				
				
				
				stream.close();				//쓰기는 반드시 닫아야 하는데 읽기는 반드시는 아님
			}
			
		}catch(Exception e) {
		
			e.printStackTrace();
		
		}
		
		
		
		
	}//m2

	private static void m1() {
		// 파일 쓰기(출력)
		//- 쓰기 작업을 지원해주는 스트림(Stream) 객체 > 덮어쓰기 모드
		
		//파일 쓰기 모드
		//1. 덮어쓰기 모드(기본)
		//   - 기존 내용을 삭제하고 다시 파일을 생성 후 데이터를 작성한다.
		//   - 파일이 있으면 파일을 다시 생성
		//   - 파일이 없으면 파일을 새로 생성
		
		//2. 이어쓰기 모드
		//   - 기존 내용을 유지하고, 이어서 데이터를 추가한다.
		//   - 파일이 있으면 파일을 그대로 사용 후 추가
		//   - 파일이 없으면 파일을 새로 생성

		
		//덮어쓰기 모드
		/*
		try {
		
		//데이터를 저장할 파일을 참조
		File file = new File("C:\\class\\code\\java\\file\\data.txt");
		
		//저장할 파일의 스트림 객체를 생성
		//- 빨대 꽂기
		//- 스트림 열기
		FileOutputStream stream = new FileOutputStream(file);	//file이 불안정(없을수도 있으니까) -> 예외처리(try-catch) 필요
		//File을 출력할 수 있는 Output Stream
		
		//쓰기 > 문자 코드값(빨대 꽂아서 stream을 연 것)
		stream.write(65);	//65 : A
		stream.write(66);	//66 : B
		stream.write(67);	//67 : C
		//> 다른 문자코드값을 65, 66, 67대신 입력하면 추가가 아니라 덮어쓰기가 됨
		
		//- 빨대 뽑기
		//- 스트림 닫기(열었던 stream은 반드시 빼야 함)
		stream.close();
		
		System.out.println("완료");
		//윈도우 탐색기를 열어서 data에 가보면 data.txt 파일이 생성되어 있고, 열면 ABC가 적혀있음
			
		} catch(Exception e) {
			
			e.printStackTrace();
		
		}
		*/
		
		
		//--------------------------------------------------------------------------------------------
		
		/*
		//이어쓰기 모드
		try {
			
			//데이터를 저장할 파일을 참조
			File file = new File("C:\\class\\code\\java\\file\\data2.txt");
			
			//저장할 파일의 스트림 객체를 생성
			//- 빨대 꽂기
			//- 스트림 열기
			FileOutputStream stream = new FileOutputStream(file, true);	//false면 덮어쓰기, true면 이어쓰기 모드
			
			
			//쓰기 > 문자 코드값(빨대 꽂아서 stream을 연 것)
//			stream.write(65);	//65 : A
//			stream.write(66);	//66 : B
//			stream.write(67);	//67 : C
			stream.write(68);	//68 : D
			stream.write(69);	//69 : E
			stream.write(70);	//70 : F
			//> 기존값 입력 후 지우고 다른 값을 입력해도 기존값+추가값(이어쓰기)가 됨
			
			//- 빨대 뽑기
			//- 스트림 닫기(열었던 stream은 반드시 빼야 함)
			stream.close();
			
			System.out.println("완료");
			//윈도우 탐색기를 열어서 data에 가보면 data.txt 파일이 생성되어 있고, 열면 ABC가 적혀있음
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		*/
		//---------------------------------------------------------------------------------------------
		
		//이어쓰기 모드
		try {
			
			//데이터를 저장할 파일을 참조
			File file = new File("C:\\class\\code\\java\\file\\data2.txt");
			
			//저장할 파일의 스트림 객체를 생성
			//- 빨대 꽂기
			//- 스트림 열기
			FileOutputStream stream = new FileOutputStream(file, true);	//false면 덮어쓰기, true면 이어쓰기 모드
			
			
			//쓰기 > 문자 코드값(빨대 꽂아서 stream을 연 것)
			stream.write('\r');	
			stream.write('\n');	
//			
//			stream.write('j');	
//			stream.write('a');	
//			stream.write('v');	
//			stream.write('a');	
			
//			String txt = "Hello Java!!";
//			for(int i=0; i<txt.length(); i++) {
//				char c = txt.charAt(i);
//				stream.write(c);
//			}
			
//			byte[] list = {'A', 'B', 'C' };
//			stream.write(list);
			
//			String txt = "Java Programming";
//			stream.write(txt.getBytes());
			
			
			// 바이트 단위 쓰기(1byte씩 저장: 한글 저장을 못함. 한 글자(2byte)를 반씩 쪼개서 적음 -> 오류)
			stream.write('가');		
			stream.write('나');
			stream.write('다');
			
			
			
			//- 빨대 뽑기
			//- 스트림 닫기(열었던 stream은 반드시 빼야 함)
			stream.close();
			
			System.out.println("완료");
			//윈도우 탐색기를 열어서 data에 가보면 data.txt 파일이 생성되어 있고, 열면 ABC가 적혀있음
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
			
			
		
		
		
		
		
		
		
		
	} //m1
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//main class
