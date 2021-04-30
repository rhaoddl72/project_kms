package day5;

public class Test5_5 {

	public static void main(String[] args) {
		/*
		 * 1부터 10사이의 랜덤한 수를 6개 생성해서 배열에 저장한 후 출력하는 코드 작성
		 * */
		
		int[] num = new int[6];
		
		int max = 10;
		int min = 1;		
		
		
		for(int i = 0;i<num.length;i++) {
			
			int ran = (int)(Math.random()*(max-min+1)+min);
			num[i] = ran;
			System.out.print(num[i] + " ");
			
		}
		
	}
}
