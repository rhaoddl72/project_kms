package day16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryTest5 {
	
	public static void main(String[] args) {
		/*두 정수와 산술 연산자를 입력받아 산술연산 결과를 출력하는 코드를 작성하세요.
		 * 메소드 이용 버전*/
		
		Scanner sc = new Scanner(System.in);
		
		//예외 처리 시작
		try {
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		char op = sc.next().charAt(0);
		double res = 0.0;
		
		res = calculate(num1, num2, op);
		
		
		
		System.out.println(num1 + " " + op + " " + num2 + " = " + res);
		
		}catch(InputMismatchException e){
			System.out.println("잘못된 값을 입력했습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램 종료합니다.");
		sc.close();	
	}
	
	
	/*
	 * 기능 : 두 정수와 산술 연산자가 주어지면 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : 두 정수 , 산술 연산자 => int num1 , int num2, char op
	 * 리턴타입 : 산술연산 결과 => double
	 * 메소드명 : calculate
	 * */
	
	public static double calculate(int num1 , int num2, char op) {
		double res = 0.0;
		
		switch(op) {
		case '+' :
			res = num1 + num2;
			break;
			
		case '-' :
			res = num1 - num2;
			break;
			
		case '*' :
			res = num1 * num2;
			break;
			
		case '%' :
			if(num2 == 0) {
				//num2가 0인 경우 예외가 자동발생 하지만 if문과 throw문을 쓴 이유는 단순히 예외를 한글로 보여주기위해
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			res = num1 % num2;
			break;
		
	  	case '/' :
	  		if(num2 == 0) {
				//%와는 다르게 실수/정수여서 예외가 자동으로 발생하지 않아서 예외를 발생 시키기위해 사용
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
	  		res = num1 / (double)num2;
	  		break;
	  		
		default :
			//잘못된 연산자가 들어오면 예외를 발생시킴
			//RuntimeException은 실행예외 이므로 throws생략 가능 
			throw new RuntimeException("잘못된 연산자입니다.");
			}
		
		return res;
	}
	

}
