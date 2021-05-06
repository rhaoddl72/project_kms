package day8;

import java.util.Scanner;



public class Test8_1 {

	/*
	 * 1~9사이의 정수를 입력받아 각 숫자가 몇번 입력됐는지 
	 * 
	 * -1이 입력되면 입력 종료하고 각 숫자가 몇번 입력됐는지 출력
	 * 예시
	 * 입력 : 1
	 * 입력 : 1
	 * 입력 : 9
	 * 입력 : 3
	 * 입력 : 2
	 * 입력 : -1
	 * 1 : 2번
	 * 2 : 1번
	 * 3 : 1번
	 * 4 : 0번
	 * 5 : 0번
	 * 6 : 0번
	 * 7 : 0번
	 * 8 : 0번
	 * 9 : 1번
	 * */
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	//반복문 이용하여 정수를 입력받음
	int num = 0;
	
	int[] arr = new int[10];
	
	
	System.out.println("1-9까지의 숫자를 입력해 주세요. : ");
	while(true) { //범위를 주지 않을거면 for문 말고 while문 활용!!!!!!
		num = sc.nextInt();
		if(num < 1 ||  num > 9) {
			
			break;
		}
		arr[num] += 1;
		
		
	}
	
	for(int i = 1; i<arr.length; i++) {
		System.out.println(i + " : " + arr[i] + "번");
	}
	
	sc.close();
	
}
}
