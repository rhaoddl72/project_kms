package day17;

import java.util.Scanner;


public class StringTest1 {
	//charAt()메소드 예제
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력");
		//char op = sc.next().charAt(0); 체이닝 기법활용한것
		
		//Scanner클래스에서 제공하는 메소드 next()사용
		String str = sc.next(); //sc.next()는 콘솔에서 문자열을 입력받아 가져오는 역할
		
		//String 클래스에서 제공하는 메소드 charAt사용
		char op = str.charAt(0); 
		
		System.out.println("입력 문자 : " + op);
		
		sc.close();
	}
}
