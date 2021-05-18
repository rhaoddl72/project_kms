package accountbook;

import java.util.InputMismatchException;
import java.util.Scanner;



public class AccountBookTest {

	public static void main(String[] args) {
		/*
		 * 가계부 프로그램을 구현하려고 한다. 이 때 필요한 클래스를 만들어보세요.
		 * 
		 * 클래스 : accountBookTest클래스 지출클래스 수입클래스
		 *     
		 * 멤버변수 :
		 * 기능 :
		 * 
		 * 수입 : 수입 / 지출
		 * 날짜 :
		 * 자산 : 현금/은행/카드
		 * 분류 : 식비/교통/건강
		 * 금액 :
		 * 내용 :
		 * */
		
		
		
		
		
		//try-catch구문을 맨위부터 감싸주면 반복문을 실행하지 않고 그냥 종료 시켜버리는 문제 발생
		AccountBookProgram2 abp = new AccountBookProgram2();
		
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		int subMenu = 0;
		do {
			try {
			abp.printMenu();
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				abp.insert();
				break;
			
			case 2:
				abp.update();
				break;
				
			case 3:
				abp.delete();
				break;
				
			case 4:
			abp.printSubMenu();
			subMenu = sc.nextInt();
		
			switch(subMenu) {
			
			case 1:
				abp.printItemListDetail();
				break;
			
			case 2:
				abp.printItemListSimple();
				break;
				
			case 3:
				abp.printItem();
				break;
				
			case 4:
				abp.totalMoney();
				break;
				
			default :
				System.out.println("잘못된 메뉴입니다.");
			}
			break;
			
			case 5:
				System.out.println("프로그램 종료");
				break;
				
			default :
				System.out.println("잘못된 메뉴입니다.");
				break;
			}
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage()); //지정된 메세지가 없으면 null이뜬다.
				//nextLine을 이용 공백(스페이스)을 포함한 문자열을 엔터까지 가져옴 그리고 저장안하고 버려버림 그럼 입력버퍼가 비워짐 
				sc.nextLine();//이거 안해주면 무한루프된다.
				menu = 0;
			}
		}while(menu != 5);
		
		
	
}

}






