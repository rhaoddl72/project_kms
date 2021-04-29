package day4;



public class For13 {
	
	public static void main(String[] args) {
		/*
		 * 구구단 전체를 출력하는 2중 for 코드
		 * */
		
		
		for(int i = 2; i<=9; i++) {
			for(int j = 1,k = 0; j<=9; j++) {
				
				
				
				System.out.println(i+" * "+j+" = "+(i*j));
				
				k+=1;
				
				if(k==9) {
					System.out.println("-----------------");
				}
			}
		}
		
	}

}
