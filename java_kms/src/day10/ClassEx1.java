package day10;

public class ClassEx1 {

	public static void main(String[] args) {
	
		A a = new A();
		a.num = 10; 
		// public이기 때문에 에러가 발생하지 않음
		
		B b = new B();
		b.num = 10; 
		// protected는 클래스B와 ClassEx1이 같은 패키지에 있기에 에러 발생x
		
		C c = new C();
		c.num = 10;
		// default는 클래스B와 ClassEx1이 같은 패키지에 있기에 에러 발생x
		
		D d = new D();
		//d.num = 10; 
		// 에러 발생 : num의 접근제한자가 private이어서
		d.setNum(10); //D클래스의 set메소드를 통해 에러없이 10의 값을 설정했다.
		System.out.println(d.getNum());
		
	}
	
}


	
