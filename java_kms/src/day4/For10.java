package day4;

import java.util.Scanner;

public class For10 {
	
	public static void main(String[] args) {
		//반복 횟수가 정해져 있지 않은 예제
		//콘솔에서 q나 Q를 입력받을 때까지 반복하는 예제
		
		
		Scanner sc = new Scanner(System.in);
		
		for(char ch = 'a';ch != 'q' && ch != 'Q';) { //증감부분 빼고 적어준다.
			
			System.out.println("알파벳을 입력하세요(종료하려면 q/Q를 입력) : ");
			ch = sc.next().charAt(0);
			
		}
		System.out.println("종료되었습니다.");
		sc.close();
		
		
	}

}
