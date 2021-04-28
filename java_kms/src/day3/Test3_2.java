package day3;

import java.util.Scanner;

public class Test3_2 {
	
	public static void main(String[] args) {
		
		// 정수를 입력 받아 입력받은 정수가 0, 양수, 음수인지 판별하는 코드를 작성
		
	
		Scanner sc = new Scanner(System.in);
		
		double a = sc.nextDouble();
		
		if(a>0) {
			System.out.println("정수입니다.");
			
		}
		else if(a==0) {
			System.out.println("0입니다.");
		}
		else if(a<0) {
			System.out.println("음수입니다.");
			
		}
		
		sc.close();
	}

}
