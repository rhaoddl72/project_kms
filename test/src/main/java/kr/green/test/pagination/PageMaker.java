package kr.green.test.pagination;

import lombok.Data;

@Data
public class PageMaker {
	//나타나는 콘텐츠수에 따라 나타내는 페이지가 달라지므로 그걸 계산하는 변수?
		private int totalCount; // 총페이지 수

		private int startPage;
		private int endPage;
		private boolean prev;
		private boolean next;
		private int displayPageNum;
		private Criteria criteria; //현재 페이지
		
		
		public void calcData() {
			
	
			endPage = (int) (Math.ceil(criteria.getPage()/(double) displayPageNum)*displayPageNum);
			
			startPage = (endPage - displayPageNum)+1;
		

			int tempEndPage = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
			
			
			if(endPage > tempEndPage) {
				endPage = tempEndPage;
			}
			
			prev = startPage == 1 ? false : true;
			
			next = endPage * criteria.getPerPageNum() >= totalCount ? false:true;
		}
		
		
		public PageMaker(int totalCount, int displayPageNum, Criteria cri) {
			this.totalCount = totalCount;
			this.displayPageNum = displayPageNum;
			this.criteria = cri;
			calcData();
		}
	}

