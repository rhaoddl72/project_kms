package kr.green.test.pagination;

public class Criteria {

	//현재 페이지
	private int page;
	//한 페이지 당 컨텐츠 갯수
	private int perPageNum;
	
	//이 값을 여기서 지정안해주면 null이 들어가기때문에 list.jsp로 이동하면 게시글이 없다고 떠버린다.
	private int type;
	private String search;
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 20;
		this.type = 0;
		this.search = "";
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		}
		else {
			
			this.page = page;
		}
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 20;
		}else {
			
			this.perPageNum = perPageNum;
		}
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", type=" + type + ", search=" + search + "]";
	}
	
	
	public int getPageStart() {
		return (this.page-1) * perPageNum;
	}
	
	
	
		
		
		
	}
