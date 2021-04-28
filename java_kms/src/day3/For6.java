package day3;

import java.util.Scanner;

public class For6 {
	
	public static void main(String[] args) {
		//정수의 약수를 출력하는 코드 작성
		// 예 정수를 입력하세요 : 6  => 1 2 3 6
		// 약수의 규칙성은 값을 i로 나누었을  때 나머지가 0이면 약수이다. (i는 1부터 1씩증가)
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		for(int i = 1; i<=a; i++) {
			
			if(a%i==0) {
				System.out.print(i + " ");
			}
		}
		
		
	}

}
