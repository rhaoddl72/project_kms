package day13;

import java.util.Scanner;

public class FigureTest {

	public static void main(String[] args) {
		/*
		Rect r = new Rect(167, 255, 278, 391);
		
		r.print();
		Circle c = new Circle(5,10,5);
		c.print();*/
		
		Figure[] arr = new Figure[10];
		int maxCount = 0;//최대로 그린 도형의 개수
		int pos = 0;//현재 도형의 번호
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("----------------------");
			System.out.println("1. 도형그리기");
			System.out.println("2. 실행 취소");
			System.out.println("3. 다시 실행");
			System.out.println("4. 확인 하기");
			System.out.println("5. 종료");
			System.out.println("----------------------");
			System.out.println("메뉴 선택 : ");
			menu = sc.nextInt();
			
			
			switch(menu) {
			case 1 : 
				System.out.println("그릴 도형을 선택하세요(1.원, 2.사각형) : ");
				int selectFigure = sc.nextInt();
				switch(selectFigure) {
				case 1:
					System.out.println("중심점을 입력하세요(예: 10 10) : ");
					int x = sc.nextInt();
					int y = sc.nextInt();
					System.out.println("반지름을 입력하세요 : ");
					int r = sc.nextInt();
					/*
					arr[pos] = new Circle(x,y,r);
					pos ++;*/
					arr[pos++] = new Circle(x,y,r); //위에 주석처리 두줄과 같은 코드이다.
					maxCount = pos;
					break;
				case 2:
					System.out.println("좌상점을 입력하세요(예: 10 10) : ");
					int left = sc.nextInt();
					int up = sc.nextInt();
					
					System.out.println("우하점을 입력하세요(예: 10 10) : ");
					int right = sc.nextInt();
					int down = sc.nextInt();
					/*arr[pos] = new Rect(left, up, right, down);
					pos ++;*/
					arr[pos++] = new Rect(left, up, right, down); //위에 주석처리 두줄과 같은 코드이다.
					maxCount = pos;
					break;
				default:
					System.out.println("없는 도형입니다.");
				}
				break;
			case 2 : 
				if(pos != 0) {
					pos--;
				}
				break;
			case 3 : 
				if(pos < maxCount) {
					pos++;
				}
				break;
			case 4 : 
				for(int i = 0; i < pos; i++) {
					arr[i].print();
				}
				break;
			case 5 : break;
			}
			
			
		}while(menu != 5);
		
		sc.close();
	}
}
