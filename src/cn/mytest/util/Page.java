package cn.mytest.util;

public class Page {
	  //总页数
      private int totalPageCount;
      //每页条数
      private int pageSize=3;
      //总条数
      private int totalCount;
      //当前页码
      private int curPage;
      
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize>0){
			this.pageSize = pageSize;
		}
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if(totalCount>0){
			this.totalCount = totalCount;
			totalPageCount=this.totalCount%pageSize==0?(this.totalCount/pageSize):(this.totalCount/pageSize+1);
		}		
	}
	public int getCurPage() {
		if(totalPageCount==0){
			return 0;
		}
		return curPage;
	}
	public void setCurPage(int curPage) {
		if(curPage>0){
			this.curPage = curPage;
		}
	}
}