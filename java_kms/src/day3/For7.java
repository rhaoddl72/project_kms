package day3;

public class For7 {

	public static void main(String[] args) {
				// 두 정수의 최대 공약수를 구하는 코드 작성
				// 약수 : 값을 나누어서 0으로 딱 떨어지는 수 
				// ex : 6의 약수 : 1,2,3,6   // 6을 1하고 2하고 3으로 나누면 0으로 떨어짐
				// 공약수 : 공통으로 있는 약수 
				// ex : 8의 약수: 1, 2, 4, 8  12의 약수: 1,2,3,4,6,12  둘의 공약수는 1,2,4
				// 최대 공약수 : 공약수 중 가장 큰 수
				// 8과 12의 최대 공약수 : 4
		
		int num = 8;
		int num2 = 12;
		int gcd =  0;
		
		for(int i=1; i<=num; i++) {
			if(num%i==0 && num2%i==0) {
				gcd=i; // gcd라는 변수에 i를 집어 넣으면 작은수 부터 구해져서 gcd에 들어가게 된다. 그럼 작은수는 큰수에 덮어지면서 결국은 가장 큰수가 들어온다.
				
			}
			
		}
		System.out.println(num +  "과 " + num2 + "의 최대 공약수는 " + gcd);
	}
}
