package day15;

public class polymorphismTest {

	public static void main(String[] args) {
		Car car = new Car();
		car.frontLeft.roll();
		car.frontRight.roll();
		repair(car.frontLeft);
		repair(car.frontRight);
	}
	
	public static void repair(Tire tire) {
		/* (HankookTire)tire.company : Tire 인터페이스의 멤버변수 company를 찾은 후 tire를 HankookTire로 타입변환
		 * (HankookTire)tire).company : tire를 한국타이어로 타입 변환 후 멤버 변수 company를 찾음*/
		
		
		if(tire instanceof HankookTire) { //형변환 되는지 안되는지 알려주는 기능 instanceof
						
			//tire는 Tire타입이기 때문에 Kumho랑 Hankook에서 만들어준 company를 가져 올 수 없다. 가져오려면 아래방식으로 해야한다.
			HankookTire t = (HankookTire)tire;
			System.out.println(t.company + "수리합니다. ");
			System.out.println(((HankookTire)tire).company + "수리합니다. "); //괄호로도 가능
		}
		
		
		if(tire instanceof KumhoTire) { //형변환 되는지 안되는지 알려주는 기능 instanceof
		
			KumhoTire t = (KumhoTire)tire;
			System.out.println(t.company + "수리합니다. ");
			System.out.println(((KumhoTire)tire).company + "수리합니다. "); //괄호로도 가능
		}
	}
}

class Car{
	
	//인터페이스를 이용한 멤버변수(필드)의 다형성 예제
	Tire frontLeft = new HankookTire();
	Tire frontRight = new KumhoTire();
}

interface Tire{
	
	void roll();//바퀴가 구르는 기능
}

class KumhoTire implements Tire{
	
	String company = "금호";

	@Override
	public void roll() {
		System.out.println("금호 타이어가 굴러갑니다.");
		
	}
	
}


class HankookTire implements Tire{
	
	String company = "한국";

	@Override
	public void roll() {
		System.out.println("한국 타이어가 굴러갑니다.");
		
	}
	
}
