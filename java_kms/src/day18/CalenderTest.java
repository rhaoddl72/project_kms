package day18;

import java.util.Calendar;

public class CalenderTest {
	
	//final static int num2 = 0; //YEAR도 이런식으로 돼있다.
	public static void main(String[] args) {
		//calender는 추상클래스 생성자에서 멤버변수 못준다
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR); // Calendar.YEAR = 1로 정의돼있다. YEAR는 클래스 상수이다.
		int month = now.get(Calendar.MONTH) + 1; //2로 정의돼있다. month는 0에서부터 11을 가져와서 +1필요
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK);
		
		//get은 숫자 리턴이라 숫자요일이 나온다. 그래서 스위치문으로 문자열로 바꿔주기
		String weekStr = "";
		switch(week) {
		case Calendar.MONDAY: weekStr = "월"; break;
		case Calendar.TUESDAY: weekStr = "화"; break;
		case Calendar.WEDNESDAY: weekStr = "수"; break;
		case Calendar.THURSDAY: weekStr = "목"; break;
		case Calendar.FRIDAY: weekStr = "금"; break;
		case Calendar.SATURDAY: weekStr = "토"; break;
		case Calendar.SUNDAY: weekStr = "일"; break;
		}
		System.out.println(year + "년 " + month + "월 " + day + "일 " + weekStr + "요일");
		int amPm = now.get(Calendar.AM_PM); //오전인지 오후인지 확인해줌
		
		String amPmStr = amPm == Calendar.AM ? "오전" : "오후";
		
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		System.out.println(amPmStr + " " + hour + "시 " + minute + "분 " + second + "초");
		
	}

}
