package com.ssafy.util;

public class PageNavigation {
	
	private boolean startRange; // 이전버튼 활성화 여부 
	private boolean endRange; // 다음 버튼 활성화 여부 
	private int totalCount; // 전체 글수 
	private int newCount; // 새 글수 
	private int totalPageCount; // 전체 페이지수  - db갔다와야함
	private int currentPage; // 현재페이지
	private int naviSize; // 범위당 페이지 수 
	private int countPerPage; // 한 페이지당 글수  
	private String navigator; // 네비게이션 

	public boolean isStartRange() {
		return startRange;
	}

	public void setStartRange(boolean startRange) {
		this.startRange = startRange;
	}

	public boolean isEndRange() {
		return endRange;
	}

	public void setEndRange(boolean endRange) {
		this.endRange = endRange;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getNewCount() {
		return newCount;
	}

	public void setNewCount(int newCount) {
		this.newCount = newCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNaviSize() {
		return naviSize;
	}

	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}

	public String getNavigator() {
		return navigator;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public void makeNavigator() {
		int startPage = (currentPage - 1) / naviSize * naviSize + 1;
		int endPage = startPage + naviSize - 1;
		if(totalPageCount < endPage)
			endPage = totalPageCount;
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("		<ul class=\"pagination\"> \n");
		buffer.append("			<li class=\"page-item\" data-pg=\"1\"> \n");
		buffer.append("				<a href=\"#\" class=\"page-link\">최신</a> \n"); // 최신 :1페이지로
		buffer.append("			</li> \n");
		buffer.append("			<li class=\"page-item\" data-pg=\"" + (this.startRange ? 1 : (startPage - 1)) + "\"> \n"); // 지금 내 페이지에서 바로 앞페이지
		buffer.append("				<a href=\"#\" class=\"page-link\">이전</a> \n");
		buffer.append("			</li> \n");
		for(int i=startPage;i<=endPage;i++) {
			buffer.append("			<li class=\"" + (currentPage == i ? "page-item active" : "page-item") + "\" data-pg=\"" + i + "\"><a href=\"#\" class=\"page-link\">" + i + "</a></li> \n");
		}
		buffer.append("			<li class=\"page-item\" data-pg=\"" + (this.endRange ? endPage : (endPage + 1)) + "\"> \n"); // 마지막페이지에서 바로 다음 페이지
		buffer.append("				<a href=\"#\" class=\"page-link\">다음</a> \n");
		buffer.append("			</li> \n");
		buffer.append("			<li class=\"page-item\" data-pg=\"" + totalPageCount + "\"> \n");
		buffer.append("				<a href=\"#\" class=\"page-link\">마지막</a> \n");
		buffer.append("			</li> \n");
		buffer.append("		</ul> \n");
		this.navigator = buffer.toString();
	}

}
