package day6;

import java.util.Calendar;

public class Enum3 {
	
	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR); // now.get(1) 한거랑 같다. 그치만 코드상으로
										   // 알아보기 쉽게 열거형처럼 calender.year식으로 사용
		
		int month = now.get(Calendar.MONTH) + 1; //now.get(2) 한거랑 같다.
		
		System.out.println(year + "년" + month + "월");
	}

}
