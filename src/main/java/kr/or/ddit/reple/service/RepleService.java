package kr.or.ddit.reple.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.reple.dao.RepleDaoI;
import kr.or.ddit.reple.vo.RepleVO;


@Service("repleService")
public class RepleService implements RepleServiceI {
	
	private static final Logger logger = LoggerFactory.getLogger(RepleService.class);

	
	@Resource(name = "repleRepository")
	private RepleDaoI repleDao;
	
	
	
	@Override
	public List<RepleVO> selectRepleList(BoardVO boardVO) {
		return repleDao.selectRepleList(boardVO);
	}

	@Override
	public int insertReple(RepleVO repleVO) {
		return repleDao.insertReple(repleVO);
	}

	@Override
	public int deleteReple(int repleId) {
		
		
		RepleVO delRepVO = new RepleVO();
		delRepVO.setREPLE_SEQ(repleId);
		delRepVO.setREPLE_CONTENT("[삭제된 댓글입니다.]");
		delRepVO.setREPLE_STATUS("N");
		
		return repleDao.deleteReple(delRepVO);
	}

	@Override
	public int selectRepBoardId(int repleId) {
		return repleDao.selectRepBoardId(repleId);
	}

	

}
