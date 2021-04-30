package day5;

import java.util.Scanner;

public class Test5_3 {

	
	public static void main(String[] args) {
		
		/* 
		 * 콘솔에서 정수를 5번 입력받아 값을 출력하는 코드 작성
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		
		for( int i=0; i<5; i++) {
			
			System.out.println("입력 : ");
			int num1 = sc.nextInt();
			System.out.println("출력 : " + num1);
		}
		
		/*
		 * 콘솔에서 정수를 5번 입력받아 저장한 후 저장된 값을 출력하는 코드 작성
		 * */
		
		int[] arr = new int[5];
		
		for( int i=0; i<arr.length; i++) {
			
			System.out.println("입력 : ");
			 arr[i] = sc.nextInt();
			System.out.println("출력 : " + arr[i]);
		}
	}
}

