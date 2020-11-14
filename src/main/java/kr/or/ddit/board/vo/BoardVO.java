package kr.or.ddit.board.vo;

import java.util.Date;

public class BoardVO {

	
	private int BOARD_SEQ;
	private String BOARD_TITLE;
	private String BOARD_CONTENT;
	private int BOARD_PSEQ;
	private int BOARD_GN;
	private String USERID;
	private Date BOARD_DATE;
	private int BOARD_KIND_ID;
	private String BOARD_STATUS;
	private int BOARD_RN;
	
	
	
	
	
	public int getBOARD_SEQ() {
		return BOARD_SEQ;
	}
	public void setBOARD_SEQ(int bOARD_SEQ) {
		BOARD_SEQ = bOARD_SEQ;
	}
	public String getBOARD_TITLE() {
		return BOARD_TITLE;
	}
	public void setBOARD_TITLE(String bOARD_TITLE) {
		BOARD_TITLE = bOARD_TITLE;
	}
	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}
	public void setBOARD_CONTENT(String bOARD_CONTENT) {
		BOARD_CONTENT = bOARD_CONTENT;
	}
	public int getBOARD_PSEQ() {
		return BOARD_PSEQ;
	}
	public void setBOARD_PSEQ(int bOARD_PSEQ) {
		BOARD_PSEQ = bOARD_PSEQ;
	}
	public int getBOARD_GN() {
		return BOARD_GN;
	}
	public void setBOARD_GN(int bOARD_GN) {
		BOARD_GN = bOARD_GN;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public Date getBOARD_DATE() {
		return BOARD_DATE;
	}
	public void setBOARD_DATE(Date bOARD_DATE) {
		BOARD_DATE = bOARD_DATE;
	}
	public int getBOARD_KIND_ID() {
		return BOARD_KIND_ID;
	}
	public void setBOARD_KIND_ID(int bOARD_KIND_ID) {
		BOARD_KIND_ID = bOARD_KIND_ID;
	}
	public String getBOARD_STATUS() {
		return BOARD_STATUS;
	}
	public void setBOARD_STATUS(String bOARD_STATUS) {
		BOARD_STATUS = bOARD_STATUS;
	}
	public int getBOARD_RN() {
		return BOARD_RN;
	}
	public void setBOARD_RN(int bOARD_RN) {
		BOARD_RN = bOARD_RN;
	}
	
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BOARD_CONTENT == null) ? 0 : BOARD_CONTENT.hashCode());
		result = prime * result + ((BOARD_DATE == null) ? 0 : BOARD_DATE.hashCode());
		result = prime * result + BOARD_GN;
		result = prime * result + BOARD_KIND_ID;
		result = prime * result + BOARD_PSEQ;
		result = prime * result + BOARD_SEQ;
		result = prime * result + ((BOARD_STATUS == null) ? 0 : BOARD_STATUS.hashCode());
		result = prime * result + ((BOARD_TITLE == null) ? 0 : BOARD_TITLE.hashCode());
		result = prime * result + ((USERID == null) ? 0 : USERID.hashCode());
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
		BoardVO other = (BoardVO) obj;
		if (BOARD_CONTENT == null) {
			if (other.BOARD_CONTENT != null)
				return false;
		} else if (!BOARD_CONTENT.equals(other.BOARD_CONTENT))
			return false;
		if (BOARD_DATE == null) {
			if (other.BOARD_DATE != null)
				return false;
		} else if (!BOARD_DATE.equals(other.BOARD_DATE))
			return false;
		if (BOARD_GN != other.BOARD_GN)
			return false;
		if (BOARD_KIND_ID != other.BOARD_KIND_ID)
			return false;
		if (BOARD_PSEQ != other.BOARD_PSEQ)
			return false;
		if (BOARD_SEQ != other.BOARD_SEQ)
			return false;
		if (BOARD_STATUS == null) {
			if (other.BOARD_STATUS != null)
				return false;
		} else if (!BOARD_STATUS.equals(other.BOARD_STATUS))
			return false;
		if (BOARD_TITLE == null) {
			if (other.BOARD_TITLE != null)
				return false;
		} else if (!BOARD_TITLE.equals(other.BOARD_TITLE))
			return false;
		if (USERID == null) {
			if (other.USERID != null)
				return false;
		} else if (!USERID.equals(other.USERID))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "BoardVO [BOARD_SEQ=" + BOARD_SEQ + ", BOARD_TITLE=" + BOARD_TITLE + ", BOARD_CONTENT=" + BOARD_CONTENT
				+ ", BOARD_PSEQ=" + BOARD_PSEQ + ", BOARD_GN=" + BOARD_GN + ", USERID=" + USERID + ", BOARD_DATE="
				+ BOARD_DATE + ", BOARD_KIND_ID=" + BOARD_KIND_ID + ", BOARD_STATUS=" + BOARD_STATUS + ", BOARD_RN="
				+ BOARD_RN + "]";
	}
	
}
