package day15;

public class ArraryIndexOutOfBoundsExceptionTest {

	public static void main(String[] args) {
		int [] arr = new int[5];
		//5개짜리 배열은 0번지부터 4번지까지 접근할 수 있는데 5번지에 접근하려해서 에러 발생
		for(int i = -1; i<arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}
}
