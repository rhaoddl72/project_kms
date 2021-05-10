package day10;

public class Sort {

	public static void main(String[] args) {
		/* 
		 * 배열 정렬 : 버블 정렬
		 * - 옆에 요소와 비교하여 정렬하는 방법
		 *  5 4 6 9 8 7 10 [0,1]
		 *  4 5 6 9 8 7 10 [1,2]
		 *  4 5 6 8 9 7 10 [2,3]
		 *  4 5 6 9 8 7 10 [3,4]
		 *  4 5 6 8 9 7 10 [4,5]
		 *  4 5 6 8 7 9 10 [5,6]
		 *  4 5 6 8 7 9 10 => 10이 확정
		 *  4 5 6 8 7 9 10 [0,1]
		 *  4 5 6 8 7 9 10 [1,2]
		 *  4 5 6 8 7 9 10 [2,3]
		 *  4 5 6 8 7 9 10 [3,4]
		 *  4 5 6 7 8 9 10 [4,5]
		 *  4 5 6 7 8 9 10 => 9가 확정 //버블정렬은 정렬이 완료됐더라도 숫자를 하나 하나 비교해서한다.
		 *  
		 *  작은 반복문 횟수
		 *  6 => 5 => 4 => 3 => 2 => 1
		 *  
		 *  큰 반복문 횟수의 i
		 *  0 => 1 => 2 => 3 => 4 => 5
		 *  
		 *  6 - i == 작은 반복문 횟수 == arr.length-1 - i
		 * */
		
		int[] arr = new int[] {5,4,6,9,8,7,10};
		printArrary(arr);
		System.out.println();
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1 - i; j++ ) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
				printArrary(arr);
				System.out.println();
			}
		}
		printArrary(arr);
		
	}
	
	public static void printArrary(int[] arr) {
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
