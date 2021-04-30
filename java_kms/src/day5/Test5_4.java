package day5;

import java.util.Scanner;

public class Test5_4 {

	public static void main(String[] args) {
		/* 학생 3명의 성적을 입력 받은 후 총점과 평균을 출력하는 코드 작성*/
		
		int[] student = new int[3];
		int sum = 0;
		
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i<student.length; i++) {
			
			System.out.println("학생의 점수를 입력해주세요. : ");
			student[i] = sc.nextInt();
			sum += student[i];
			
			
		}
		
		double avg = (double)sum/student.length;
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		
	}
}
