package com.test.java;

import java.util.Arrays;

public class Ex35_Array {
	
	public static void main(String[] args) {
		
		//Ex35_Array.java
		
		//배열의 차원(다차원 배열)
		
//		m1(); //n차원 배열
//		m2();
//		m3(); //n차원별 초기화 리스트
//		m4();
		m5(); // 탐색 순서
		
		
		
		
		
		
		
		
		
		
		
		
	} //main

	private static void m5() {
	
		
		int[][] nums = new int[5][5]; 	//5행 5열
		
//		System.out.print(Arrays.toString(nums));	//dump
		// [[I@5e853265, [I@67205a84, [I@7d0587f1, [I@5d76b067, [I@2a17b7b6]
		//toString은 가장 바깥쪽에 있는것만 dump시킴. 안에 있는건 기본값으로 출력
		
		int n = 1;
		
		
		//아래의 루프가 방을 탐색한 순서(가로로 증가)
//		for(int i=0; i<5; i++) {
//			for(int j=0; j<5; j++) {
//				nums[i][j] = n;
//				n++;
//			}
//		}
//		// 세로로 증가
//		for(int j=0; j<5; j++) {
//			for(int i=0; i<5; i++) {
//				nums[i][j] = n;
//				n++;
//			}
//		}
//			
//		for(int j=0; j<5; j++) {
//			for(int i=0; i<5; j++) {
//				nums[j][i] = n;
//				n++;
//				}
//			}
		
		for(int i=0; i<5; i++) {
			for(int j=i; j<5; j++) {
				nums[i][j] = n;
				n++;
			}
		}
		
		

			
			
		printArray(nums);
		
		
		
		
		
	}

	private static void printArray(int[][] nums) {
		
		for(int i=0; i<nums.length; i++) {
			
			for(int j=0; j<nums[0].length; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
		
		
	}

	private static void m4() {
		
		// 성적표
		// 여러명의 국, 영, 수 점수(Ex34의 m5 참고)
		
		//int[]
		//String[] > 100 > "100" > Integer.parseInt("100")
		
		int[][] score = new int[10][3];  // 10명 * 3과목 (보통 사람이 제일 상위로 오니까 ㅎ)
		
		for(int i=0; i<score.length; i++) {
			
			for(int j=0; j<score[0].length; j++) {
				
				score[i][j] = (int)(Math.random()*41) + 60;	//10명 분량의 3과목 출력
				
				
			}
			
		}
		
			for(int i=0; i<score.length; i++) {
			
				for(int j=0; j<score[0].length; j++) {
					
					System.out.printf("%5d\t%5d\t%5d\n"
										, score[i][j]);		//i번째 학생의 [0]번째 칸이 국어 점수
					}
					System.out.println();
			}
			
		
		
	} //m4

	private static void m3() {
		
		
		// 초기화 리스트
		
		int[] nums1 = { 10, 20, 30 };
		
		int[][] nums2 = { {10, 20, 30}, {40, 50, 60} }; //{ A, B } //A 1층, B 1층 각각에 값이 들어있는 것
		
		//{ A, B }
		//A = { C, D }
		//C = { 10, 20, 30 }
		int[][][] nums3 = {{ {10, 20, 30}, {40, 50, 60} }, { {10, 20, 30}, {40, 50, 60} } };
		//-> 너무 복잡함
		int[][][] nums4 = {
								{
									{10, 20, 30},
									{40, 50, 60}
								}, //2차원
								
								{
									{10, 20, 30}, //1차원
									{40, 50, 60}  //1차원
								} //2차원
						   }; //3차원
		
	} //m3
	
	
	
	
	
	
	
	
	
	

	private static void m2() {

//		int[] nums = new int[3];
		int nums[] = new int[3];	//위와 같은 식. 비권장
		
		//배열의 길이
		int[] nums1 = new int[3];
		System.out.println(nums1.length); //3
		
		int[][] nums2 = new int[2][3];
		System.out.println(nums2.length); //2
		
		int[][][] nums3 = new int[5][3][2];
		System.out.println(nums3.length); //5
		//맨 앞 숫자만 출력이 됨
		
		//nums3 자료형? int[][][] > int 3차원 배열입니다.
		//nums3[0] 자료형? > int[][] > int 2차원 배열입니다.
		//nums3[0][0] 자료형? > int[] > int 배열입니다.
		//nums3[0][0][0] 자료형? > int
		
		
	} //m2
	
	
	
	
	
	
	
	
	
	
	

	private static void m1() {
		
		//[] 하나당 한 차원(앞에 오는게 더 상위 개념)
		
		// 1차원 배열 (행, 아파트 층)
		int[] nums1 = new int[3];
		
		
		//2차원 배열 (행+열, 아파트 동(층이 위아래로 여러개))
		int[][] nums2 = new int[2][3];	//2(행), 3(열)
										//가로가 먼저, 세로가 나중
		
		
		//3차원 배열 (면(행+열), 아파트 단지(동이 여러개))	
		int[][][] nums3 = new int[4][3][2];	//4(면), 3(행), 2(열) => 방이 24개 만들어짐
		
		//행이 6개인 것이랑 (행3개, 열2개)인 것에는 같은 값을 넣을 수 있음
		
		
		
		//배열 요소(방) 접근하기
		//1차원 배열(행)
		nums1[0] = 100;
		nums2[1] = 200;
		nums3[2] = 300;
		
		//2차원 배열(행, 열)
		//456
		//123
		nums2[0][0] = 100; 		//0번째 층에 0번째 방
		nums2[0][1] = 200;		
		nums2[0][2] = 300;
			
		nums2[1][0] = 400;		//1번째 층에 0번째 방
		nums2[1][1] = 500;
		nums2[1][2] = 600;
		
		//3차원 배열(면, 행, 열)
		nums3[0][0][0] = 100;
		nums3[0][0][1] = 200;
		nums3[0][0][2] = 300;
		
		nums3[0][1][0] = 400;
		nums3[0][1][1] = 500;
		nums3[0][1][2] = 600;	//첫번째 면 끝남
		
		nums3[1][0][0] = 700;
		nums3[1][0][1] = 800;
		nums3[1][0][2] = 900;
		
		nums3[1][1][0] = 1000;
		nums3[1][1][1] = 1100;
		nums3[1][1][2] = 1200;	//두번째 면 끝남
		
		
		
		
		//출력 > 배열 탐색
		//1차원 배열 탐색할때 단일 for문을 주로 씀
		for(int i=0; i<nums1.length; i++) {
			System.out.printf("nums1[%d] = %d\n", i, nums1[i]);
		}
		System.out.println(); //매번 하던 것
		
		
		for(int i=0; i<nums1.length; i++) {
			System.out.printf("%5d", nums1[i]);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//2차원 탐색 > 2중 for문
		for(int i=0; i<nums2.length; i++) {	//바깥쪽 큰 배열의 길이 > 2 > 쌓아올려져 있는 행의 개수
			
			for(int j=0; j<nums2[0].length; j++) { //안쪽 작은 배열의 길이 > 3	> 1차원 배열
				
//				System.out.println(i + "," + j);
				
				System.out.printf("nums2[%d][%d] = %d\n", i, j, nums2[i][j]);
				
			}
			
			
			
		}
		System.out.println();
		
		
		for(int i=0; i<2; i++) {							//행을 찍음
			
			for(int j=0; j<3; j++) {						//열을 찍음
		
				System.out.printf("%5d", nums2[i][j]);
		
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
		
		//3차원 탐색 > 3중 for문
		for(int i=0; i<nums3.length; i++) { 				//가장 바깥쪽 배열의 길이 > 2		//면이 2개라 2이하
			for(int j=0; j<nums3[0].length; j++) {			//중간 배열의 길이 > 2
				for(int k=0; k<nums3[0][0].length; k++) {	//가장 안쪽 배열의 길이 > 3
					
					System.out.printf("nums[%d][%d][%d] = %d\n"
										, i, j, k, nums3[i][j][k]);
					
				} //3중 for
			} //2중 for
		} //1중 for
		System.out.println();
		
		
		for(int i=0; i<2; i++) { 						//면이 2개라 2이하
			for(int j=0; j<2; j++) {
				for(int k=0; k<3; k++) {
					
					System.out.printf("%5d", nums3[i][j][k]);
					
				} //3중 for
				System.out.println();
			} //2중 for
			System.out.println();
		} //1중 for
		
		
		
		
		
		
		
	} //m1

} //class
