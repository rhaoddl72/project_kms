package kr.green.test.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pw;
	private String gneder;
	private String email;
	private String name;
	private String authority;
}
