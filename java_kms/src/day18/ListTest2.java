package day18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;



public class ListTest2 {
	
	public static void main(String[] args) {
		/*오늘의 할일을 저장하는 리스트를 생성한 후 오늘의 할일을 입력 받고, 다 받은 후에 출력하는 코드를 작성
		 * 오늘의 할일은 종료를 입력하면 종료하고 출력하면 된다.
		 * 예시 >
		 * 오늘의 할일 입력 : 출근
		 * 오늘의 할일 입력 : 오전수업
		 * 오늘의 할일 입력 : 점심
		 * 오늘의 할일 입력 : 오후수업
		 * 오늘의 할일 입력 : 퇴근
		 * 오늘의 할일 입력 : 종료
		 * 
		 * 오늘의 할일
		 * 1. 출근
		 * 2. 오전수업
		 * 3. 점심
		 * 4. 오후수업
		 * 5. 퇴근
		 * */
		
		//리스트 생성
		ArrayList<String> List = new ArrayList<String>();
		int num = 0;
		
		//오늘의 할일을 입력받아야함
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("오늘의 할일 입력 : ");
			String str = sc.next();
			if(str.equals("종료")) {
				break;
			}
			List.add(str);
		}
		
		
		for(int i = 0; i<List.size(); i++) {
			System.out.println(i+1 + "." + List.get(i));
		}
		
		sc.close();
	
	}

}
