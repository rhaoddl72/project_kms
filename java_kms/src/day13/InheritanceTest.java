package day13;

public class InheritanceTest {

	public static void main(String[] args) {
		Child c = new Child(1,2,3);
		c.print();
		c.print2();
		String s;
	}
}

class Parent{
	//멤버변수의 접근제한자는 되도록 default 제외하고 쓰는게 좋다.
	private int num1; //변수가 private이면 자식한테 넘겨주기 불가 getter setter 활용
	protected int num2;
	public int num3;
	
	public void print() {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
	}
	
	
	public Parent(int num1, int num2, int num3) {
		super(); //없어도 무조건 자동생성됨
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}


	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	public final void menu() {
		System.out.println("메뉴입니다.");
	}
	
}

class Child extends Parent{
	public int num4;
	
	public Child(int num1,int num2,int num3) {
		super(num1,num2,num3);
	}
	
	public void print2() {
		System.out.println(getNum1());
		System.out.println(getNum2());
		System.out.println(num3);
	}
	
	//메소드 오버라이딩
	//접근제한자를 좁힐 수는 없다.
	//부모클래스의 메소드가 Public이면 private이나 protected로 수정할 수 없다.
	@Override //오버라이드/오버라이딩 해줬다는 표시
	public void print() { 
		super.print();
		System.out.println("num 4 : " + num4);
	}
	
	//오버로드/오버로딩
	public void print(int num1) { 
		super.print();
		System.out.println("num 4 : " + num4);
	}
	
	/*public void menu() { //부모클래스 menu가 final메소드라 수정(오버라이딩)이 불가능 오류뜸
		
	}*/
	
}


/*final 클래스 String을 통해 자식 클래스를 만들 수 없다 => String은 대표적인 final클래스
class subString extends String{
	
}*/
