package kr.or.ddit.reple.vo;

import java.util.Date;

public class RepleVO {
	
	private int BOARD_SEQ;
	private int REPLE_SEQ;
	private String REPLE_CONTENT;
	private Date REPLE_DT;
	private int BOARD_KIND_ID;
	private String REPLE_STATUS;
	private String USERID;
	
	
	public RepleVO() {
		
	}
	
	
	public RepleVO(int bOARD_SEQ, String rEPLE_CONTENT, int bOARD_KIND_ID, String rEPLE_STATUS,
			String uSERID) {
		BOARD_SEQ = bOARD_SEQ;
		REPLE_CONTENT = rEPLE_CONTENT;
		BOARD_KIND_ID = bOARD_KIND_ID;
		REPLE_STATUS = rEPLE_STATUS;
		USERID = uSERID;
	}



	public int getBOARD_SEQ() {
		return BOARD_SEQ;
	}
	public void setBOARD_SEQ(int bOARD_SEQ) {
		BOARD_SEQ = bOARD_SEQ;
	}
	public int getREPLE_SEQ() {
		return REPLE_SEQ;
	}
	public void setREPLE_SEQ(int rEPLE_SEQ) {
		REPLE_SEQ = rEPLE_SEQ;
	}
	public String getREPLE_CONTENT() {
		return REPLE_CONTENT;
	}
	public void setREPLE_CONTENT(String rEPLE_CONTENT) {
		REPLE_CONTENT = rEPLE_CONTENT;
	}
	public Date getREPLE_DT() {
		return REPLE_DT;
	}
	public void setREPLE_DT(Date rEPLE_DT) {
		REPLE_DT = rEPLE_DT;
	}
	public int getBOARD_KIND_ID() {
		return BOARD_KIND_ID;
	}
	public void setBOARD_KIND_ID(int bOARD_KIND_ID) {
		BOARD_KIND_ID = bOARD_KIND_ID;
	}
	public String getREPLE_STATUS() {
		return REPLE_STATUS;
	}
	public void setREPLE_STATUS(String rEPLE_STATUS) {
		REPLE_STATUS = rEPLE_STATUS;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + BOARD_KIND_ID;
		result = prime * result + BOARD_SEQ;
		result = prime * result + ((REPLE_CONTENT == null) ? 0 : REPLE_CONTENT.hashCode());
		result = prime * result + ((REPLE_DT == null) ? 0 : REPLE_DT.hashCode());
		result = prime * result + REPLE_SEQ;
		result = prime * result + ((REPLE_STATUS == null) ? 0 : REPLE_STATUS.hashCode());
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
		RepleVO other = (RepleVO) obj;
		if (BOARD_KIND_ID != other.BOARD_KIND_ID)
			return false;
		if (BOARD_SEQ != other.BOARD_SEQ)
			return false;
		if (REPLE_CONTENT == null) {
			if (other.REPLE_CONTENT != null)
				return false;
		} else if (!REPLE_CONTENT.equals(other.REPLE_CONTENT))
			return false;
		if (REPLE_DT == null) {
			if (other.REPLE_DT != null)
				return false;
		} else if (!REPLE_DT.equals(other.REPLE_DT))
			return false;
		if (REPLE_SEQ != other.REPLE_SEQ)
			return false;
		if (REPLE_STATUS == null) {
			if (other.REPLE_STATUS != null)
				return false;
		} else if (!REPLE_STATUS.equals(other.REPLE_STATUS))
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
		return "RepleVO [BOARD_SEQ=" + BOARD_SEQ + ", REPLE_SEQ=" + REPLE_SEQ 
				+ ", REPLE_CONTENT=" + REPLE_CONTENT + ", REPLE_DT=" + REPLE_DT + ", BOARD_KIND_ID=" + BOARD_KIND_ID
				+ ", REPLE_STATUS=" + REPLE_STATUS + ", USERID=" + USERID + "]";
	}
	
}
