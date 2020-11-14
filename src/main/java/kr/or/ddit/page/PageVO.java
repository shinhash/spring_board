package kr.or.ddit.page;

public class PageVO {
	
	private int pageNum;
	private int pageSize;
	private int boardKindId;
	
	
	
	public PageVO() {}
	public PageVO(int pageNum, int pageSize, int boardKindId) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.boardKindId = boardKindId;
	}
	
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getBoardKindId() {
		return boardKindId;
	}
	public void setBoardKindId(int boardKindId) {
		this.boardKindId = boardKindId;
	}
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardKindId;
		result = prime * result + pageNum;
		result = prime * result + pageSize;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageVO other = (PageVO) obj;
		if (boardKindId != other.boardKindId)
			return false;
		if (pageNum != other.pageNum)
			return false;
		if (pageSize != other.pageSize)
			return false;
		return true;
	}
	
	
	
	
	@Override
	public String toString() {
		return "PageVO [pageNum=" + pageNum + ", pageSize=" + pageSize + ", boardKindId=" + boardKindId + "]";
	}

}
