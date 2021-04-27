package day2;

public class CompareOperator {
	
	public static void main(String[] args) {
		
		//비교 연산자 예제
		System.out.println("1 > 2 : " + (1>2) );
		System.out.println("1 >= 2 : " + (1>=2) );
		System.out.println("1 < 2 : " + (1<2) );
		System.out.println("1 <= 2 : " + (1<=2) );
		System.out.println("1 == 2 : " + (1==2) );
		System.out.println("1 != 2 : " + (1!=2) );
		
		
		//4는짝수인가?
		System.out.println("4는 짝수인가? "  + (4%2==0));
		
		
		System.out.println(0.1==0.1f);
		System.out.println('A'==65);
	}

}
