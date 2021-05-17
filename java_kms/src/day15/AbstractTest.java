package day15;

public class AbstractTest {

	public static void main(String[] args) {
		//클래스 A의 객체 a를 생성
		A a = new A();
		
		//추상 클래스 B의 객체 b를 생성
		//B b = new B();//오류 발생
		
		//추상클래스를 상속 받은 C클래스는 객체 생성 가능
		C c = new C();
		
		//클래스 C를 이용하여 객체를 생성한 후 추상 클래스 B의 객체에 저장
		//부모를 자식한테 집어 넣는 것이 가능 자식이 부모보다 데이터가 크니까
		B b1 = new C(); //클래스 타입변환 (자동) //부모 자식간에만 타입변환이 가능하다.
		
		//자식을 부모한테 집어넣을 수가 없다. 부모는 자식보다 데이터 양이 적으니까
		//C c1 = new B();
	}
}


class A{}

abstract class B{
	//추상메소드 상속받은 클래스에 오버라이드 해줘야 한다.
	abstract void print(); 
}


class C extends B{

	@Override
	void print() {
		
		
	}
	
}

class D{}
