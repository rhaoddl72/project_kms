package accountbook;

import java.util.Scanner;



public class AccountBookProgram2 {

	private AccountBook2 book;
	private Scanner sc = new Scanner(System.in);
	private int count;
	
	
	
	
	public AccountBookProgram2(int max) {
		book = new AccountBook2(max);
	}
	
	public AccountBookProgram2() {
		book = new AccountBook2();
	}
	
	
	//기능 : 메뉴 출력
	public void printMenu() {
		System.out.println("------메뉴-------");
		System.out.println("1.가계부 등록");
		System.out.println("2.가계부 수정");
		System.out.println("3.가계부 삭제");
		System.out.println("4.가계부 확인");
		System.out.println("5.가계부 종료");
		System.out.println("------------------");
		System.out.println("메뉴를 선택 하세요 : ");
	}
	
	public void printSubMenu() {
		System.out.println("---------확인-------");
		System.out.println("1. 전체 내역 상세");
		System.out.println("2. 전체 내역 요약");
		System.out.println("3. 선택 내역 상세");
		System.out.println("4. 내역 합계");
		System.out.println("------------------");
		System.out.println("메뉴를 선택 하세요 : ");
	}



	/*
	 *기능 : 내역 정보를 입력받아 내역을 생성하여 알려주는 기능
	 *매개변수 : 없음
	 *리턴타입 : 생성된 내역 => Item
	 *메소드명 : createItem
	 */
	
	private Item createItem() { //밖에서 쓸일 없으니까 private해도됨
		 						//인설트랑 업데이트 메소드에서 겹치므로 이부분 메소드 만들어주기
		System.out.println("수입/지출을 입력해주세요.");
		String type = sc.next();
		
		System.out.println("날짜를 입력해주세요.");
		String date = sc.next();
		
		System.out.println("결제타입을 입력해주세요.");
		String paymentType = sc.next();
		
		System.out.println("사용내역을 입력해주세요.");
		String category = sc.next();
		
		System.out.println("가격을 입력해주세요.");
		int cost = sc.nextInt();
		
		System.out.println("세부내용을 입력해주세요.");
		String contents = sc.next();
		
		Item item = new Item(type, date, paymentType, category, cost, contents);
		
		return item;
	}
	
	
	
	/*
	 *기능 : item 내역을 입력받는 기능
	 *매개변수 : 없음
	 *리턴타입 : void 
	 *메소드명 : insert
	 */
	
	public void insert() {
		
			
		Item item = createItem();	
		
			book.insert(item);
			
	}
	
	/*
	 *기능 : item 내역을 수정할 사항을 입력받는 기능
	 *매개변수 : 없음
	 *리턴타입 : void 
	 *메소드명 : update
	 */
	
	public void update() {
		System.out.println("수정할 번호를 입력해주세요.");
		int index = sc.nextInt();
		
		//삭제되거나 해서 없어지거나 내용이 남아있지 않을 때 보내는 오류메시지 
		if(index < 1 || index > book.getCount()) {
			System.out.println("수정할 수 없는 내역입니다.");
			return;
		}
		
		System.out.println("수정할 내역을 입력하세요.");
		Item item = createItem();
		
		book.update(index-1, item); //출력에서 보여주는 번호는 1부터고 번지는 0번지부터니까 -1해준다.
		System.out.println("수정이 완료되었습니다.");
	}
	
	
	
	/*
	 *기능 : 삭제할 번지를 입력받고 해당 번지 내역을 삭제하는 기능
	 *매개변수 : 없음
	 *리턴타입 : void 
	 *메소드명 : delete
	 */
	
	public void delete() {
		System.out.println("삭제할 번호를 입력해주세요.");
		int index = sc.nextInt();
		
		if(index < 1 || index > book.getCount()) {
			System.out.println("삭제할 수 없는 내역입니다.");
			return;
		}
		
		book.delete(index-1);
		
	}
	
	
	//내역 전체를 상세 출력하는 메소드
	public void printItemListDetail() {
		book.printItemListDetail();
	}
	
	//내역 전체를 간략하게 출력하는 메소드
	public void printItemListSimple() {
		book.printItemSimple();
	}
	
	
	
	/*
	 *기능 : 번지를 입력받고 해당 번지의 내역을 출력하는 기능
	 *매개변수 : 없음
	 *리턴타입 : void 
	 *메소드명 : printItem
	 */
	
	public void printItem() {
		System.out.println("확인하고 싶은 번호를 입력해주세요.");
		int index = sc.nextInt();
		
		if(index < 1 || index > book.getCount()) {
			System.out.println("확인할 수 없는 내역입니다.");
			return;
		}
		
		book.printItem(index-1);
	}
	
	/*
	 *기능 : 가계부 금액을 출력하는 메소드
	 *매개변수 : 없음
	 *리턴타입 : void 
	 *메소드명 : totalMoney
	 */
	
	public void totalMoney() {
		System.out.println("내역 합계 : " + book.getTotal() + "원");
		
		
	}
	
	
}
