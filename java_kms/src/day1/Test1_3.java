package day1;

import java.util.Scanner;

public class Test1_3 {

	public static void main(String[] args) {
		// 두 정수와 문자를 입력받아 출력하는 예제를 작성
		// 정수 1을 입력
		// 문자 +를 입력
	    // 정수 2를 입력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 1을 입력하세요 :");
		int a = sc.nextInt();
		
		
		System.out.print("문자를 입력하세요 :");
		char b = sc.next().charAt(0);
		
		
		System.out.print("정수 2를 입력하세요 :");
		int c = sc.nextInt();
		
		
		System.out.println("" + a + b + c);
		
		System.out.print("두 정수와 문자를 입력해주세요 (예 1 + 2) : ");
		int d = sc.nextInt();
		int f = sc.nextInt();
		char e = sc.next().charAt(0);
		System.out.println(""+d+e+f);
		
		sc.close();
		
		
		
		
	}
}
