package day11;

public class ConstructorOverloadingEx1 {

	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A(1,2);
		//A a3 = new A(1.0,2); //실수가 정수로 자동 형변환이 안되기 때문에 에러
		A a4 = new A('a',3); //문자는 정수로 자동 형변환이 되기 때문에 에러발생x
	}
}

class A{
	private int num1;
	private int num2;
	
	public A() {}
	
	
	public A(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	
	//복사 생성자 : 생성자의 매개변수로 같은 클래스의 객체가 오는 경우
	//참조변수의 =은 값을 주는게아니라 값을 공유하는거기 때문에 복사생성자필요
	public A(A a) { //매개변수 A는 클래스이름과 동일 객체 이름인 a는 다를 수 있음
		num1 = a.num1;
		num2 = a.num2;
	}

	public A(double num10, double num11){
		  
	  }
	  
	  public void A() {} //생성자와 이름이 같은 메소드
	  
}