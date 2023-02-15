package com.test.java;

import java.util.Arrays;
import java.util.Scanner;

public class Ex36_String {
	
	public static void main(String[] args) {
		
		//Ex36_String.java
		
		
		//문자열, String
		//1. JDK에서 제공하는 문자열 조작 기능
		//2. 문자열 성질
		////(★★★) 모든 문자열 메소드는 원본을 수정하지 않는다!!!
		
		
//		m1();
//		m2(); 	//몇 번째 문자인지 가져오는거 > 에러나야하는데 안난다..? 다시 살펴봐야함
//		m3();	//charAt(n) 사용해서 숫자나 번호 추출해 오는 방법
//		m4();   //trim(문자의 양 끝 공백 제거)
//		m5();	//문자열 검색 cantains
//		m6();	//문자열 검색(오류 있음)
//		m7();	//금지어 설정
//		m8();	//문자열 대소문자 변경
//		m9();   //패턴검색(시작위치, 끝위치)
//		m10();	//substring 확장자 없는 파일 추출
//		m11();	//문자열 치환(바꾸기), 금지어 삭제
//		m12();  //문자열 분리
		m13();	//기타 문자열 기능
		
		
		
		
		
		
		
	} //main
	
	private static void m13() {

		String s1 = "Hong";
		String s2 = "hong";
		
//		System.out.println(s1 > s2); //비교불가. 대부분의 연산자는 값형만 피연산자로 가짐
		
		System.out.println(s1.compareTo(s2));	//-32. 대문자와 소문자의 문자값 차이
		System.out.println(s1.compareToIgnoreCase(s2)); //0. 케이스를 무시하고 비교해라
		//대문자 Hong과 소문자 hong을 똑같이 본 것
		
		
		String s3 = "홍길동";
		String s4 = "아무개";
		
		System.out.println(s3 + s4); //홍길동아무개. 혜택
		System.out.println(s3.concat(s4)); //홍길동아무개. 원래 정석방법
		
		
		String s5 = "홍길동";
		char[] clist = s5.toCharArray();
		//처음부터 끝까지 조각조각내어서 문자 배열
		System.out.println(Arrays.toString(clist));
		
		
		
	} //m13
	
	
	
	
	
	
	
	

	private static void m12() {
		
		// 문자열 분리
		//- String[] split(String delimiter) : ","
		//- 구분자를 기준으로 문자열을 자르는 메소드
		
		String name = "홍길동, 아무개, 하하하"; //","라는 것이 앞과 뒤 단어를 구분
												//- ,를 구분자라고 함
		String[] list = name.split(","); 		//네임의 ,마다 잘라주기. 
		
		for(int i=0; i<list.length; i++) {
			
			System.out.println(list[i]);		//구분 후 구분자(",")는 사라진다~
			
		//주의할 점
		String name2 = "홍길동,, 아무개, 하하하";	//,,사이에 문자가 없어도 빈문자열을 넣어서 출력
													//마지막 글자 뒤 구분자는 방 만들지 않음. 하하하, -> 하하하 뒤에 방 X
		for(int j=0; j<list.length; j++) {
			
			System.out.println(list[j]+","+list[j].length());
		
		}
		
		
		}
		
		
		
	} //m12
	
	
	
	
	
	
	
	
	
	
	

	private static void m11() {
		
		//(★★★) 모든 문자열 메소드는 원본을 수정하지 않는다!!!
		
		// 문자열 치환(바꾸기)
		//- String replace(String old, String new) <- 기존값, 새로운 값
		//- 문자열의 일부를 다른 문자열로 교체하는 메소드
		
		String txt = "안녕하세요. 홍길동입니다."; //->홍길동을 다른 이름으로 바꾸기
		
		System.out.println(txt.replace("홍길동", "아무개"));
		//홍길동을 찾아서 아무개로 바꿔서 출력
		//charSequence = String
		
		//원본들 건들지는 않음
		
		System.out.println(txt); // 안녕하세요. 홍길동입니다.
		
		txt = txt.replace("홍길동", "아무개");
		//원본 txt에 이렇게 바뀐 값을 넣으면 그때 원본이 바뀜
		System.out.println(txt); // 안녕하세요. 아무개입니다.
		
		String content = "게시판에 글을 작성합니다. 바보야!!";
		String word = "바보";
		
		//금지어를 안보이게 처리 > Masking
		System.out.println(content.replace(word, "**")); // word값인 바보야 > **야
		
		
		//replace에서 ""(빈문자열)로 바꾸기 > 원하는 문자열을 삭제하기!!!!!
		System.out.println(content.replace(word, "")); // 문자열의 일부분을 제거할 때 사용
		
		
		
		
		
	} //m11
	
	
	
	
	
	
	
	
	
	

	private static void m10() {
		
		// 문자열 추출
		//- String substring(int beginIndex, int endIndex);(★★★)
		//- String substring(int beginIndex)
//		자바에서 범위 할때 시작언어는 포함하는데 끝 언어는 포함 잘 안함
		
		String txt = "가나다라마바사아자차카타파하";
					//0 1 2 3 4 5 6 7
		System.out.println(txt.substring(3, 7)); //3~6
		//시작부터 3<= n <7번까지의 글자를 가져옴
		System.out.println(txt.substring(5, 6)); //5~5 > "바" > 그 외 나머지
		//5<=n<6
		System.out.println(txt.charAt(5));	 	 //	   > '바' > 문자코드
		//한글자면서 문자코드값이필요할땐 charAt()로 가져오지만 보통 substring 많이 씀
		System.out.println();
		
		
		//정형화된 데이터
		String jumin = "950215-2012365";
		
		//몇년생? > 앞에서 2글자 추출
		System.out.println(jumin.substring(0, 2)); //95. 0~1 글자
		
		//몇월생? 
		System.out.println(jumin.substring(2, 4)); //02. 2~3
		
		//며칠생?
		System.out.println(jumin.substring(4, 6)); //15. 4~5
		
		//성별?
		System.out.println(jumin.substring(7, 8)); //2. 7~8
		
		
		
		//파일 경로 > 파일명만 추출
		String path = "C:\\class\\code\\java\\JavaTest\\src\\com\\test\\java\\Ex36_String.java\r\n";
		//맨 끝에 있는 글자 추출 필요
		
		int index = path.lastIndexOf("\\"); //45
		System.out.println(index);
		//내가 찾은 문자열의 \\ 위치
		
		String filename = path.substring(index + 1);
		System.out.println(filename); //파일명 추출
		
		//Ex36_String.java
		//확장자 앞에 있는 순수한 파일 이름 추출
		//= 확장자 없는 파일명 추출
		//파일 이름에 .쓸 수 있음 => Ex36.String.java 가능
		//-> index로 찾지 말라는 것. 파일 이름에 .이 들어있으면 확장자 추출 못하게 됨
		
		//확장자 없는 파일명 추출
		index = filename.lastIndexOf("."); //뒤에서 찾기
		
		String filenameWithoutExtension = filename.substring(0, index);
		System.out.println(filenameWithoutExtension);
		
		//확장자 추출
		String extension = filename.substring(index);
		System.out.println(extension);
		
		
		
		
	} //m10
	
	
	
	
	
	
	

	private static void m9() {
		
		// 패턴 검색
		//- boolean startswith(String) : 시작위치
		//- boolean endsWith(String)  : 끝 위치
		
		String txt = "자바 개발자 과정";
		
		System.out.println(txt.startsWith("자바")); //true
		System.out.println(txt.startsWith("오라클")); //false
		//startsWith : txt 내 "ㅁㅁㅁ"라는 글자로 시작합니까?
		System.out.println(txt.indexOf("자바") == 0);
		//자바가 문자열 중 0번째에 있는지?
		
		
		System.out.println(txt.endsWith("과정")); //true
		System.out.println(txt.endsWith("교육")); //false
		System.out.println(txt.indexOf("과정") == txt.length()-2);
		//"과정"이라는 문자가 문자열 끝에서 2번째에 있는지?
		
		
		System.out.println();
		
		
		
		//파일 조작
		String file = "Ex36_String.java";	
		//자바 소스 파일인지 다른 확장자를 갖는 파일인지 검색필요
		//해당 파일의 확장자가 ".java"인지 확인?
		
		//indexOf를 쓰면 ".java"라는 파일이 뒤에서 다섯번째부터 시작하는지
		
		if(file.endsWith(".java")) {	//끝나는게 .java로 끝나는지?
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		if(file.toLowerCase().endsWith(".java")) {	//만약 JAVA로 저장했을까봐 찾는 법
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		
		
	} //m9
	
	
	
	
	
	
	
	
	
	

	private static void m8() {
		// 문자열 대소문자 변경
		//- String toUpperCase() > 문자열을 모두 대문자로 변환
		//- String toLowerCase() > 문자열을 모두 소문자로 변환
	
		String content = "오늘 수업은 String Method입니다.";
		String word = "string";
		
		//content를 대문자로 바꾼것과 word를 대문자로 바꾸면 일치하는 글자를 검색 가능
		if(content.toLowerCase().indexOf(word.toLowerCase()) > -1) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		
		System.out.println(content.toUpperCase()); //영어의 모든 문자가 대문자로
		System.out.println(content.toLowerCase()); //영어의 모든 문자가 소문자로
		//비교나 검색할 때 많이 씀
		
		System.out.println("Java".equals("java"));	//false Java == java? 
		System.out.println("Java".toUpperCase().equals("java".toUpperCase())); //true
		//Java글자를 쓰면 대문자로 변환하고 이 값은 java를 대문자로 변환한 것과 같다
		
		
	} //m8
	
	
	
	
	
	
	
	

	private static void m7() {
		
		// SNS, 게시판 > 금지어!!
		
		String content = "안녕하세요. 저는 자바를 배우는 학생입니다.";
		String word = "바보"; //금지어
		
		if(content.contains(word)) {		//content 문장 내에 word가 포함되어 있는 글자 찾기
			System.out.println("금지어 발견!!");
			
		} else {
			System.out.println("글쓰기 진행..");
		}
		
		if(content.indexOf(word) > -1) { 		//word를 찾았는데 못찾으면 -1, 찾으면 위치값
			System.out.println("금지어 발견!!");
			
		} else {
			System.out.println("글쓰기 진행..");
		}
		
		
		
		
		content = "안녕하세요. 멍청이 저는 ㅂㅏㅂㅗㅇㅑ자바를 메롱 배우는 학생입니다.";
		String[] words = {"바보", "멍청이", "메롱", "ㅂㅏㅂㅗㅇㅑ"}; //금지어가 여러개일때는 배열 사용
		
		for(int i=0; i<words.length; i++) {
			
			if (content.indexOf(words[i]) > -1) {
				System.out.println("금지어 발견!!!"); 		
				break; // (★★★)	//금지어가 최초로 발견되면 이미 못쓰게 된 글이니까 정지
			}
			
			
		}
		
		System.out.println("완료");
		
		
		
		//주민등록번호 > "-"
		
		String jumin = "950215-2012457";
		
		if(jumin.charAt(6) == '-') {
			System.out.println("0");
		}else {
			System.out.println("X");
		}
		
		if(jumin.indexOf("-") == 6) {
		System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		
	} //m7
	
	
	
	
	
	
	

	private static void m6() {
		// 문자열 검색
		// 가장 많이 쓰이는 메소드
		//- int indexOf(char c)
		//- int indexOf(String s)
		//- int indexOf(char c, int beginIndex)
		//- int indexOf(String s, int beginIndex)
		//- int lastIndexOf(char c)
		//- int lastIndexOf(String s)
		//- int lastIndexOf(char c, int beginIndex)
		//- int lastIndexOf(String s, int beginIndex)
		
		String txt = "안녕하세요. 홍길동입니다.";
		
		int index = -1;
	
		index = txt.indexOf("홍"); 		//검색어를 넣기
		System.out.println(index); 		//7번째 위치에 있음
		
		index = txt.indexOf("하");		//2
		System.out.println(index);
		
		index = txt.indexOf("홍길동");	//문자열을 검색해도 시작문자의 위치값만 돌려줌
		System.out.println(index);
		
		index = txt.indexOf("홍길순");	//'홍길'까지는 찾았지만 '동'이 다르기 때문에 완전 일치 X
		System.out.println(index);		//완전일치가 될 때만 찾아줌
										//못찾았다는 의미로 -1만 출력
		txt = "안녕하세요. 홍길동입니다. 반갑습니다 홍길동입니다. 네 홍길동입니다.";
		//첫번째 홍길동은 7, 두번째는 21, 세번째는 31에 위치
		
		index = 0;
		
		while(true) { //횟수를 모르면 무한루프 짜기. for문은 조건식 비울 수 있지만 while은 안됨. true라고 적어야 함
			
			index = txt.indexOf("홍길동", index); //7 = txt.indexof("홍길동", 0); 0으로 한바퀴 돌고 난 게 =왼쪽으로 뒤집어 써지니까
			
			if(index == -1){
				break;
			}
			
			System.out.println(index);	//왜 오류나지?	
			
			index = index + 3;		//10 = 7 + 3;
									//왜 3을 넣지 3글자라서? 
									//- 찾는 글자가 세글자라서
			
			
			
		}
		
		
		//길동이가 몇 개 있고, 각각 어디에 있는지 알 때
//		index = txt.indexOf("홍길동", 0); //<- 0이 생략돼있다고 보면 됨
//		//3개의 길동이 중 첫번째 길동이의 시작문자만 반환
//		System.out.println(index);		//검색을 하면 무조건 왼쪽부터 찾아봄. 첫번째 일치문자를 찾는 순간 중단
//		//2번째 홍길동을 찾고싶으면 오버로딩 활용
//		
//		index = txt.indexOf("홍길동", 10);	//21 두번째 홍길동이 시작하는 시점부터 시작한다고 설정
//		System.out.println(index);
//	
//		index = txt.indexOf("홍길동", 24);	//31
//		System.out.println(index);
		
		
		
		//검색 방향
		txt = "안녕하세요. 홍길동입니다.";
		
		System.out.println(txt.indexOf("홍길동"));		//왼쪽 > 오른쪽으로 검색 = 위에서 아래로
		System.out.println(txt.lastIndexOf("홍길동"));	//오른쪽 > 왼쪽으로 검색 = 아래에서 위로
	}

	private static void m5() {
		// 문자열 검색
		//- boolean contains(String)
		
		String txt = "홍길동님 안녕하세요.";
		
		//boolean contains(CharSequence s)	//문자열 넣어도 된단 뜻
//		System.out.println(txt.contains(txt));
		System.out.println(txt.contains("홍길동"));	//txt내에 "홍길동"이 있음 > true
		System.out.println(txt.contains("아무개")); //txt내에 "아무개"가 없음 > false
		
		
		
		System.out.println("950215-2012457".contains("-")); 
		//"-"이 있는지 없는지만 검사하지 몇 번째에 있는지는 검사X
		
		
		
		
		
	}

	private static void m4() {
		
		// 문자열 공백 제거
		//- String trim()
		//- 문자열에 존재하는 공백(Whitespace > 스페이스, 탭, 개행)을 제거하는 메소드
		//- 문자열의 시작과 끝에 있는 공백을 제거
		
		
		String txt = "     하나     둘     셋     ";
		
		System.out.printf("[%s]\n", txt);			//[   하나   둘   셋   ]
		System.out.printf("[%s]\n", txt.trim());	//[하나   둘   셋]문자 양 끝의 공백이 사라짐
		
		
		String s1 = "자바";
		String s2 = "   자바   ";
		//앞 뒤의 공백을 입력이 아니라 실수로 봄
		//뭔갈 입력할때 trim을 주로 씀
		
		
		System.out.println(s1.equals(s2));
		//s1.equals에 s2를 넣으면 어떻게 작동하는거지..?
		
		
		
		
		
		
		
	} //m4

	private static void m3() {
		
		// 주민등록번호 or 전화번호
		//- 중간에 '-' 반드시 입력
		String jumin = "950215-1014789";
				//		01234567 -> '-'는 6번째 글자, 성별은 7번째 글자
		
		
		
		//유효성 검사하는걸 메소드로 빼기
		//validJumin 이라는 메소드에 jumin 값을 넣음
		if (validJumin(jumin)) {	//true로 반환되면 
			
			System.out.println("올바른 주민등록번호");
			
			
		}else {
			System.out.println("올바르지 않은 주민등록번호"); //false로 반환되면
		}
		
		
		//성별?
		char c = jumin.charAt(7);
		
		//1, 3 or 2, 4
//		System.out.println(c);
		
		if (c == '1' || c == '3') {
			System.out.println("남자");
		} else if(c == '2' || c == '4') {
			System.out.println("여자");
		}
		
		//char인 숫자를 진짜 숫자로 바꾸기
		//'1' > 1
//		Integer.parseInt("1");  //이건 문자열을 숫자로 바꿀때 쓰는 것
							    //문자열과 문자는 매우 다름
		//char '1'을 1로 바꾸는 공식적 방법은 존재하지 않음. 편법 사용해야 함
		
//		System.out.println('1' - 48); //문자 1의 값인 49에서 48을 빼면 1이 나옴
//		System.out.println('9' - 48); //9
		
		if((c-48) % 2 == 1) {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}
		
		
		
		
	}//m3
	
	
	
	public static boolean validJumin(String jumin) {	//jumin값을 넣음
		
//		올바르게 쓰면 true 반환, 뭘 잘못했으면 false 반환
		//
		
		if(jumin.charAt(6) == '-') {	//문자열 jumin에서 6번째 글자가 '-'면
			
			return true;		//메인 if절에 true로 들어가면 그대로 수행
			
		} else {
			return false;		//false로 들어가면 실패
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	

	public static void m2() {
		
		//문자열 추출
		//- char charAt(int index)
		//- 원하는 위치의 문자를 추출하는 메소드
		//- Zero-based Index
		
		//			  0 1 2 3 456 7 8 9 10
		String txt = "안녕하세요. 홍길동님";
		
		char c = txt.charAt(3);
		System.out.println(c);	//세
		
		c= txt.charAt(7);
		System.out.println(c);	//홍
		
		
		//Exception in thread "main" java.lang.StringIndexOutOfBoundsException: index 12,length 11
//		c = txt.charAt(12);				//없는 첨자 수를 가져옴
//		System.out.println(c);
		
		//마지막 문자
		c = txt.charAt(txt.length()-1);
		System.out.println();
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void m1() {
		
		//문자열 > 문자의 집합
		//String > char[]
		
		//char[] > 배열 조작 > 문자열을 대상으로 동일하게 발생
		
		String name1 = "홍길동";		//캐릭터의 배열
		char[] name2 = {'홍', '길', '동'};
		
		
		//문자열 길이
		//- 문자열을 구성하는 문자의 개수 > 글자수
		//- int length()
		
		System.out.println(name1.length()); //문자열 길이 : 3(홍, 길, 동 읽음)
		System.out.println(name2.length); 	//배열 길이 : 3(홍, 길, 동 읽어옴)
//		변수에 점을찍어서 나타나는건
		
		System.out.println("홍길동".length());	//=name1
//		똑같이 상수에 점 찍어도 나타남
		
		System.out.println("홍A1.".length());; //4 ""안에 있는 모든 글자 수를 읽음
		
		
		
		//요구사항] 이름을 입력하면 몇 글자인지 출력하시오
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		
		String name = scan.nextLine();
		
		System.out.println(name.length()); 		//3 출력. 문자열을 불러와서 글자수를 정수 형태로 출력
		
		//유효성 검사(2~5자 이내) 한글은 2자로 출력..?
		if(name.length() >= 2 && name.length() <= 5) {
			
			System.out.println("올바른 이름");
			
			
		}else {
			
			System.out.println("이름은 2~5자 이내로 입력!!");
		}
		
		
	}
	
	
	

}
