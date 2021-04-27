package day2;

import java.util.Scanner;

public class Test2_2 {
	
	
	
	public static void main(String[] args) {
		//두 정수를 입력 받아 입력받은 두 정수의 산술 연산 결과를 출력하는 예제
		
		
	   Scanner sc = new Scanner(System.in);
	   
	   int a = sc.nextInt();
	   int b = sc.nextInt();
	   
	   System.out.println("더하기 : "+ (a+b));
	   System.out.println("빼기 : " + (a-b));
	   System.out.println("곱하기 : "+ (a*b));
	   System.out.println("나누기 : "+ (a/(double)b));
	   System.out.println("나머지 : "+ (a%b));
	}

}
