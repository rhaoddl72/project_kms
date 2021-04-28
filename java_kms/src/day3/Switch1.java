package day3;

public class Switch1 {

	public static void main(String[] args) {
		
		//Switch 문을 이용한 홀짝 판별
		
		int num = 4;
		
		switch(num % 2) {
		case 1 :
			System.out.println("홀수");
			break;
		case 0 :
			System.out.println("짝수");
			break;
		
		
		}
	}
}
