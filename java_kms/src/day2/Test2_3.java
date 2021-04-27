package day2;

import java.util.Scanner;

public class Test2_3 {

	
	public static void main(String[] args) {
		
		//국어 성적을 입력 받고 입력 받은 성적이 국어 과목을 패스 했는지 안했는지 코드를 작성
		// 국어 성적이 60점 미만이면 fail 60점 이상이면 pass
		
	
		Scanner sc = new Scanner(System.in);
		
		int kor = sc.nextInt();
		
		String pass = (kor>=60) ? "pass" : "fail" ;
		
		System.out.println("패스 여부 : " + pass);
		
	}
}
