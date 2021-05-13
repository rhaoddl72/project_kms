package day13;

public class Car {

	//전원, 기어, 차종, 제조사
	
	private boolean power;
	private char gear; //수동: 1,2,3,4,5 자동 : P,D,N,R
	private String type, company;
	
	
	public void turnOn() {power = true;}
	public void turnOff() {power = false;}
	
	
	
	public Car(String type, String company) {
		this.type = type;
		this.company = company;
	}
	

	
	
	public boolean isPower() {
		
		return power;
	}
	public char getGear() {
		return gear;
	}
	public void setGear(char gear) {
		this.gear = gear;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompany() {
		return company;
	}
	
	
	public void print() {
		System.out.println("제조 : " + company);
		System.out.println("차종 : " + type);
		System.out.println("전원 : " + power);
		System.out.println("기어 : " + gear);
	}
	
	
}
