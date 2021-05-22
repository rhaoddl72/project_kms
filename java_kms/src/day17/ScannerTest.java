package day17;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		/* next() : 공백(엔터,스페이스)을 만나기전까지 문자열을 가져오는 메소드
		 * nextLine() : 처음 만나는 엔터전까지(한줄씩) 문자열을 가져오는 메소드*/
		
		
		/*Scanner sc = new Scanner("1234 1234\n4567\n8910\n++++\n");
		String str = sc.next();
		String str =sc.nextLine(); //1234 1234를 추출
		System.out.println(str);
		System.out.println("---------");
		str = sc.nextLine(); //4567을 추출
		System.out.println(str);
		System.out.println("--------");
		int num = sc.nextInt(); // 8910을 추출
		System.out.println(num);
		System.out.println("--------");
		str = sc.nextLine(); // ++++를 추출하는게 아니라 \n을 추출해준다. nextInt가 8910만가져가고 \n은 안가져갔기 때문에
		System.out.println(str);
		System.out.println("--------");*/
		
		
		Scanner sc = new Scanner("1234 1234\n\n\n4567\n8910\n++++\n");
		//hasNext() : 다음 요소가 있는지 없는지 확인해서 있으면 가져오는 메소드
		while(sc.hasNext()) {
			String str = sc.nextLine();
			if(str.length() != 0) {
			System.out.println(str);
			}
		}
		
		
		sc.close();
	}
}
