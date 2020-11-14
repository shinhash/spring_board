package kr.or.ddit.reple.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.reple.vo.RepleVO;


@Repository("repleRepository")
public class RepleDao implements RepleDaoI {
	
	private static final Logger logger = LoggerFactory.getLogger(RepleDao.class);

	
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	
	
	
	@Override
	public List<RepleVO> selectRepleList(BoardVO boardVO) {
		return sqlSession.selectList("reple.selectRepleList", boardVO);
	}
	
	
	@Override
	public int insertReple(RepleVO repleVO) {
		return sqlSession.insert("reple.insertReple", repleVO);
	}
	

	@Override
	public int deleteReple(RepleVO repleVO) {
		return sqlSession.update("reple.deleteReple", repleVO);
	}
	

	@Override
	public int selectRepBoardId(int repleId) {
		return sqlSession.selectOne("reple.selectRepBoardId", repleId);
	}

	

	

}
