package day16;

public class TryTest3 {

	public static void main(String[] args) {
		int num1 = 1, num2 = 0;
		
		try {
			System.out.println(num1/num2);
		}catch(Exception e) {
			System.out.println("예외발생");
			return; 
			//return을 하더라도 메소드에서 빠져나가면서 finally문은 실행된다.
			//프로그램 종료는 실행되지 않는다.
		}finally {
			System.out.println("finally 실행");
		}
		
		System.out.println("프로그램 종료");
	}
}
