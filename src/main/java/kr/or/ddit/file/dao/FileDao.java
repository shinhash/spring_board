package kr.or.ddit.file.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.file.vo.FileVO;

public class FileDao implements FileDaoI {

	
	
	@Override
	public FileVO selectFileVO(int fileId) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		FileVO fileVO = sqlSession.selectOne("file.selectFileVO", fileId);
		sqlSession.close();
		return fileVO;
	}

}
