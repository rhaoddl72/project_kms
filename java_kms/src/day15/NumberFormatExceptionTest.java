package day15;

public class NumberFormatExceptionTest {

	public static void main(String[] args) {
		String numstr = "1234a";
		//문자열이 숫자가 아닌 a라는 문자가 있어 예외 발생
		//parsInt(문자열) : 문자열이 주어지면 정수를 반환하는 메소드
		int num = Integer.parseInt(numstr);
		System.out.println(num);
	
	}
}
