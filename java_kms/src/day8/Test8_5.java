package day8;

import java.util.Scanner;

public class Test8_5 {

	public static void main(String[] args) {
		/*
		 * 10개짜리 배열에 1부터 10를 저장한 후 출력하는 코드를 작성
		 */
		
		/*
		int[] arr = new int[10];
		
		
		
		for(int i = 0; i<arr.length; i++ ) {
			
			arr[i]=i+1;
			
			System.out.print(arr[i] + " ");
			
		}*/
		
		
		
		
		//피보나치 수열 나타내기
		
		/*int[] arr2 = new int[10];
		
		arr2[0] = 1;
		arr2[1] = 1;
		
		//피보나치 수열 값을 배열에 저장
		for(int i = 2; i<arr2.length; i++ ) {  //배열범위 넘었다는 에러 피하기위해 i를 2로
		
			arr2[i] = arr2[i-2] + arr2[i-1];
		
		}
			
			
			
		//배열의 값을 출력
		for(int tmp : arr2) {
			
			System.out.print(tmp + " ");
			
		}*/
		
		
		
		/*
		 * 5개짜리 배열에 저장된 숫자들중 연속된 숫자가 3개인지 아닌지를 확인하는 코드 작성
		 * 단, 숫자들은 정렬되었다고 가정
		 * 예시 
		 * 입력 : 1 1 2 3 4
		 * 연속
		 * 예시
		 * 입력 : 1 2 4 5 8 //연속된 숫자가 3개이상부터임
		 * 연속 아님
		 * 예시 : 1 3 5 6 7
		 * 연속
		 */
		
		Scanner sc = new Scanner(System.in);
		int cnt = 1;
		int[] arr3 = new int[] {1,2,4,5,8};  //
		
		
		for(int i=0; i<arr3.length-1; i++) { //i는 0번지부터 3번지까지만 비교 그래서 length-1
			//i번지의 값과 i+1번지의 값의 차이가 1이면 count를 1 증가
			if(arr3[i] + 1 == arr3[i+1]) { //arr3[i+1] - arr3[i] == 1
				cnt+=1;
			}
			else if(arr3[i+1] - arr3[i] != 1){ //아니면 cnt를 1로 초기화
				cnt = 1;
			}
			
			if(cnt == 3) {
				break;
			}
			
		}
			//count가 3이면 연속이라고 출력
			if(cnt == 3) {
				System.out.println("연속");
			}else { //아니면 연속아님이라 출력
				System.out.println("연속아님");
			}
		
		
		
			
		
		
		
		
}
}
