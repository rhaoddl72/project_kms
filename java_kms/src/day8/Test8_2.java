package day8;

public class Test8_2 {

	public static void main(String[] args) {
		/*
		 * 다음과 같이 출력되도록 작성하세요.
		 * a
		 * ab
		 * abc
		 * abcd
		 * abcde
		 * ....
		 * abcdefg...xyz
		 * */
		
		for(char i = 'a'; i<='z'; i++) {
			for(char j = 'a'; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		
		String str = "";
		for(char i = 'a'; i<='z'; i++) {
			str += i;
			System.out.println(str);
		}
	}
}
