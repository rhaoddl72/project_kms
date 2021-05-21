package day18;

import java.util.HashMap;
import java.util.Scanner;

public class MapTest2 {

	/*다음 두 기능을 가진 프로그램을 작성하세요.
	 * 
	 * 1. 회원가입
	 * 2. 로그인
	 * 3. 종료
	 * 
	 * 예시 >
	 * 1.회원가입
	 * 2.로그인
	 * 3.종료
	 * 메뉴 선택 : 1
	 * 회원가입
	 * 아이디 : abc123
	 * 비밀번호 : abc123
	 * 회원가입되었습니다.
	 * 1.회원가입
	 * 2.로그인
	 * 3.종료
	 * 메뉴 선택 : 1
	 * 아이디 : abc123
	 * 이미 가입된 회원입니다.
	 * 1.회원가입
	 * 2.로그인
	 * 3.종료
	 * 
	 * */
	
	
	
	public static void main(String[] args) {
		
		//회원가입 = 아이디랑 비밀번호 입력 = key, value 아이디가 key니까 있으면 이미 가입된회원 출력
		HashMap<String, String> map = new HashMap<String, String>();
		int menu = 0;
		
		while(menu < 3) {
			//메뉴
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");
			
			//메뉴 선택   //Switch문
			Scanner sc = new Scanner(System.in);
			System.out.println("메뉴를 선택해주세요 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1 : 
				System.out.println("등록할 아이디를 입력해주세요. ");
				String id = sc.next();
				System.out.println("등록할 비밀번호를 입력해주세요.");
				String pw;
				if(!map.containsKey(id)) {
					
					pw = sc.next();
					map.put(id, pw);
				}else {
					
					System.out.println("이미 가입된 회원입니다.");
					
				}
				
				break;
			case 2 :
				System.out.println("아이디를 입력해주세요. ");
				id = sc.next();
				System.out.println("비밀번호를 입력해주세요. ");
				pw = sc.next();
				
				if(map.containsKey(id) == true && map.containsValue(pw) == true) {
					System.out.println("로그인에 성공했습니다.");
				}else {
					System.out.println("로그인에 실패했습니다.");
				}
				break;
			case 3 :
				System.out.println("종료되었습니다.");
				break;
			}
		}
		
	}
	
}
