package day13;

import board.Board;

public class VariableTest {

	public static void main(String[] args) {
		int sum = 0; // 일반변수 + 지역변수 => {}안에서만 사용 가능
		String str3 = "Hello"; // 참조변수이면서 객체이다. + 지역변수 => {}안에서만 사용 가능
		int[] arr = new int[5]; //참조변수이면서 배열이다. + 지역변수 => {}안에서만 사용 가능
		Board[] board = new Board[5]; //참조변수이면서 배열이다. + 지역변수 => {}안에서만 사용 가능
	}
}

class A{
	//멤버 변수는 클래스 전체에서 모두 사용 가능
	int num1; //일반변수 + 객체 멤버변수 
	static int num2;//일반변수 + 클래스 멤버변수
	String str1; //참조변수이면서 객체이다. + 객체 멤버변수
	static String str2; //참조변수이면서 객체이다. + 클래스 멤버변수
	
	public A(int num3, int num4) { //일반변수이면서 매개변수
		num1 = num3;
		num2 = num4;
	}
}
