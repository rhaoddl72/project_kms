package board;

import java.util.Scanner;

public class BoardProgram {

	private Board[] board;
	private Scanner sc;
	int count;
	
	public BoardProgram() { //생성자에서 값을 초기화 해줫다.
		//board = new Board[10];
		//sc = new Scanner(System.in);
		this(10); //위에 주석처리와 동일한 결과이다. this로 다른 생성자 값 가져오기
	}
	
	public BoardProgram(int max) {
		if(max <= 10){ //10개를 최소개수로 맞춰줌
			max = 10;
		}
		board = new Board[max];
		sc = new Scanner(System.in);
	}
	
	/*
	 * 기능 : 게시글을 추가하는 기능
	 * 매개변수 : 정보가 클래스에 모두 존재하므로 매개변수 필요 x
	 * 리턴타입 : 필요없음
	 * 메소드명 : insertBoard
	 * */
	
	public void insertBoard() {
		
		
		System.out.println("게시글 정보를 입력하세요.");
		System.out.println("제목 : ");
		String title = sc.next();
		System.out.println("작성자 : ");
		String writer = sc.next();
		System.out.println("작성일 : ");
		String registerDate = sc.next();
		System.out.println("내용 : ");
		String contents = sc.next();
		
		
		String type = "게시글";
		int num = count + 1;
		
		Board tmpBoard = new Board(title, contents, writer, registerDate, type, num);
		
		board[count] = tmpBoard;
		count++;
	}
	
	
	
	/*
	 * 기능 : 게시글 번호를 입력받아 입력받은 게시글을 확인하는 메소드
	 * 매개변수 : 클래스 내에 멤버변수들이 있으니까 필요 x
	 * 리턴타입 : 없음
	 * 메소드명 : printBoardDetail
	 * */
	public void printBoardDetail() {
		
		System.out.println("확인할 게시글 번호를 입력하세요 : "); 
		int num = sc.nextInt();
		
		
		if(num <= count && board[num-1] != null) {
			
			
			board[num-1].print();

		}
		else {
			System.out.println("해당 게시글이 없거나 삭제되었습니다.");
		}
	}
	
	/*
	 * 기능 : 게시글 전체를 확인하는 메소드
	 * 매개변수 : 클래스 내에 멤버변수들이 있으니까 필요 x
	 * 리턴타입 : 없음
	 * 메소드명 : printBoardList
	 * */
	public void printBoardList() {
		
		
		System.out.println("등록된 글 목록입니다.");
		
		
		for(int i = 0; i < count; i++) {
			if(board[i] != null) {
				board[i].summaryPrint();
			}
		}
	}
	
	
	/*
	 * 기능 : 수정할 게시글번호와 정보를 입력받아 수정하는 메소드
	 * 매개변수 : 클래스 내에 멤버변수들이 있으니까 필요 x
	 * 리턴타입 : 없음
	 * 메소드명 : modifyBoard
	 * */
	
	public void modifyBoard() {
		System.out.println("수정할 게시글 번호를 입력해주세요. : ");
		int num = sc.nextInt();
		
		if(num <= count && board[num-1] != null) {
			System.out.print("제목 : ");
			String title = sc.next();
			System.out.println("내용 : ");
			String contents = sc.next();
			
			board[num-1].modify(title, contents);
		}
		else {
			System.out.println("게시글이 없거나 삭제되었습니다.");
		}
	}
	
	
	/*
	 * 기능 : 게시글 번호를 입력받아 삭제하는 메소드
	 * 매개변수 : 클래스 내에 멤버변수들이 있으니까 필요 x
	 * 리턴타입 : 없음
	 * 메소드명 : deleteBoard
	 * */
	
	public void deleteBoard() {
		System.out.println("삭제할 번호를 입력해 주세요. : "); 
		int num = sc.nextInt();
						
		if(num <= count) {
			board[num-1] = null;
		}
	}
	
	
	/*
	 * 기능 : 게시글 프로그램 종료 기능
	 * 매개변수 : 없음
	 * 리턴타입 : 없음
	 * 메소드명 : closeBoard 
	 * */
	public void closeBoard() {
		System.out.println("프로그램 종료합니다.");
		sc.close();
	}
}

