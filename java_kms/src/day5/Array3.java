package day5;

public class Array3 {
	
	public static void main(String[] args) {
		/* 정수 num의 약수를 배열에 저장한 후 출력하는 코드를 작성하세요
		 * 단 약수의 개수가 10개를 넘어가는 경우 최대 10개만 출력*/
		
		int num = 12;
		int cnt = 0;
		int[] arr = new int[10];
		
		for(int i = 1; i<=num; i++) {
			
			
			 if(num%i==0) {
				arr[cnt] = i;
				cnt += 1;
			}
			 if(cnt==10) {
				break;
			}
			
		}
		
		for(int i = 0; i<cnt; i++) {
			System.out.print(arr[i] + " ");
		}
				
		
			
		
	}

}
