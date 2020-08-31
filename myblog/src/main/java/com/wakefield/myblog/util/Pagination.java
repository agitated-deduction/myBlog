package com.wakefield.myblog.util;

public class Pagination {
	private int curPage;
	private int startPage;
	private int endPage;
	private int totalPostCnt;
	private int totalPageCnt;
	private int pagePostCnt = 20;
	private int pageCnt = 10;
	private boolean prev;
	private boolean next;
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPostCnt() {
		return totalPostCnt;
	}
	public void setTotalPostCnt(int totalPostCnt) {
		this.totalPostCnt = totalPostCnt;
	}
	public int getTotalPageCnt() {
		return totalPageCnt;
	}
	public void setTotalPageCnt(int totalPageCnt) {
		this.totalPageCnt = totalPageCnt;
	}
	public int getPagePostCnt() {
		return pagePostCnt;
	}
	public void setPagePostCnt(int pagePostCnt) {
		this.pagePostCnt = pagePostCnt;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public void page(int curPage, int totalPostCnt) {
		this.curPage = curPage;
		this.totalPostCnt = totalPostCnt;
		
		this.totalPageCnt = this.totalPostCnt/pagePostCnt;
		this.startPage = (this.curPage-1)/this.pageCnt + 1;
		this.endPage = this.startPage+(this.pageCnt-1);
		
		this.prev = startPage>1;
		if(this.next = this.totalPageCnt<this.endPage)
			this.endPage = this.totalPageCnt;
		
		//게시물은 rownum 사용?
		
	}
	
}
