package day4;

import java.util.Scanner;

public class Test4_3 {
	
	public static void main(String[] args) {
		/* 정수를 거꾸로 출력
		   정수를 입력하세요 : 1234
		   결과 : 4321
		   1234 => 4를 출력 num = 123
		   123 = > 3을 출력 num = 12
		   12 => 2를 출력 num = 1
		   1 => 1을 출력 num = 0
		   반복문 종 */
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		System.out.print("결과 : ");
		sc.close(); // close는 scanner사용 끝난 시점에서 해주면 된다.
		for(; ;) {
			
			
			System.out.print(num % 10); //num을 10으로 나눈 나머지를 출력;
			num = num / 10; // num에 num를 10으로 나눈 몫을 저장;
			
			if(num==0) {
				
				break;
			}
			
		}
		
	}

}
