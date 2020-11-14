package kr.or.ddit.reple.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.reple.vo.RepleVO;

public interface RepleServiceI {
	
	int insertReple(RepleVO repleVO);
	
	List<RepleVO> selectRepleList(BoardVO boardVO);
	
	int deleteReple(int repleId);
	
	int selectRepBoardId(int repleId);
	
}
