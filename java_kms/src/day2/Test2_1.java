package day2;

import java.util.Scanner;



public class Test2_1 {
	
	
	public static void main(String[] args) {
	
		// 국어, 영어, 수학 성적을 입력받아 출력해 보자
		// 단 성적은 0-100점 사이의 실수
		
	  Scanner sc = new Scanner(System.in);
	  
	  System.out.println("국어 점수를 입력해주세요.");
	  double kor = sc.nextDouble();
	  
	  System.out.println("영어 점수를 입력해주세요.");
	  double eng = sc.nextDouble();
	  
	  System.out.println("수학 점수를 입력해주세요.");
	  double math = sc.nextDouble();
	  
	  
	  System.out.println("국어, 영어, 수학 점수 :"+kor+" "+eng+" "+math);
	  
	  sc.close();
	  
	  
	  
		
		
	}

}
