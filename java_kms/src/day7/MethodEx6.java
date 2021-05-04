package day7;

public class MethodEx6 {
	
	
	
	
	public static void main(String[] args) {
		
		printTriangle('+',5,TriangleShape.LEFT_TRIANGLE);
		printTriangle('+',5,TriangleShape.RIGHT_TRIANGLE);
		
		
	}
	
	/*
	 * 다음과 같이 출력하는 메소드를 만드세요.
	 * *
	 * **
	 * ***
	 * ****
	 * *****
	 * 
	 * 다음과 같이 출력하는 메소드를 만드세요.
	 *       *
	 *      **
	 *     ***
	 *    ****
	 *   *****     
	 *  */
	
	public static void printLeftTriangle(char ch, int num) {
		
		
		
		for(int i=1; i<=num; i++) {
			
			String ss = "";
			
			for(int j=1; j<=i; j++ ) {
				
				System.out.print(ch);
				
				
			}
			System.out.println();
		}
		
	}
	
	
	public static void printRightTriangle(char ch, int num) {
		
		
		
		for(int i=1; i<=num; i++) {
			
			String ss = "";
			
			for(int k=1; k<=num-i; k++) { // 증감식 -- 하지말고 이런식으로 해야함
				System.out.print(" ");
			}
			
			for(int j=1; j<=i; j++ ) {
				System.out.print(ch);
				
			}
			System.out.println();
		}
		
	}
	
	
	/* 기능 : 주어진 문자(ch)를 이용하여 n줄 삼각형 출력하는데 주어진 삼각형 종류에 맞게 출력하는 메소드(하나의 메소드로 2개담기)
	 * 매개변수 :  문자, n줄, 삼각형 종류 => char ch, int n, ?? <- ??는 enum사용해서 할것(TriangleShape shape)
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printTriangle
	 */
	
	public static void printTriangle(char ch, int num, TriangleShape shape) {
		
		switch(shape) {
		case LEFT_TRIANGLE:
			printLeftTriangle(ch,num);
			break;
			
		case RIGHT_TRIANGLE:
			printRightTriangle(ch,num);
			break;	
		}
	}
	
	
	

}

enum TriangleShape{LEFT_TRIANGLE, RIGHT_TRIANGLE} //열거형으로 의미 정확히 전달

