package kr.green.test.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	public String getRegisteredDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(registered);
	}
}
