package day11;

public class MethodOverloadingTest {

	public static void main(String[] args) {
		Point2 p2 = new Point2();
		p2.print();
		p2.move(4,5);
		p2.print();
		Point2 p22 = new Point2(10,20);
		p2.move(p22);
		p2.print();
	}
}

class Point2{
	private int x,y;
	
	public Point2() {
		this(0,0); // 해당 클래스에서 매개변수가 2개있는 생성자를 찾아내어 호출해낸다. point2(int x, int y)호출
		
	}
	
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point2(Point2 pt) {
		this(pt.x,pt.y); //얘도 point2(int x, int y)호출
		
	}
	
	public void print() {
		System.out.println("(" + x + "," + y + ")");
		
	}
	
	/* 기능 : 이동할 x,y좌표가 주어지면 해당 좌표로 이동하는 메소드
	 * 매개변수: 이동할 x,y좌표 => int x, int y
	 * 리턴타입: 없음 => void
	 * 메소드명: move*/
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	/* 기능 : 이동할 좌표가 Point2의 객체로 주어지면 해당 좌표로 이동하는 메소드
	 * 매개변수: 이동할 좌표 point2의 객체 => Point2 p2
	 * 리턴타입: 없음 => void
	 * 메소드명: move*/
	
	public void move(Point2 p2) {
		x = p2.x;
		y = p2.y;
		
	}
}
