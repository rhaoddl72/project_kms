package kr.green.spring.vo;

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
	
}
