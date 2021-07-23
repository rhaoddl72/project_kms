package kr.green.test.pagination;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Criteria {
	@Getter
	private int page;
	
	@Getter
	private int perPageNum;
	
	@Getter@Setter
	private int type;
	
	@Getter@Setter
	private String search;
	
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
//		int는 기본값이 0이니까 초기화필요x search는 null이라 ""빈문자열 만들어줌
		this.search = "";
	}
	
	
	public Criteria(int page, int perPageNum) {
		setPage(page);
		setPerPageNum(perPageNum);
	}


	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		}
		else {
			
			this.page = page;
		}
	}
	
	public void setPerPageNum(int perPageNum) {
		
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
		}else {
			
			this.perPageNum = perPageNum;
		}
	}
	
	
	public int getPageStart() {
		return (this.page-1) * perPageNum;
	}
	
		
	}
