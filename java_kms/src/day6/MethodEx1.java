package day6;

public class MethodEx1 {

	public static void main(String[] args) {
		//메소드 예제
		//메소드명(값);
		add(1,2); //동작은 되지만 그냥  3일뿐 별 의미없음
		
		System.out.println(add(1,2)); //3
		
		add2(1,2); // add2는 반환값이 없고 메소드안에 출력문이있기 때문에 이렇게만 해줘도 출력된다.
		
		//printMultiTable(8);
		
		System.out.println(gcd(8,12));
		
	}
	/* 기능 : 두 정수가 주어지면 두 정수의 합을 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 정수의 합 => 정수 => int
	 * 메소드명 : add 
	 */
	public static int add(int num1, int num2) {
		
		int result = num1 + num2;
		
		return result;
		
	}
	
	
	/* 기능 : 두 정수가 주어지면 두 정수의 합을 콘솔에 출력하는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 없음 => void
	 * 메소드명 : add2
	 */
	
	public static void add2(int num1, int num2) {
	
		int res = num1 + num2;
		System.out.println(num1 + "+" + num2 + "=" + res );
	}
	
	
	/* 기능 : 두 정수와 산술연산자가 주어지면 두 정수의 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : 두 정수와 char => int num1, int num2, char op
	 * 리턴타입 : 산술 연산 결과 => 실수 => double
	 * 메소드명 : Calculate
	 */
	
	public static double calcuaString(int num1, int num2, char op) {
		return 0.0;
		 //res = num1 + num2 + op;
		
	}
	
	
	/* 기능 : 두 정수의 최대 공약수를 알려주는 메소드
	 * 매개변수 : 두 정수 = > int num1, int num2
	 * 리턴타입 : 최대 공약수 결과 => int
	 * 메소드명 : gcd
	 */
	
	public static int gcd(int num1, int num2) {
		
		int gcd = 0; //메소드랑 변수랑 이름이 같아도 된다.
		
		for(int i=1; i<num1; i++) {
			if(num1%i==0 && num2%i==0) {
				gcd = i;
			}
		}
		
		return gcd;
	}
	
	
	/* 기능 : num단을 출력하는 메소드
	 * 매개변수 : int num1
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printMultiTable
	 * 	 */
	
	public static void printMultiTable(int num1) {
		
		for(int i = 1; i<=9; i++) {
			
			System.out.println(num1+" x " + i + " = " + (num1*i) );
		}
	}
	
	
}
