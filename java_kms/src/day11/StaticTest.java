package day11;

public class StaticTest {
	
	public static void main(String[] args) {
		TestB.printNum2();
		//객체 멤버변수 num1을 호출 => 객체를 생성한 후 멤버변수를 호출할 수 있다.
		//객체 생성 없이 객체 멤버변수를 호출할 수 없다
		TestB t1 = new TestB();
		t1.num1 = 10;
		//
		t1.num2 = 30; //객체를 통해 클래스 멤버변수를 사용할 수도 있다.하지만 이렇게는 안쓰임
		
		//정적 멤버변수 num2를 호출 => 클래스 이름을 통해 호출
		//객체 생성이 필수가 아님
		TestB.num2 = 20;
		TestB t2 = new TestB();
		
		t2.printNum1();  //객체로 부름
		TestB.printNum2(); //클래스로 부름
		
	}
	
	

}

class TestB{
	//객체 멤버 변수 정수 num1 선언
	public int num1;
	
	//클래스(정적) 멤버 변수 정수 num2 선언
	public static int num2;
	
	public void printNum1() {
		//객체 멤버변수는 객체메소드에서 사용 가능
		System.out.println("num1 : " + num1);
		num2 = 20;//객체 메소드에서 클래스 멤버변수를 사용하고있다
		printNum2();//객체 메소드에서 클래스 메소드를 사용할 수 있다.
	}
	
	public static void printNum2() {
		//클래스 멤버변수는 클래스 메소드에서 사용 가능
		System.out.println("num2 : " + num2);
		//num1 = 10; //클래스 메소드에서 객체 멤버변수를 쓰니 에러가난다.
		//printNum1();//클래스 메소드에서 객체 멤버메소드를 쓰니 에러가난다.
	}
}
