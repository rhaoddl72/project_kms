package day8;

public class Test8_4 {

	public static void main(String[] args) {
		/* 
		 * 다음과 같이 되도록 코드를 작성하세요.
		 * 1 2 3 4
		 * 5 6 7 8
		 * 9 10
		 * */
		
		
		
		System.out.println("\n========================================");
		for(int i= 1; i<=10; i++) {
			
			System.out.print(i + " ");
			if(i%4==0) {
				System.out.println();
			}
			
		}
		
		
		/* 
		 * 다음과 같이 되도록 코드를 작성하세요.
		 * 1,2,3,4
		 * 5,6,7,8
		 * 9,10,11,12
		 * */
		System.out.println("\n========================================");
		for(int i= 1; i<=12; i++) {
			
			System.out.print(i);
			if(i%4==0) {
				System.out.println();
			}
			else if(i%4!=0) {
				
				System.out.print(",");
			}
			/*String str = i%4 == 0? "\n" : ",";
			System.out.print(str); 이런방법도 있다. */
		}
		
		
		
		
		
		/* 
		 
		 * 다음과 같이 되도록 코드를 작성하세요.
		 * 2 1 4 3
		 * 6 5 8 7
		 * 10 9 12 11
		 * 
		 * 1 2 3 4 => 짝수는 -1 홀수는 +1이 되었다.  1+1 2-1 3+1 4-1
		 * */
		System.out.println("\n========================================");
		
		for(int i= 1; i<=12; i++) {
			
			
			if(i%2==0) {
				System.out.print(i-1 + " ");
			}
			else if(i%2==1) {
				
				System.out.print(i+1 + " ");
			}
			
			if(i%4 == 0) {
				System.out.println();
			}
			
		}
		
	}
}
