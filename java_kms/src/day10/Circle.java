package day10;



public class Circle {

	/*private int x;
	private int y;
	private int radius;
	*/
	
	private Point center = new Point();
	private int radius;
	
	
	
	/*
	 * 기능 : 원의 중심점을 이동하는 메소드
	 * 매개변수 : 이동할 중심점의 위치 => int x , int y
	 * 리턴타입 : void
	 * 메소드명 : move
	 * */
	
	public void move(int x, int y) {
		center.move(x, y); //point에있는 move메소드를 가져오기는 까다롭기때문에 그냥 새로 move메소드 만들어줌
		
		//center.setX(x);
		//center.setY(y);
	}
	
	
	/*
	 * 기능 : 원의 정보를 출력하는 메소드
	 * 매개변수 : circle이라는 클래스는 나이고 이미 정보를 다 알기에 필요없음 
	 * 리턴타입 : void
	 * 메소드명 : print
	 * */
	
	public void print() {
		/*다음과 같이 출력되도록 코드를 작성하세요.
		 * 중심점 : (?,?)
		 * 반지름 : ?
		 * 
		 * */
		System.out.print("중심점 : ");
		center.print();
		System.out.println("반지름 : " + radius);
	}
	
	
	public Point getCenter() {
		return center;
	}



	public void setCenter(Point center) {
		this.center = center;
	}



	public int getRadius() {
		return radius;
	}


	//반지름의 길이를 수정하는 set메소드이므로 굳이 반지름길이 바꿔줄 메소드 만들어줄 필요x
	public void setRadius(int radius) {
		this.radius = radius;
	}



}
