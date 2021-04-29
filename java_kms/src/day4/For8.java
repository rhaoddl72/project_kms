package day4;

public class For8 {

	public static void main(String[] args) {
		
		/*
		char ch = 'a';
		
		System.out.println(ch);
		
		ch = 'a'+1;
		System.out.println(ch);
		
		ch = 'a'+2;
		System.out.println(ch);
		*/
		
		// a부터 z까지 출력하는 코드 작성
	
		for(int i = 0, ch = 'a'; i<26; i++) {
			
			System.out.print((char)(ch+i)  + " ");
			
		}
		
		System.out.println();
		
		for(char ch = 'a'; ch <= 'z'; ch++) { //for문 char형도 가능
			
			System.out.print(ch + " ");
			
		}
		
	}
}
