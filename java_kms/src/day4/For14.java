package day4;

public class For14 {
	
	public static void main(String[] args) {
		/*
		 * 정수 num가 소수인지 아닌지 판별하는 코드 작성
		 * 소수 : 약수가 2개인 수(1과 자기 자신으로 이루어진 수)
		 * 소수 : 2 3 5 7 11 13 17 ...
		 * */
		
		int num = 20;
		int cnt = 0;
		
		for(int i=1;i<=num;i++) {
			
			if(num%i==0) {
				
				cnt+=1;
			}
			
			
		}
		if(cnt==2)
		System.out.println("소수");
		else {
			System.out.println("소수아님");
		}
		
	}

}
