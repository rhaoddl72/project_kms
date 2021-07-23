package kr.green.test.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyVO {
	private int rp_num;
	private int rp_bd_num;
	private String rp_me_id;
	private String rp_content;
	private String rp_valid;
	private Date rp_regDate;
	private Date rp_upDate;
	
	
}

