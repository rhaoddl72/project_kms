package day11;

public class ThisTest {
	
	public static void main(String[] args) {
		TestA t = new TestA(5);
		t.print();
	}

}

class TestA{
	private int num;
	
	public TestA(int num) {
		//멤버 변수 num에 매개변수 num의 값을 저장
		//num = num; //매개변수에 매개변수 값이 들어감 결국 5에 5가 들어감
		//메소드에서 우선순위는 멤버변수보다 매개변수가 높다
		
		this.num = num; // this.num은 멤버변수이고 num은 매개변수이다.
	}
	
	public void print() {
		System.out.println("num : "+ num);
	}
}
