package day18;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	
	public static void main(String[] args) {
		/* 
		 * Set 메소드 예제
		 * */
		//Set은 순서가 뒤죽박죽이라 번지로 뭔가를 하지않는다.
		HashSet<Integer> set = new HashSet<Integer>();
		
		//add(객체) : set에 객체를 추가
		set.add(10);
		set.add(10);
		set.add(5);
		set.add(4);
		set.add(8);
		set.add(100);
		
		//size() : set의 크기
		//중복을 허용하지 않기 때문에 2개가 들어갔지만 크기는 1로 나온다.
		System.out.println("set의 크기 : " + set.size());
		
		//contains(객체): 객체가 있는지 없는지 확인
		System.out.println("set에 10이 있습니까? " + set.contains(10));
		System.out.println("set에 11이 있습니까? " + set.contains(11));
		
		//isEmpty() : set이 비었는지 아닌지 확인
		System.out.println("set이 비어있습니까? " + set.isEmpty());
		
		//List나 Set을 이용할 때 공식처럼 쓰인다.
		//Iterator에 <Integer>가 없을 경우 tmp = (Integer)로 형변환 필요 왜냐면 it의 타입이 object가 되기 때문에
		//<Integer>넣어주면 (Integer)지워도 됨
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			//it.next()의 next()는 set에 있는값 하나를 가져오는것
			Integer tmp = (Integer) it.next();
			System.out.println(tmp + " ");
		}
		
		System.out.println();
		
		//remove(객체) : 객체와 일치하는 내용을 삭제하고 삭제 성공 여부를 알림
		System.out.println("set에 10의 값이 삭제 되었습니까? " + set.remove(10));
		System.out.println("set에 10의 값이 삭제 되었습니까? " + set.remove(101));
		
		//clear() : 비움
		set.clear();
		System.out.println("Set의 크기 : " + set.size());
	
	}

}
