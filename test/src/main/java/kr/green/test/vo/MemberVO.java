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
}
