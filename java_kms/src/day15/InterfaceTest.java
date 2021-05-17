package day15;

public class InterfaceTest {
	
	public static void main(String[] args) {
		
	}

}

class A1 {
	
	void print() {
		System.out.println("Hello");
	}
}

class A2 {
	
	void print() {
		System.out.println("Hi");
	}
}

//상속은 여러 개의 부모를 갖지 못한다.
/*class AC extends A1, A2{
	//상속은 print()메소드를 호출했을 때 부모 둘 중 누구의 메소드인지를 구별 할 수 없다.
	//그래서 클래스에서 상속은 부모가 1명만 올 수 있다.
	void test() {
		print(); 
	}
	
}*/


interface B1{
	void print();
}

interface B2{
	void print();
}

//인터페이스는 여러 개의 부모를 갖는다.
//인터페이스는 구현 클래스에서 구현을 다시 하기 때문에 구별 할 수 있다. 
class BC implements B1,B2{

	@Override
	public void print() {
		System.out.println("안녕");
		
	}
	
}

//C1 클래스는 A1 클래스를 상속 받고, B1,B2 인터페이스를 구현한 클래스이다.
class C1 extends A1 implements B1, B2{
	@Override
	public void print() {
		System.out.println("안녕");
		
	}
}
