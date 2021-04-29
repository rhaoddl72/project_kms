package day4;



public class Test4_1 {
	
	public static void main(String[] args) {
		
		// 11부터 20까지 출력하는 코드 작성
		
		for(int i = 11; i <= 20; i++) {
			
			System.out.print(i + " ");
		}
		
		
		// 20부터 11까지 출력하는 코드 작성
		
		for(int i = 20; i>=11; i--) {
			
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		
		// 1부터 100까지 숫자 중 일의 자리가 3,6,9로 끝나는 수들을 출력하는 코드 작성
		// int k; 출력 개수 넣어줄 변수 3개씩 끊어서 출력하게 해준다.
		
		for(int i = 1, k = 0; i<=100; i++) { // k보면 저런식으로 for문에서 변수 새로 만들어주면서 초기화도 시켜줄 수 있다.
			
			
			
			if(i%10==3 || i%10==6 || i%10==9) {
				
				
				
				System.out.print(i + " ");
				
				k+=1;
				if(k%3==0) {
					System.out.println();
				}
				
			}
			
			
		}
	}

}
