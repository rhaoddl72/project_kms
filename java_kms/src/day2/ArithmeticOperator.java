package day2;



public class ArithmeticOperator {
	
	 public static void main(String[] args) {
		
		 // 산술 연산자 예제
		 
		 System.out.println("1 / 2 = "+1/2);
		 System.out.println("1.0 / 2 = "+1.0/2);
		 System.out.println("1 / 2.0 = "+1/2.0);
		 System.out.println("1.0 / 2.0 = "+1.0/2.0);
		 
		 int num1=1, num2=2;
		 
		 System.out.println(num1/(double)num2);
		 System.out.println("7 % 4  = "+ 7 % 4);
		 
		 char ch  = 'A';
		 ch = (char)(ch+1);
		 
		 char ch1  = 65;  //char + int를 하면 int가 된다. 그런데  int는 4바이트이고 char는 2바이트이므로 자동 타입변환이 안된다. 그래서 강제 타입변환 필요
                          //타입은 크기가 큰 타입을 따라가게 된다.
		 ch = (char)(ch+1);
		 
		 
		 System.out.println(ch);
	}

}
