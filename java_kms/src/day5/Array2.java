package day5;

public class Array2 {
	
	public static void main(String[] args) {
		
		//5개짜리 정수 배열에 1부터 5까지 차례대로 저장 후 출력
		
		
		int[] arr = new int[5];
		
		for(int i = 0; i<5; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
		}

		System.out.println();
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		System.out.print(arr[0]+" ");
		System.out.print(arr[1]+" ");
		System.out.print(arr[2]+" ");
		System.out.print(arr[3]+" ");
		System.out.print(arr[4]+" ");

	}

}
