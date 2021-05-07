package day9;

public class Sce {

	public static void main(String[] args) {
		
				//SCE
				//논리 연산자에서 판별할 때 왼쪽에 있는 값에 따라 오른쪽이 실행되지 않을 수 있다.
				//&& : 하나라도 거짓이면 거짓, 왼쪽이 거짓이면 오른쪽은 뭐가 됐든 거짓이기때문에 오른쪽이 실행되지 않는다.
				//|| : 하나라도 참이면 참, 왼쪽이 참이면 오른쪽을 확인하지 않아도 참이기 때문에 오른쪽이 실행되지 않는다.
				
				int arr3[] = null;
		
				if(arr3 != null && arr3.length == 2) { // 오른쪽 조건은 당연히 오류가 나야하는데 왼쪽이 거짓으로 돼서 오른쪽은 확인x
					System.out.println("12");
				}
		
	}
}
