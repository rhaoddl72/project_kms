package day10_1;

import day10.A;
import day10.B;
import day10.C;
import day10.D;
import day10.ClassEx1; //day10 패키지에있는 클래스 ClassEx1을 가져오려 한다.

public class ClassEx2 {

	public static void main(String[] args) {
		
		A a = new A();
		a.num = 10; 
		// public이기 때문에 에러가 발생하지 않음
		
		B b = new B();
		//b.num = 10; 
		// protected는 클래스B와 ClassEx2이 다른 패키지에 있기에 에러 발생
		
		C c = new C();
		//c.num = 10;
		// default는 클래스B와 ClassEx2이 다른 패키지에 있기에 에러 발생
		
		D d = new D();
		//d.num = 10; 
		// 에러 발생 : num의 접근제한자가 private이어서
	}
}
