package day7;

public class MethodEx5 {
	
	public static void main(String[] args) {
		// *****을 출력하도록 메소드를 생성 테스트
		
		
		
		printChar1('*',5);
		
		printChar2('/',6);
		
		System.out.println(printChar3('*',3) + printChar3('-',2));
		
	}
	
	
	/* 기능 : 주어진 문자(ch)를 주어진 정수번(count) 반복하여 출력하는 메소드
	 * 매개변수 : 문자, 정수번(횟수) => char ch, int count 
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printChar1
	 */
	
	public static void printChar1(char ch, int num) {
		
		String ss = "";
		
		for(int i=1; i<=num; i++) {
			
			ss+=ch;
			
		}
		System.out.println(ss);
	}
	
	
	public static void printChar2(char ch, int count) {
	
		for(int i = 0; i<count; i++) {
			System.out.print(ch);
			
		}
		System.out.println();

	}
	
	public static String printChar3(char ch, int count) {
		String ss = "";
		
		for(int i = 0; i<count; i++) {
			/*
			 * i = 0  ""+'*' => "*"
			 * i = 1  "*" + '*' => "**"
			 * i = count-1 "**...**" + '*' ==> "**....**" count개 만큼 생성
			 *  */
			ss+=ch;
			
		}
		return ss;
	}
}
