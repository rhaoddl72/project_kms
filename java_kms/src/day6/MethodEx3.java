package day6;



public class MethodEx3 {
	
	public static void main(String[] args) {
		
		int num1 = 10, num2 = 20;
		System.out.println(num1 +" , " + num2);
		swap(num1,num2); // swap 메소드로 가면서 num1과 num2는 새로운 변수가 추가로 만들어진다.
		System.out.println(num1 + " , " + num2); //복사된 정보가 값이냐 주소냐에 따라 원본이바뀌는데 일반변수는 값이기때문에 값이 변하지 않는다.
		
	}
	
	
	/* 기능 : 두 정수의 값을 바꾸는 메소드 
	 * 매개변수 : 두 정수 => int num1 / int num2
	 * 리턴타입 : 돌려주는 값 없음 => void
	 * 메소드명 : Swap
	 */
	
	public static void swap(int num1, int num2) {
		int tmp = num1;
		num1 = num2;
		num2 = tmp;
	}

}
