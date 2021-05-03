package day6;


public class variableEx1 {
	

		static int num = 10; //variableEx1 클래스의 멤버변수 num
	
		public static void main(String[] args) {
			/*
			 * 변수에 관하여
			 * 
			 * 지역변수 : 우리가 지금까지 사용한 일반 변수, 특정 지역에서만 사용 가능한 변수
			 *  - 지역변수는 선언된 위치부터 해당 {}안 끝까지 사용 가능
			 * 멤버변수 : 클래스안에 있는 변수로, 해당 클래스의 모든 곳에서 사용 가능하다.
			 * 
			 * 
			 *    범위 :  멤버변수 > 지역변수
			 * */
			
			int i; //i는 메인메소드에서 선언했기 떄문에 선언 위치부터 main메소드 끝까지 사용 가능하다.
			
			for(i=1; i<=5; i++) {
				System.out.print("*");
			}
			System.out.println();
			System.out.println(i);
			
			for(int k = 1; k<=5; k++) { // k는 반복문안에서 선언했기 떄문에 2줄밖에 사용 못한다.
				System.out.print("*");
			}
			//System.out.println(k); //k는 선언문 안에서 벗어나서 없는 변수로 취급한다.
			System.out.println();
			System.out.println(num); // 멤버변수이기 때문에 따로 사용이 가능한 모습이다.
			
			
			
		}
		
		public static void test() {
			
			//i = 10; //i라는 변수는 main에서까지만 선언되기때문에 없는 변수 취급한다.
			System.out.println(num); // 멤버변수이기 때문에 따로 사용이 가능하다.
		}
}
