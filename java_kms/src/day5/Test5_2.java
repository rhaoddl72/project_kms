package day5;

public class Test5_2 {

	public static void main(String[] args) {
		
		//참조변수 주
		
		String str1 = "ab"; //리터럴   자바는 메모리에 리터럴 값들읆 모아놓고 같은 값이 나오면 값을 새로 만들지 않고 그냥 공유한다.
		String str2 = "ab"; // 그러므로 리터럴 값은 주소가 같다.
		
		if(str1==str2) {
			System.out.println("두 문자열이 같습니다.");
		}
		else  {
			System.out.println("두 문자열이 다릅니다.");
		}
		

		String str3 = new String("ab"); // 두 문자열이 다르다 나온다.
		String str4 = new String("ab");
		
		if(str3==str4) {
			System.out.println("두 문자열이 같습니다.");
		}
		else  {
			System.out.println("두 문자열이 다릅니다.");
		}
		
	}
}
