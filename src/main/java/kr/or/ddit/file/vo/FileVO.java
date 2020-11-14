package kr.or.ddit.file.vo;


public class FileVO {
	
	private int FILE_SEQ;
	private String FILE_NAME;
	private String REAL_FILE_NAME;
	private int BOARD_KIND_ID;
	private int BOARD_SEQ;
	private String FILE_STATUS;
	

	public FileVO() {
		
	}
	public FileVO(String FILE_NAME, String REAL_FILE_NAME, int BOARD_KIND_ID, int BOARD_SEQ, String FILE_STATUS) {
		this.FILE_NAME = FILE_NAME;
		this.REAL_FILE_NAME = REAL_FILE_NAME;
		this.BOARD_KIND_ID = BOARD_KIND_ID;
		this.BOARD_SEQ = BOARD_SEQ;
		this.FILE_STATUS = FILE_STATUS;
	}
	
	
	
	
	
	
	public int getFILE_SEQ() {
		return FILE_SEQ;
	}
	public void setFILE_SEQ(int fILE_SEQ) {
		FILE_SEQ = fILE_SEQ;
	}
	public String getFILE_NAME() {
		return FILE_NAME;
	}
	public void setFILE_NAME(String fILE_NAME) {
		FILE_NAME = fILE_NAME;
	}
	public String getREAL_FILE_NAME() {
		return REAL_FILE_NAME;
	}
	public void setREAL_FILE_NAME(String rEAL_FILE_NAME) {
		REAL_FILE_NAME = rEAL_FILE_NAME;
	}
	public int getBOARD_KIND_ID() {
		return BOARD_KIND_ID;
	}
	public void setBOARD_KIND_ID(int bOARD_KIND_ID) {
		BOARD_KIND_ID = bOARD_KIND_ID;
	}
	public int getBOARD_SEQ() {
		return BOARD_SEQ;
	}
	public void setBOARD_SEQ(int bOARD_SEQ) {
		BOARD_SEQ = bOARD_SEQ;
	}
	public String getFILE_STATUS() {
		return FILE_STATUS;
	}
	public void setFILE_STATUS(String fILE_STATUS) {
		FILE_STATUS = fILE_STATUS;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + BOARD_KIND_ID;
		result = prime * result + BOARD_SEQ;
		result = prime * result + ((FILE_NAME == null) ? 0 : FILE_NAME.hashCode());
		result = prime * result + FILE_SEQ;
		result = prime * result + ((REAL_FILE_NAME == null) ? 0 : REAL_FILE_NAME.hashCode());
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
		FileVO other = (FileVO) obj;
		if (BOARD_KIND_ID != other.BOARD_KIND_ID)
			return false;
		if (BOARD_SEQ != other.BOARD_SEQ)
			return false;
		if (FILE_NAME == null) {
			if (other.FILE_NAME != null)
				return false;
		} else if (!FILE_NAME.equals(other.FILE_NAME))
			return false;
		if (FILE_SEQ != other.FILE_SEQ)
			return false;
		if (REAL_FILE_NAME == null) {
			if (other.REAL_FILE_NAME != null)
				return false;
		} else if (!REAL_FILE_NAME.equals(other.REAL_FILE_NAME))
			return false;
		return true;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "FileVO [FILE_SEQ=" + FILE_SEQ + ", FILE_NAME=" + FILE_NAME + ", REAL_FILE_NAME=" + REAL_FILE_NAME
				+ ", BOARD_KIND_ID=" + BOARD_KIND_ID + ", BOARD_SEQ=" + BOARD_SEQ + "]";
	}
	
	
	
	
	
	
}
