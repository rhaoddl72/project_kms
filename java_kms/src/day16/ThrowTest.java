package day16;

public class ThrowTest {

	public static void main(String[] args) {
		int num = 1;
		
		try {
		if(num == 1) {
			
			RuntimeException e = new RuntimeException("예외");
			throw e;
			//위 2줄이 아래 한줄이랑 같다.
			//throw new RuntimeException("예외"); //내가 직접 예외 처리를 해준다.
		}
		}catch(RuntimeException e) {
			System.out.println("실행 예외가 발생");
		}catch(Exception e) {
			System.out.println("예외 발생");
		}
		//Exception는 실행예외가 아니고 일반예외이기 때문에 예외처리가 필수이다.
		//예외처리를 안한 아래 코드는 에러 발생
		//throw new Exception();
		
		//RuntimeException은 실행 예외이기 때문에 예외처리를 안해도 에러 발생x
		throw new RuntimeException("예외");
	}
}
