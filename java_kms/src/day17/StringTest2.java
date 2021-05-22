package day17;

import java.util.Scanner;

public class StringTest2 {

	public static void main(String[] args) {
		
		//이런식으로 String클래스 객체가 아닌 ""로 바로 만든 문자열도 사용 가능
		//System.out.println("홍길동".equals("홍길동"));
		
		/*두 단어를 입력받아 두 단어가 같은 단어인지 확인하는 코드를 작성하세요.
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.println("두 단어를 입력하세요(예 : abc cde) : ");
		
		String str1 = sc.next();
		String str2 = sc.next();
		
		//equals쓸 때는 null체크를 해줘야 한다.
		if(str1 != null && str1.equals(str2)) {
			System.out.println(str1 +" "+str2+" "+"는 같은 단어입니다.");
		}
		else {
			System.out.println(str1 +" "+str2+" "+"는 다른 단어입니다.");
		}
		
		sc.close();
		
	}
}
