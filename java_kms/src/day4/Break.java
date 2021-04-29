package day4;

import java.util.Scanner;

public class Break {
	
	public static void main(String[] args) {
		
		// break 예제
		
		for(int i = 1; ; i++) {
			if(i>5) {
				break;
			}
			System.out.println(i);
		}
		
		for(int i = 1; ; i++) {
			
			System.out.println(i);
			if(i==5) {
				break;
			}
		}
		
		
		char ch;
		Scanner sc = new Scanner(System.in);
		for(;;) {
			System.out.println("문자를 입력하세요(종료하려면 q/Q 입력) : ");
			ch = sc.next().charAt(0);
			if(ch == 'q' || ch == 'Q') {
				break;
			}
		}
		sc.close();
	}

}
