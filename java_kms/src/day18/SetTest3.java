package day18;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class SetTest3 {
	
	public static void main(String[] args) {
		/*
		 * 중복되지 않은 6개의 수를 랜덤으로 생성하여 저장한 후 출력하는 코드를 작성하세요.
		 * 단 숫자의 범위는 1~45
 		 * */
		
		//수가 중복되지 않게 set생성
		HashSet<Integer> set = new HashSet<Integer>();
		
		//랜덤 생성
		int max = 45;
		int min = 1;
		
		
		//랜덤수 저장하기
		while(set.size() < 6) {
		
			
			int r = (int)(Math.random() * (max-min+1)+min);
			set.add(r);
			
			//set.add((int)(Math.random() * (max-min+1)+min));
		}
		
		System.out.println("로또 : ");
		//출력
			Iterator<Integer> it = set.iterator();
			while(it.hasNext()) {
					
				
				System.out.println(it.next() + " ");
					
		}
	}

}
