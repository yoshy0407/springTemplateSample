package com.example.demo.template.paging;

import java.util.List;

public class SearchListResult<T> {

	private final long count;
	
	private final List<T> resultList;
	
	public SearchListResult(long count, List<T> resultList) {
		this.count = count;
		this.resultList = resultList;
	}
	
	public long getCountAllData() {
		return count;
	}
	
	public List<T> getResultList(){
		return resultList;
	}
}
