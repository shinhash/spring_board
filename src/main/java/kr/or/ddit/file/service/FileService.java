package kr.or.ddit.file.service;

import kr.or.ddit.file.dao.FileDao;
import kr.or.ddit.file.dao.FileDaoI;
import kr.or.ddit.file.vo.FileVO;

public class FileService implements FileServiceI {
	
	
	private FileDaoI fileDao;
	public FileService() {
		fileDao = new FileDao();
	}

	@Override
	public FileVO selectFileVO(int fileId) {
		return fileDao.selectFileVO(fileId);
	}

}
