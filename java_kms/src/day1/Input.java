package day1;

import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		int num = scan.nextInt();
		System.out.println("입력받은 값 :" + num);
		
		
		System.out.println("실수를 입력하세요 : ");
		double dnum = scan.nextDouble();
		System.out.println("입력받은 값 :" + dnum);
		
		System.out.println("문자를 입력하세요 : ");
		char ch = scan.next().charAt(0); //next()하면 문자열 읽어온다. charAt(0)은 해당 문자열 중에 첫번째 글자를 읽어온다.
		System.out.println("입력받은 값 :" + ch);
		
		System.out.println("문자를 입력하세요 : ");
		String str = scan.nextLine(); //nextLine은 공백을 포함한 문자열을 가져오기에 위에서 문자를 입력하고 엔터를 친 순간 공백을 가져오면서 입력받은 값이 공백으로 나와버린다.
		System.out.println("입력받은 값 :" + str);
		
		scan.close();

	}

}
