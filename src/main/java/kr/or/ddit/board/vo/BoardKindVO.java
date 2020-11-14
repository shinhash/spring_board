package kr.or.ddit.board.vo;

import java.util.Date;

public class BoardKindVO {

	
	private int BOARD_KIND_ID;
	private String BOARD_KIND_TITLE;
	private String BOARD_KIND_STATUS;
	private String BOARD_KIND_CREATOR;
	private Date BOARD_KIND_DT;
	
	
	
	public BoardKindVO() {

	}
	
	
	public BoardKindVO(String BOARD_KIND_TITLE, String BOARD_KIND_STATUS, String BOARD_KIND_CREATOR) {
		this.BOARD_KIND_TITLE = BOARD_KIND_TITLE;
		this.BOARD_KIND_STATUS = BOARD_KIND_STATUS;
		this.BOARD_KIND_CREATOR = BOARD_KIND_CREATOR;
	}





	public int getBOARD_KIND_ID() {
		return BOARD_KIND_ID;
	}
	public void setBOARD_KIND_ID(int bOARD_KIND_ID) {
		BOARD_KIND_ID = bOARD_KIND_ID;
	}
	public String getBOARD_KIND_TITLE() {
		return BOARD_KIND_TITLE;
	}
	public void setBOARD_KIND_TITLE(String bOARD_KIND_TITLE) {
		BOARD_KIND_TITLE = bOARD_KIND_TITLE;
	}
	public String getBOARD_KIND_STATUS() {
		return BOARD_KIND_STATUS;
	}
	public void setBOARD_KIND_STATUS(String bOARD_KIND_STATUS) {
		BOARD_KIND_STATUS = bOARD_KIND_STATUS;
	}
	public String getBOARD_KIND_CREATOR() {
		return BOARD_KIND_CREATOR;
	}
	public void setBOARD_KIND_CREATOR(String bOARD_KIND_CREATOR) {
		BOARD_KIND_CREATOR = bOARD_KIND_CREATOR;
	}
	public Date getBOARD_KIND_DT() {
		return BOARD_KIND_DT;
	}
	public void setBOARD_KIND_DT(Date bOARD_KIND_DT) {
		BOARD_KIND_DT = bOARD_KIND_DT;
	}
	
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BOARD_KIND_CREATOR == null) ? 0 : BOARD_KIND_CREATOR.hashCode());
		result = prime * result + ((BOARD_KIND_DT == null) ? 0 : BOARD_KIND_DT.hashCode());
		result = prime * result + BOARD_KIND_ID;
		result = prime * result + ((BOARD_KIND_STATUS == null) ? 0 : BOARD_KIND_STATUS.hashCode());
		result = prime * result + ((BOARD_KIND_TITLE == null) ? 0 : BOARD_KIND_TITLE.hashCode());
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
		BoardKindVO other = (BoardKindVO) obj;
		if (BOARD_KIND_CREATOR == null) {
			if (other.BOARD_KIND_CREATOR != null)
				return false;
		} else if (!BOARD_KIND_CREATOR.equals(other.BOARD_KIND_CREATOR))
			return false;
		if (BOARD_KIND_DT == null) {
			if (other.BOARD_KIND_DT != null)
				return false;
		} else if (!BOARD_KIND_DT.equals(other.BOARD_KIND_DT))
			return false;
		if (BOARD_KIND_ID != other.BOARD_KIND_ID)
			return false;
		if (BOARD_KIND_STATUS == null) {
			if (other.BOARD_KIND_STATUS != null)
				return false;
		} else if (!BOARD_KIND_STATUS.equals(other.BOARD_KIND_STATUS))
			return false;
		if (BOARD_KIND_TITLE == null) {
			if (other.BOARD_KIND_TITLE != null)
				return false;
		} else if (!BOARD_KIND_TITLE.equals(other.BOARD_KIND_TITLE))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "BoardKindVO [BOARD_KIND_ID=" + BOARD_KIND_ID + ", BOARD_KIND_TITLE=" + BOARD_KIND_TITLE
				+ ", BOARD_KIND_STATUS=" + BOARD_KIND_STATUS + ", BOARD_KIND_CREATOR=" + BOARD_KIND_CREATOR
				+ ", BOARD_KIND_DT=" + BOARD_KIND_DT + "]";
	}

	
}
