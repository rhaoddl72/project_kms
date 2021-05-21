package day18;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest {

	//날짜를 나타낼때 시간객체를 사용하고 출력할때는 문자열로 바꿔 사용한다.
	public static void main(String[] args) {
		//현재시간을 객체로 생성
		Date date = new Date();
		
		//현재시간을 출력
		System.out.println(date);
		
		//현재시간을 원하는 형태로 문자열로 변경(Date => String)
		//년도 y는 소문자 월 m은 대문자 일 d는 소문자만 지켜주고 원하는 형태로 만들면됨
		//문자열로 변경한다는건 출력한다는 거니까 getter
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//()안에 패턴 지정
		String str = form.format(date);
		System.out.println(str);
		
		//시간표현으로 된 문자열을 시간 객체로 변경(String => Date)
		//문자열을 객체로 변경한다는건 멤버변수를 바꿔준다는 거니까 setter사용
		String str2 = "2021-05-21 09:50:55";
		SimpleDateFormat form2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date2;
		//실행예외가 아닌 경우 무조건 예외처리 필요(Date date2 = form2.parse(str2)하고 출력하려면 오류가 떴었다.
		try {
			System.out.println(str2);
			date2 = form2.parse(str2);
			System.out.println(date2);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		//hotel 시간예약 출력해보기
		System.out.println("예약 정보를 입력하세요.");
		System.out.println("입실일(yyyy년MM월dd일) : ");
		Scanner sc = new Scanner(System.in);
		String startDate = sc.next();
		System.out.println("퇴실일(yyyy년MM월dd일) : ");
		String endDate = sc.next();
		Hotel hotel = new Hotel();
		hotel.setEndDate(endDate);
		hotel.setStartDate(startDate);
		System.out.println(hotel);
		
		
		sc.close();
	}
}

class Hotel{
	
	//입실일
	Date startDate;
	
	//퇴실일
	Date endDate;

	public String getStartDate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy년MM월dd일");
		String str = form.format(startDate);
		return str;
	}

	public void setStartDate(String startDate) {
		SimpleDateFormat form2 = new SimpleDateFormat("yyyy년MM월dd일");
		
		try {
			
			this.startDate = form2.parse(startDate);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}

	public String getEndDate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy년MM월dd일");
		String str = form.format(endDate);
		return str;
	}

	public void setEndDate(String endDate) {
		SimpleDateFormat form2 = new SimpleDateFormat("yyyy년MM월dd일");
		
		try {
			
			this.endDate = form2.parse(endDate);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Hotel [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
	
	
	
	
}
