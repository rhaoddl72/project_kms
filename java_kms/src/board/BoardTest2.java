package board;

import java.util.Scanner;

public class BoardTest2 {

	public static void main(String[] args) {
		BoardProgram bp = new BoardProgram();
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		
		do {
			printMenu();
			menu = sc.nextInt();
			switch(menu) {
			case 1 :
				bp.insertBoard();
				break;
				
			case 2 :
				bp.modifyBoard();
				
			case 3 :
				bp.deleteBoard();
				
			case 4 :
				bp.printBoardList();
				break;
				
			case 5 :
				bp.printBoardDetail();
				break;
				
			case 6 :
				bp.closeBoard();
				break;
			}
			
		}while(menu != 6);
		
	}
	
	public static void printMenu() {
		System.out.println("------메뉴-------");
		System.out.println("1.게시글 등록");
		System.out.println("2.게시글 수정");
		System.out.println("3.게시글 삭제");
		System.out.println("4.게시글 목록확인");
		System.out.println("5.게시글 상세확인");
		System.out.println("6.프로그램 종료");
		System.out.println("------------------");
		System.out.println("메뉴를 선택 하세요 : ");
	}
}
