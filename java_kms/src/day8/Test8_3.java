package day8;

import java.util.Scanner;

public class Test8_3 {
	
	/*
	 * 4개의 성적을 입력받아 합격인지 불합격인지 판별하는 코드를 작성하세요.
	 * 합격 기준
	 * - 모든 성적이 과락이 없어야 함
	 * - 평균 60점 이상
	 * 과락 : 성적이 40점 미만인 경우
	 *  */
	public static void main(String[] args) {
		
	
	Scanner sc = new Scanner(System.in);
	int sum = 0;
	int arr[] = new int[4];
	boolean pass = true; // false : 불합격, true : 합격
	
	
	System.out.println("성적을 입력해주세요. : ");
	for(int i = 0; i<arr.length; i++) {
		
		arr[i] = sc.nextInt();
		sum += arr[i];
		
	}
	sc.close();
	
	double avg = (double)sum/arr.length;
	 if(avg < 60) {
			pass = false;
			
		}
	 
	 
		for(int tmp : arr ) {
			if(tmp < 40) {
				pass = false;
			}
		}
		
		if(pass) {
			System.out.println("합격입니다.");
		}
		else {
			System.out.println("불합격입니다.");
		}

	}
	
	
	
}

