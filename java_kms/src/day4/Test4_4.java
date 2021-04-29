package day4;

import java.util.Scanner;

public class Test4_4 {
	
	public static void main(String[] args) {
		/*
		 * Math.random() = A
		 * 0 <= A < 1
		 * 0 * (max - min + 1) <= A * (max - min + 1) < 1 * (max -min +1)
		 * 0 <= A * (max - min + 1) < max - min + 1
		 * min <= A * (max - min + 1) + min < max + 1
		 * */
		
		
		int min  = 1, max = 100;
		//math.random()은 0보다 크거나 같고 1보다 작은 임의의 실수를 생성하는 기능(0<=math.random()<1)
		int r = (int)(Math.random() * (max - min +1) + min);
		/* 정수를 랜덤으로 생성하여 생성된 숫자를 맞추는 게임
		 * 예시 (랜덤하게 생성된 숫자가 25인 경우)
		 * 정수가 랜덤으로 생성되었습니다. 게임 시작!
		 * 정수를 입력하세요 : 100
		 * down
		 * 정수를 입력하세요 : 40
		 * down
		 * 정수를 입력하세요 : 25
		 * 정답입니다.*/
		
		
		Scanner sc = new Scanner(System.in);
		
		
		for(;;) {
			System.out.println("정수를 입력하세요( "+min+" ~ "+ max + ") :" );
			int num = sc.nextInt();
			if(r>num) {
				System.out.println("up");
			}
			else if(r<num) {
				System.out.println("down");
			}
			else {
				System.out.println("정답입니다.");
				break;
			}
		}
		sc.close();
		
	}

}
