package day13;

public class CarTest {

	public static void main(String[] args) {
		
		AutoCar ac = new AutoCar("1종", "기아");
		StickCar sc = new StickCar("2종", "현대");
		
		ac.turnOn();
		ac.setGear('D');
		sc.setGear('2');
		ac.print();
		System.out.println("--------------------");
		sc.print();
		
		System.out.println("--------------------");
		Car c = ac; //자동 타입변화(클래스변환)이 되어서 위에 선언됐던 AutoCar클래스에서 Car클래스로 타입변환됨
		c.print();
		
		System.out.println("--------------------");
		//Car c2 = new Car("1종","기아"); // 안되는 경우 객체를 car(부모)로 생성 데이터 영역이 자식에 비해 좁다.(자식은 부모꺼 물려받고 +a이므로)
		Car c2 = new AutoCar("1종","기아"); //생성자가 autocar(자식)이고 데이터 영역이 널널하기 때문에 가능
		ac = (AutoCar)c2;
		ac.print();
		
		//차를 관리하는데 수동은 수동끼리 자동은 자동끼리 관리
		AutoCar[] acList = new AutoCar[5];
		StickCar[] scList = new StickCar[5]; //따로 관리해서 배열 2개필요
		 acList[0] = ac;
		 scList[0] = sc;
		 
		 
		//차를 관리하는데 수동과 자동 상관없이 같이 관리
		Car[] cList = new Car[5]; //같이 관리 가능 자식은 부모클래스로 자동 형변환되니까
		cList[0] = ac;
		cList[1] = sc;
		
	}
}
