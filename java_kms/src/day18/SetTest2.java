package day18;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetTest2 {
	
	public static void main(String[] args) {
		/*
		 * 중복되지 않는 5개의 수가 입력될때까지 입력한 후, 입력이 완료되면 종료하는 코드를 작성하세요.
		 * 예시)
		 * 정수를 입력하세요 : 1
		 * 정수를 입력하세요 : 2
		 * 정수를 입력하세요 : 3
		 * 정수를 입력하세요 : 4
		 * 정수를 입력하세요 : 1
		 * 정수를 입력하세요 : 2
		 * 정수를 입력하세요 : 3
		 * 정수를 입력하세요 : 5
		 * 입력된 정수 : 1 2 3 4 5 (출력은 순서에 상관 없이)
		 * */
		
		// 중복되지 않는 값만 넣어줄 set 생성
		HashSet<Integer> set = new HashSet<Integer>();
		
		// 숫자 입력
		Scanner sc = new Scanner(System.in);
		
		//값이 들어간다.
		
		while(set.size()<5) {
			
			System.out.println("정수를 입력하세요 : ");
			
			
			set.add(sc.nextInt());
		}
		
		//출력
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			
			//Integer tmp = (Integer) it.next();
			//System.out.println(tmp + " ");
			
			//위에 두줄을 한줄로 작성
			System.out.println(it.next() + " ");
		}
		
		sc.close();
		
	}

}
