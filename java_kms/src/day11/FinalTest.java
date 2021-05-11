package day11;

public class FinalTest {

	public static void main(String[] args) {
		FinalTest ft = new FinalTest(); // 객체를 만들어서 객체 메소드를 클래스 메소드에서 사용가능
		System.out.println(ft.sum(1,2));
		//TestC.PI2 = 5;//에러 발생:  상수를 수정하려고 했기 때문에
		TestC c = new TestC(); 
		//c.PI = 3;//에러 발생:  상수를 수정하려고 했기 때문에
	}
	
	public int sum(int num1, int num2) {
		return num1 + num2;
	}
}

class TestC{
	public final double PI = 3.14;
	
	public static final double PI2 = 3.14;
	
	public final int MAX_COUNT;
	
	public TestC() {
		MAX_COUNT = 10; //final변수는 생성자를 통해 초기화 가능
	}
	
}
