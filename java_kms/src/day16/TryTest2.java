package day16;

public class TryTest2 {
	
	public static void main(String[] args) {
		int num1 = 1,num2 = 0;
		/*
		try {
			System.out.println(num1/num2);
		}catch(Exception e){
			System.out.println("Exception 발생");
		}
		//catch는 위에서부터 확인하기 때문에 위에 있는 Exception이 모든 예외를 처리하기 때문에 여기까지 오지 않는다. 그래서 에러 발생
		//부모 클래스를 자식 클래스보다 아래쪽에 배치해야 한다.
		//Exception이 모든 예외를 관리하니까 마지막에 있어야한다.
		catch(ArithmeticException e) {
			System.out.println("ArithmeticException 발생");
		}*/
		
		
		
		
		//이상적인 예외 처리
		try {
			System.out.println(num1/num2);
		}catch(ArithmeticException e){
			System.out.println("Exception 발생");
		}catch(RuntimeException e) {
			System.out.println("ArithmeticException 발생");
		}catch(Exception e) {
			System.out.println("ArithmeticException 발생");
		}
	}

}