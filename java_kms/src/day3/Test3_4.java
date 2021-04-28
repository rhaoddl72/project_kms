package day3;

import java.util.Scanner;

public class Test3_4 {
	
	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력받아 계산 결과를 출력하는 예제 switch문 사용
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		char c = sc.next().charAt(0);
		
		switch(c) {
		
		case '+' :
			System.out.println("" + a + " "+c+" "  + b + " = " + (a+b));
			break;
		case '-' :
			System.out.println("" + a + " "+c+" "  + b + " = " + (a-b));
			break;
		case '*' :
			System.out.println("" + a + " "+c+" "  + b + " = " + (a*b));
			break;
		case '/' :
			System.out.println("" + a + " "+c+" "  + b + " = " + (a/(double)b));
			break;
		case '%' :
			System.out.println("" + a + " "+c+" "  + b + " = " + (a%b));
		    break;
		default :
			System.out.println("잘못 입");
		
		}
		
		sc.close();
		
		
		
	}

}
