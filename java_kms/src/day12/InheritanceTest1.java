package day12;



public class InheritanceTest1 {

	public static void main(String[] args) {
		Parent p = new Parent();
		p.print();
		
		child c = new child();
		//c.num2 = 10; private 받지 못한다.
		c.num3 = 10;
		c.num4 = 10;
		c.print();
	}
}

class Parent{
	public int num;
	private int num2;
	protected int num3;
	int num4;
	public void print() {
		System.out.println("num : " + num);
	
	}
}


class child extends Parent{
	
	public void print2() {
		//System.out.println("num2 : " + num2); //부모클래스에 getter setter만들어서 값 넘겨받아야 한다.
		System.out.println("num3 : " + num3);
		System.out.println("num4 : " + num4);
		
	}
}
