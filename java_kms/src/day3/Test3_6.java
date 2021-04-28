package day3;

public class Test3_6 {
	
	public static void main(String[] args) {
		// 1부터 10까지의 짝수들의 합을 구하기
		
		int sum=0;
		
		
		for(int i = 1; i<=10; i++) {
			if(i%2==0) {
				
				sum+=i;
			}
			
		}
		
		System.out.println("1부터 10까지 짝수의 합 : " + sum);
	}

}
