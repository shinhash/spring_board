package kr.or.ddit.file.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.file.vo.FileVO;


@Repository("fileRepository")
public class FileDao implements FileDaoI {

	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public FileVO selectFileVO(int fileId) {
		return sqlSession.selectOne("file.selectFileVO", fileId);
	}

}
