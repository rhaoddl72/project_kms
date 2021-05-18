package day16;

import java.util.Scanner;

public class TryTest4 {
	
	public static void main(String[] args) {
		/*두 정수와 산술 연산자를 입력받아 산술연산 결과를 출력하는 코드를 작성하세요.*/
		
		Scanner sc = new Scanner(System.in);
		
		//예외 처리 시작
		try {
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		String c = sc.next();
		double res = 0.0;
		//char  c1 = sc.next().charAt(0);
				
		
		/*if(c1 == '+') {
			
			System.out.print(num1 + c1 + num2 + "=" + (num1+num2));
		}
		else if(c1 == '-') {
			System.out.print(num1 + c1 + num2 + "=" + (num1-num2));
		}
		else if(c1 == '*') {
			System.out.print(num1 + c1 + num2 + "=" + (num1*num2));
		}
		else if(c1 == '/') {
			System.out.print(num1 + c1 + num2 + "=" + (num1/(double)num2));
		}
		else if(c1 == '%') {
			System.out.print(num1 + c1 + num2 + "=" + (num1%num2));
		}*/
		
		
		switch(c) {
		case "+" :
			res = num1 + num2;
			break;
			
		case "-" :
			res = num1 - num2;
			break;
			
		case "*" :
			res = num1 * num2;
			break;
			
		case "%" :
			res = num1 % num2;
			break;
		
	  	case "/" :
	  		res = num1 / (double)num2;
	  		break;
	  		
		default :
			throw new Exception("잘못된 연산자입니다.");
			//throw를 쓰면 기본예외가 아니더라도 예외를 발생시켜줌
		}
		System.out.println(num1 + " " + c + " " + num2 + " = " + res);
		
		}catch(ArithmeticException e){
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램 종료합니다.");
		sc.close();	
	}
	

}
