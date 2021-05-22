package day17;

import java.util.Scanner;

public class StringTest4 {

	
	public static void main(String[] args) {
		//System.out.println("제 이름은 홍길동입니다.".replace("홍길동", "임꺽정"));
		
		/*문자열 c를 입력 받고, 해당 단어에 문자열A와 문자열 B를 입력받아 문자열C에 있는 문자열 A를 문자열B로 바꾸는 코드를 작성하세요.
		 **/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("단어를 입력하세요. : ");
		String c = sc.next();
		
		System.out.println("수정할 곳의 단어와 수정될 단어를 입력하세요.(예:자바 java)");
		String a = sc.next();
		String b = sc.next();
		
		if(c != null && c.indexOf(a) != -1) {
			c = c.replace(a, b); //그냥 c.replace해주면 안되고 "c ="처럼 변수에 넣어서 해줘야 한다.
			System.out.println("바뀐 단어 : " +c);
			
		}else {
			System.out.println("단어를 바꿀 수 없습니다.");
		}

		sc.close();
	}
}
