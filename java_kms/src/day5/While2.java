package day5;

public class While2 {
	
	public static void main(String[] args) {
		// while문과 continue를 이용한 짝수 예제
		
		int i = 1,num = 10;
		
		
		while(i <= num) {
			
			if(i % 2 != 0) {
				
				i++;
				continue;
				
			}
			System.out.print(i + " ");
			i++; //짝수여도 증감식이 있어야하니까 이쪽에도 증감식을 넣어줘야 한다.
			
		}
		
		System.out.println();
		// 위와 같은 결과 출력 조건에서 ++i를 줌으로써 조건식으로 들어올 때 마다 값이 1씩 증가
		i = 0;
		while(++i <= num) {
			
			if(i % 2 != 0) {
				
				
				continue;
				
			}
			System.out.print(i + " ");
			
			
		}
	}

}
