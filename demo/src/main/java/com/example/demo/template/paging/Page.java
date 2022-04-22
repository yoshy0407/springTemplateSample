package com.example.demo.template.paging;

public class Page {

	private final int pageNo;
	
	private final int pagePerSize;
	
	public Page(int pageNo, int pagePerSize) {
		this.pageNo = pageNo;
		this.pagePerSize = pagePerSize;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	
	public int getPagePerSize() {
		return pagePerSize;
	}
	
	public int offset() {
		return pagePerSize * (pageNo - 1);
	}
	
	public int limit() {
		return pagePerSize;
	}
}
