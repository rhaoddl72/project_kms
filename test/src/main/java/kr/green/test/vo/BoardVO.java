package kr.green.test.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {

	private int num;
	private String title;
	private String contents;
	private String writer;
	private String valid;
	private Date registered;
	private int views;
	private String type;
	private int up;
	private int down;
	public String getRegisteredDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(registered);
	}
	
	
}
