package day5;

public class AdvanceFor {
	
	public static void main(String[] args) {
		/*
		 * 향상된 for문 예제
		 * 배열이나 컬렉션프레임워크에서 사용 가능한 for 문
		 * 전체 탐색할 때 사용
		 * 값을 가져올 때 사용
		 * 값을 변경할 때 사용하지 않음
		 * for(타입 변수:배열명){
		 *       실행문;
		 * }*/
		
		
		int[] arr = {1, 2, 3, 4, 5};
		
		
		for(int tmp : arr) { //arr배열의 값이 tmp로 순서대로 들어간다.
			                 //하나씩 다 확인하므로 전체탐색이나 값을 확인할때 사용한다.
			System.out.print(tmp + " ");
		}
	}

}
