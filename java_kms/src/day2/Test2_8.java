package day2;

import java.util.Scanner;

public class Test2_8 {
	
	public static void main(String[] args) {
		
		// 두 정수와 산술 연산자를 입력받아 입력받은 연산자에 맞는 연산 결과를 출력하는 코드를 작성
		// 두 정수와 연산자를  입력하세요 : 1 + 2
		
		// 1+ 2 = 3
		
		
	    Scanner sc = new Scanner(System.in);
	    
	    int a = sc.nextInt();
	    char b = sc.next().charAt(0);
	    int c = sc.nextInt();
	    
	    
	    if(b == '+') {
	    	System.out.println("결과 : " + a+" " + b+" " + c + " = " + (a+c));
	    }
	    else if(b == '-') {
	    	System.out.println("결과 : " + a+" " + b+" " + c + " = " + (a-c));
	    }
	    else if(b == '*') {
	    	System.out.println("결과 : " + a+" " + b+" " + c + " = " + (a*c));
	    }
	    else if(b == '/') {
	    	System.out.println("결과 : " + a+" " + b+" " + c + " = " + (a/(double)c));
	    }
	    else {
	    	System.out.println("결과 : " + a+" " + b+" " + c + " = " + (a%(double)c));
	    }
		
	    sc.close();
	}

}
