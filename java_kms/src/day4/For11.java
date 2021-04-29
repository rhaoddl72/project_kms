package day4;

public class For11 {
	
	public static void main(String[] args) {
		
	//두 정수의 최소 공배수를 구하는 코드 작성
	// 8의 배수 : 8, 16 ,24 ,32.....
	// 12의 배수 : 12, 24, 36, 48.....
	// 8과 12의 공배수 : 24, 48, 72 ....
	// 8과 12의 최소공배수 : 24
	// 정수가 8과 12이면 두 수의 곱인 96이 두 정수의 최소공배수가 나올 수 있는 범위이다.

		int num = 8;
		int num1 = 12;
	
	for(int i = 1; i<= num * num1; i++) { 
		
		if(i%num==0 && i%num1==0) {
			
			System.out.println("최소 공배수 : " + i);
			break;
		}
		
	}
	
	// 위와 똑같지만 좀 더 효율적으로 동작 시행
	// 반복 횟수 : i는 num부터 무한대로 i는 num씩 증가
	// 규칙성 : i가 num1의 배수이면 i를 출력한 후 반복문 종료
	
	for(int i = num; ; i += num) { 
		
		if(i%num1==0) {
			
			System.out.println("최소 공배수 : " + i);
			break;
		}
		
	}
	}
}
