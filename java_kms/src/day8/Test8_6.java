package day8;

public class Test8_6 {

	public static void main(String[] args) {
		/*
		 * 5개짜리 배열에 같은 숫자가 2개 있는지 없는지 판별하는 코드를 작성
		 * 단, 숫자는 정렬되어 있다 가정한다. 카드게임 스페어 처리 가능
		 * 예시 : 1 1 2 3 4
		 * 있음
		 * 예시 : 1 2 3 4 5
		 * 없음
		 * 예시 : 1 1 2 2 4
		 * 있음
		 * 예시 : 1 1 1 2 3
		 * 없음
		 * 예시 : 1 1 1 2 2
		 * 있는데 없다고 나옴
		 * 
		 * 
		 * i번지의 값과 i+1번지의 값이 같으면 cnt를 1증가
		 * 다르면 
		 * cnt의 값이 2와 같으면 res를 ture로 수정
		 * cnt를 1로 초기화
		 * 반복문 종료 후
		 * cnt가 2와 같으면 res를 true로 수정
		 * res가 true이면 있음이라고 출력
		 * false이면 없음이라고 출력
		 * */
		
		int[] arr = new int[] {1,1,3,2,2};
		int cnt = 1;
		boolean res = false;
		
		for(int i=0; i<arr.length-1; i++) {
			
			if(arr[i] == arr[i+1]) {
				cnt+=1;
			}else{
				if(cnt == 2) {
					res = true;	
				}
				cnt = 1;
			}
			
			
		}
			if(cnt == 2) {
				res = true;
			}
			if(res == true) {
				System.out.println("있음");
			}
			else {
				System.out.println("없음");
			}
		
	}
}
