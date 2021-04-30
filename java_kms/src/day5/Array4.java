package day5;

public class Array4 {
	
	public static void main(String[] args) {
		/*
		 * 1~10 사이의 정수 3개를 랜덤으로 생성하여 배열에 저장한 후
		 * 생성된 값들이 중복되었는지 안되었는지 확인하는 코드
		 * 예시 :
		 * 랜덤 : 3 8 2
		 * 중복되지 않음
		 * 예시 : 2 8 8
		 * 중
		 * 
		 * ex) 3개면 0 1 2
		 *      01 02
		 *      12
		 *      
		 * ex) 5개면 0 1 2 3 4
		 *          01 02 03 04
		 *          12 13 14
		 *          23 24
		 *          34
		 *  위 예시와 같이 3개면 가로 2줄 세로 2줄 5개면 가로 4줄 세로 4줄이 나오는걸 알 수 있다.
		 *  그러면 배열.length에서 -1해주면 된다는 걸 알 수 있다.
		 *  
		 *  그리고 보면 01 02 12 처럼 왼쪽에서 +1한 숫자가 오른쪽이 된다. k=i+1(아래코드참조)
		 *  
		 *
		 * 
		 * */
		
		int min = 1;
		int max = 10;
		int[] arr = new int[3];
		
		System.out.print("랜덤 : ");
		for(int i=0; i<arr.length; i++) {
			int ran = (int)(Math.random()*(max-min+1)+min);
			arr[i] = ran;
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		boolean b = false; // 빠져나가기 위한 논리문 for문의 if문(arr[i]==arr[k])에서 조건을 만족했을 때 b가 true이므로 for문을 빠져나와 if(b)로 이동한다.
		for(int i = 0; i<arr.length-1; i++) {
			for(int k = i+1; k<arr.length; k++) {
				if(arr[i]==arr[k]) {
					
					b = true;
					
				}
			}
			
		}
		if(b) {
			System.out.println("중복");
		}
		else {
			System.out.println("중복 아님");
		}
		
		
		/*System.out.println();
		if(arr[0]==arr[1] || arr[0]==arr[2] || arr[1]==arr[2]) {
			System.out.println("중복");
		}else {
			System.out.println("중복되지 않음");
		}*/
		
		
		/*
		for(int i = 0; i<5-1; i++) { //위에 코드 숫자로 해서 표현
			for(int j = i + 1; j<5;j++) {
				System.out.print(" " + i+ j+ " ");
			}
			System.out.println();
		}*/
		
	}

}
