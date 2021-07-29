package kr.green.test.vo;

import lombok.Data;

@Data
// db에 적혀있는 속성명 그대로 적어준다.
public class MemberVO {
	private String id;
	private String pw;
	private String gender;
	private String email;
	private String name;
	private String authority;
	// boolean을 Boolean으로 해줬는데 차이는 소문자 b는 일반 자료형
	// 대문자 B는 클래스의 객체로 만들어진다. 그래서 null이 값으로 들어갈 수 있다.
	private Boolean useCookie;
	public String getAuthorityStr() {
		if(authority.equals("USER"))
			return "회원";
		
		if(authority.equals("ADMIN"))
			return "관리자";
		
		if(authority.equals("SUPER ADMIN"))
			return "최고 관리자";
		return "";
	}
	//권한 비교가 안되면 -100 , 권한이 같으면 0, 내가 권한이 낮으면 -1, 내가 권한이 높으면 1
	public int compareAuthority(MemberVO user) {
		if(user == null)
			return -100;
		//권한이 같은 경우
		if(user.getAuthority().equals(authority))
			return 0;
		
		// 에러뜨면 마우스올려서 jre 업데이트
		// 권한이 다른 경우
		switch(authority) {
		case "USER":
			if(user.getAuthority().equals("ADMIN") || 
			   user.getAuthority().equals("SUPER ADMIN"))
			return -1;
				
			return -100;
			
		case "ADMIN":
			if(user.getAuthority().equals("SUPER ADMIN"))
					return -1;
			if(user.getAuthority().equals("USER"))
				return 1;
			
				return -100;
			
		case "SUPER ADMIN":
			
			if(user.getAuthority().equals("ADMIN") || 
					   user.getAuthority().equals("USER"))
					return 1;
			return -100;
		}
		return -100;
	}
}
