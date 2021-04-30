package day5;

import java.util.Scanner;

public class DoWhile {
	
	public static void main(String[] args) {
		
		char ch = 'q';
		Scanner sc = new Scanner(System.in);
		
		do { //무조건 1번 실행
			System.out.println("입력(종료하려면 q입력) : ");
			//ch = sc.next().charAt(0);
			
			
		}while(ch != 'q' && ch != 'Q');
		
		sc.close();
		
		
	}

}
