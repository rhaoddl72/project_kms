package day10;

import day10.Point; // 같은 패키지에 있는 클래스이므로 생략가능

public class ClassEx3 {

	public static void main(String[] args) {
		
		//pt2라는 객체를 선언 후 생성
		//객체 pt2는 참조변수
		
		Point pt1 = null; 
 		Point pt2 = new Point();
 		
 		//에러 발생 : 객체가 생성되지 않은 상태에서 메소드를 호출했기 때문에
 		//pt1.print();
 		
 		//객체가 생성되었으므로 정상 호출됨
 		pt2.print();
 		pt2.move(4, 5);
 		pt2.print();
 		
 		Point pt3 = new Point(1,2); //생성자 값을 넣어주었다 scanner(system.in)<=처럼
 		pt3.print();
	}
}
