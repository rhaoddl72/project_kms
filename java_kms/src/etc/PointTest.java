package etc;

public class PointTest {

	public static void main(String[] args) {
		
			//기본 생성자 객체 생성
			Point p = new Point();
			
			p.setX(10);
			p.setY(10);
			p.print();
					
			//매개변수 2개인 생성자 객체 생성
			Point p2 = new Point(10,10);
			
			p2.print();
			
	}
	
}

class Point{
	
	private int x;
	private int y;
	
	public Point() {
		
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void print() {
		System.out.println("좌표 : ( " + x + " , " + y + " ) " );
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
