package day4;

public class Continue {
	
	public static void main(String[] args) {
		// for문에서는 증감식의 위치로 이동하고 while문에서는 조건식으로 이동한다.
		// break,continue는 if문과 같이 쓰인다.
		
		int i;
		for(i = 1; i <= 5; i++) {
			
			if(i == 2) {
				continue;
			}
			System.out.println(i);
		}
		
		
		for(i = 1; i <= 5; i++) {
			
			if(i != 2) {
				
				System.out.println(i);
			}
		}
	}

}
