package day3;

import java.util.Scanner;

public class Test3_5 {
	
	public static void main(String[] args) {
		// 월의 마지막 일수를 출력하는 예제를 switch문으로 작성하세요.
		// 31 : 1 3 5 7 8 10 12
		// 30 : 4 6 9 11
		// 28 : 2
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("확인하고 싶은 달을 입력해 주세요 :");
		int month = sc.nextInt();
		
		
		switch(month) {
		
		case 1, 3, 5, 7, 8, 10, 12 : // month가 1, 3, 5, 7, 8, 10, 12일 때마다 실행문이 실행된다.
			System.out.println("31일 까지입니다.");
			break;
		case 2 :
			System.out.println("28일 까지입니다.");
			break;
		
		case 4 : case 6 : case 9 : case 11 :  // month가 4,6,9,11일 때 11에 해당하는 실행문을 실행  4,6,9일 때는 실행문이 없다.
			System.out.println("30일 까지입니다.");
			break;
		
		default :
			System.out.println("잘못 입력");
		
		
		
		}
	}

}
