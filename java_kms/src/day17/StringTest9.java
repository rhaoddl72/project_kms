package day17;

import java.util.Scanner;



public class StringTest9 {

	public static void main(String[] args) {
		/*공백을 포함한 긴 문자열을 입력한 후 단어를 입력받아 해당 단어가 몇번 나오는지 확인하는 코드
		 * 예시 >
		 * 문장 입력 : Hello. Hi. HHHH. He. His
		 * 단어 입력 : H
		 * 횟수 : 8번
		 * 
		 * 문장 입력 : Hello. Hi. HHHH. He. His
		 * 단어 입력 : Hi
		 * 횟수 : 2번
		 * */
		
		//공백을 포함한 긴 문자열 => nextLine
		//단어가 몇번나오는지 => String
		//.마다 나뉘게 split
		//나눈거에서 같은 문자열이 몇개인지 indexOf?
		//
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문장 입력 : ");
		String str = sc.nextLine();

		System.out.println("단어 입력 : ");
		String ch = sc.next();
	
		
		//반복문을 통해 해당 단어가 몇번 있는지 체크(indexOf()를 이용하여)
		/*int num = str.indexOf(ch);
		System.out.print(num); */
		int count = 0;//단어의 개수
		int index = 0;//해당 단어가 있는 시작 번지
		while(true) {
			//문장에 해당 단어가 있는 위치를 찾음
			index = str.indexOf(ch);
			if(index == -1) {
				break;
			}
			count++;
			str = str.substring(index+1);
		}
		System.out.println(count + "번");
		
	}
}
