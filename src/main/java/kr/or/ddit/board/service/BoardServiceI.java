package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardKindVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.file.vo.FileVO;
import kr.or.ddit.reple.vo.RepleVO;

public interface BoardServiceI {

	List<BoardKindVO> selectAllBoardKind();
	
	List<BoardKindVO> selectAddedBoardKind(String userid);	
	
	int insertBoardKind(BoardKindVO bkVO);
	
	Map<String, Object> selectBoardPageList(int boardKindId, int pageNum, int pageSize);
	
	int updateBoardKind(BoardKindVO bkVO);
	
	BoardVO selectBoardInfo(int boardSeq);
	
	BoardVO selectBoardGnVO(int boardPseqNum);
	
	List<FileVO> selectFileList(int boardSeq);
	
	int insertBoard(BoardVO boardVO);
	
	int insertBoardFile(FileVO fileVO);
	
	int selectBoardSeq();
	
	int updateBoardInfo(Map<String, Object> updateInfoMap);
	
	int delBoardStatus(BoardVO boardVO);
	
}
