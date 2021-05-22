package day17;

import java.util.Scanner;

	public class StringTest3 {
		
		
		public static void main(String[] args) {
			
			//있으면 시작하는 번지를 알려줌 a:0번지 b:1번지
			//System.out.println("abcdef".indexOf("bc"));
			
			//없으면 -1
			//System.out.println("abcdef".indexOf("ad"));
			
			/*두 단어 단어A와 단어B를 입력받고 단어A에 단어B가 있는지 없는지 확인하는 코드 작성
			 * */
			
			Scanner sc = new Scanner(System.in);
			System.out.println("단어와 비교할 단어를 입력해 주세요.");
			
			String str1 = sc.next();
			String str2 = sc.next();
			
			//equals는 리턴타입이 boolean이라 조건식을 써줄 필요 없이 바로 했지만 indexOf는 리턴타입이 int이기 때문에 숫자로 조건을 걸어줘야 한다.
			if(str1 != null && str1.indexOf(str2) != -1) {
				System.out.println("단어가 포함되어 있습니다.");
			}
			else {
				System.out.println("단어가 포함되지 않습니다.");
			}
			
			if(str1 != null) {
				System.out.println(str1 + "의 길이 : " + str1.length());
			}
			
			//배열은 length에 ()가 없는데 문자열은 있다.
			int[] arr = new int[5];
			System.out.println(arr.length);
			
			sc.close();
		}
		
	}
