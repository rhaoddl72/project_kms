package day6;

public class MethodEx2 {

	
	public static void main(String[] args) {
		
		/* 기능 : 정수 배열에 있는 모든 원소값을 출력하는 메소드 
		 * 매개변수 : 정수 배열 = > int[] arr / int arr[]
		 * 리턴타입 : 출력이니까 void
		 * 메소드명 : printArray
		 */
		int arr[] = new int[] {4,5,6,7,8};
		int num = 0;
		
		initArray(arr, 0);
		printArray(arr);
		
		
		
		
	}
		public static void printArray(int[] arr) {
			/*
			 * 향상된 for문
			 * 배열이나 컬렉션프레임워크
			 * 전체를 탐색
			 * 수정이 아닌 경우 */
			for(int i : arr) {
				
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		/* 기능 : 배열에 지정된 정수로 모두 초기화하는 메소드 
		 * 매개변수 : 정수 배열 => int[] arr / int arr[]
		 * 리턴타입 : 알려준 배열에 수정을 하니까 돌려주는 값 없음 => void
		 * 메소드명 : initArray
		 */
		
		public static void initArray(int[] arr, int num) {
			if(arr == null) {
				
				return;
				
			}
			for(int i = 0; i<arr.length; i++) {
				
				arr[i] = num;
			}
			
		}
		
		
		
	
}
