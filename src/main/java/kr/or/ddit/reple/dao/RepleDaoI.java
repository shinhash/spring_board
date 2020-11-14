package kr.or.ddit.reple.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.reple.vo.RepleVO;

public interface RepleDaoI {
	
	int insertReple(RepleVO repleVO);
	
	List<RepleVO> selectRepleList(BoardVO boardVO);
	
	int deleteReple(RepleVO repleVO);
	
	int selectRepBoardId(int repleId);
	
}