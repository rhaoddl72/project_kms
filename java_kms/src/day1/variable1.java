package day1;

public class variable1 {

	public static void main(String[] args) {
		
		// 정수형 변수 선언
		// 변수타입 변수명 = 값;
		
		byte num1 = 127;
		
		short num2 = 32767;
		
		int num3 = 2147483647;
		
		long num4 = 2147483648l;
		
		int num5 = 0b111; //0b 2진수
		
		int num6 = 0111; //0 8진수
		
		int num7 = 0x111;//0x 16진수
		
		int num8 = 111;
		
		
		char c1 = '한';
		
		System.out.println(num5);
		System.out.println(num6);
		System.out.println(num7);
		System.out.println(num8);
		
		float dnum1 = 1.12345678901234567f;
		double dnum2 = 1.12345678901234567;
		
		System.out.println(dnum1);
		System.out.println(dnum2);
		
		boolean stop = true;
		System.out.println(stop);
		
		String str = "hello";
		System.out.println(str);

	}

}
