package day15;

public class AnonymousTest {

	public static void main(String[] args) {
	
		//TvRemocoon클래스를 이용하여 객체를 만든것과 같은 결과를 가진다.
		//단 해당 익명객체를 사용하려면 코드를 복붙해야 되기 때문에 비효율적이다.
		//=> 재사용 불가로 코드복붙을 해야함
		Remocon r = new Remocon() {
			//메인 메소드 안에 메소드가 또 있는 모습이다 => 익명객체
			@Override  //메인에 갑자기 뜬 오버라이드 익명객체라고 보면 된다.
			public void turnOn() {
				System.out.println("전원 켜짐");
				
			}
			
			
			@Override
			public void turnOff() {
				System.out.println("전원 꺼짐");
				
			}
		};
		
		
		r.turnOn();
	}
}



abstract class Parent{
	abstract void print();
	
}

class Child extends Parent{

	@Override
	void print() {
		System.out.println("안녕");
	}
	
	
}

class TempA{
	//private Parent p = new Child();
	
	//parent 추상 클래스를 이용하여 새로운 익명 객체를 생성한 후, 생성한 익명 객체의 주소를 p에 저장
	
	private Parent p = new Parent(){  //클래스를 여기에서 새로 하나 만들었다?
		
		int num = 10;
		
		@Override
		public void print() {
			System.out.println("안녕");
		}
	};
}


interface Remocon{
	void turnOn();
	void turnOff();
	
	
}


class TvRemocon implements Remocon{

	@Override
	public void turnOn() {
		System.out.println("전원 켜짐");
		
	}

	@Override
	public void turnOff() {
		System.out.println("전원 꺼짐");
		
	}
	
}