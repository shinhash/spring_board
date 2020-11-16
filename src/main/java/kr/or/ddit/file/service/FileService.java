package kr.or.ddit.file.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.file.dao.FileDaoI;
import kr.or.ddit.file.vo.FileVO;



@Service("fileService")
public class FileService implements FileServiceI {
	
	@Resource(name = "fileRepository")
	private FileDaoI fileDao;

	
	
	@Override
	public FileVO selectFileVO(int fileId) {
		return fileDao.selectFileVO(fileId);
	}

}
