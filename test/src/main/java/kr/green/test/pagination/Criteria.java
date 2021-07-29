package kr.green.test.pagination;

import lombok.Data;

@Data
public class Criteria {
	//현재 페이지
	private int page; 
	//한 페이지 당 컨텐츠 갯수
	private int perPageNum;
	//Criteria 디폴트 생성자 : 현재 페이지를 1페이지로, 한 페이지에 10개의 컨텐츠
	private String sortType;
	private String sort;
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		this.sortType = "id";
		this.sort = "asc";
	}
	
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	
	public String getNotSort() {
		if(sort.equals("asc"))
			return "desc";
		else
			return "asc";
	}
	
}

