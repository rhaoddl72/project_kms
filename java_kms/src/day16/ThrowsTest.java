package day16;

public class ThrowsTest {

	public static void main(String[] args) {
		try {
			test();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Exception은 실행 예외가 아니라 꼭 throws ~~ 적어줘야함
	//실행예외이면 throws ~~ 부분을 생략해줘도 된다. 실행예외는 RuntimeException류들
	//예외를 여러개 적어줄 수도 있다. ,사용
	public static void test() throws Exception, ArithmeticException { 
		throw new Exception("test 메소드에서 예외 발생");
	}
}
