package pojo;


public class Page {

	private int totalPageCount; // 总页数

	private int pageSize; // 每页显示记录数

	private int totalCount; // 记录总数

	private int currpageNo; // 当前页码

	

	public int getTotalPageCount() { // 总页数
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		if (totalCount == 0) {
			totalPageCount = 0;
		}
		this.totalPageCount = totalPageCount;
	}

	public int getPageSize() { // 每页显示记录数
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}

	}

	public int getTotalCount() { // 记录总数
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			// 计算总页数
			totalPageCount = this.totalCount % pageSize == 0 ? (this.totalCount / pageSize)
					: this.totalCount / pageSize + 1;
		}

	}

	public int getCurrpageNo() { // 当前页
		return currpageNo;
	}

	public void setCurrpageNo(int currpageNo) {
		if (currpageNo > 0) {
			this.currpageNo = currpageNo;
		}

	}

	

}
