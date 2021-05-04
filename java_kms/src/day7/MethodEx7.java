package day7;

import java.awt.print.Printable;
import java.util.Arrays;
import java.util.Random;

public class MethodEx7 {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5};
		
		int num = 3;
		
		//System.out.println(contains(arr,num,2)); //2개로 count하면 3이있음에도 false로 뜬다.
		
		
		int min = 1;
		
		int max = 9;
		 
		int[] arr1 = {10, 30, 60, 80, 20};
		
		//initRandomArray(arr1, min, max);
		
		arr1 = initRandomArray(arr1, 1, 9);
		for(int tmp : arr1) {
			
			System.out.print(tmp + " ");
			
		}
		System.out.println();
		
		
	}
	
	
	/* 기능 : 배열이 주어지고, 주어진 배열에 0번지 부터 count개 까지 확인하여 정수 num이 있는지 없는지 확인하는 메소드
	 * 매개변수 : int arr[] , int num 
	 * 			확인 할 개수 => int count
	 * 리턴타입 : boolean
	 * 메소드명 : contains
	 */
	
	public static boolean contains(int[] arr, int num, int count) {
		
		
		
		for(int i=0; i<count; i++) {
			//배열의 개수보다 count가 큰 경우 예외처리
			if(arr.length<count) {
				 count = arr.length; //카운트가 클 경우 count를 배열의 크기로 변경
			}
			
			if(arr[i] == num) {
			
				return true;
			}
			 
		}
		return false;
		
	}
	
	
	
	
	/* 기능 : 배열에 랜덤한 수를 생성하여 저장하는 메소드
	 * 매개변수 :	배열값 int[] arr
	 * 			랜덤 최소값 : int min
	 * 			랜덤 최대값 : int max		
	 * 리턴타입 : int[] 배열
	 * 메소드명 : initRandomArray
	 */
	
	public static int[] initRandomArray(int[] arr1,int min, int max) {
		//예외 처리1 :  배열이 없는 경우
		if(arr1 == null) {
			System.out.println("값이 없습니다."); //void로해서 아래에 return문 없어지면 여기에 return적기
		}
		//예외 처리2 : min과 max가 바뀐 경우
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		
		 //배열에 랜덤으로 수를 생성하여 저장 + 중복제거
		
		for(int i=0; i<arr1.length; i++) {
		   int r = (int)(Math.random()*(max-min+1)+min);
		   
		   arr1[i] = r;
		   
			
		}
		return arr1; //참조변수라 값이 바뀌므로 굳이 return없이 void로해도 위에 배열값은 변경된다. 일반변수는 무조건 return해서 값넘겨주는게 필요
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void initRandomArray2(int size, int min, int max) {
		
		int[] arr = new int[size];
		
		//예외 처리2 : min과 max가 바뀐 경우
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		//예외 처리3 : 랜덤 범위의 갯수가 배열의 크기보다 작은 경우
		if(max - min +1 < arr.length) {
			return;
		}
		
		// 배열에 랜덤으로 수를 생성하여 저장 + 중복제거 
		int cnt = 0; //배열에 저장된 수의 개수
		
		while(cnt < arr.length) {
			int r = (int)(Math.random()*(max-min+1)+min);
			
			//중복 체크 후 중복되지 않으면 저장
			if(!contains(arr,r,cnt)) {
				
				arr[cnt] = r;
				cnt++;
			}
		}
	
		
	}
	

}
