package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardKindVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.file.vo.FileVO;
import kr.or.ddit.page.PageVO;
import kr.or.ddit.reple.vo.RepleVO;

public interface BoardDaoI {

	List<BoardKindVO> selectAllBoardKind();
	
	List<BoardKindVO> selectAddedBoardKind(String userid);	
	
	int insertBoardKind(BoardKindVO bkVO);
	
	String selectBoardKindTitle(int boardKindId);
	
	List<BoardVO> selectBoardPageList(PageVO pageVO);
	
	int selectBoardTotal(int BOARD_KIND_ID);
	
	int updateBoardKind(BoardKindVO bkVO);
	
	BoardVO selectBoardInfo(int boardSeq);
	
	List<BoardVO> selectBoardGnVO(int boardPseqNum);
	
	List<FileVO> selectFileList(int boardSeq);
	
	int insertBoard(BoardVO boardVO);
	
	int insertBoardFile(FileVO fileVO);
	
	int selectBoardSeq();
	
	int updateBoardInfo(BoardVO updateBoardVO);
	
	int updateFileInfo(FileVO updatefileVO);
	
	int updateInsertFileInfo(FileVO insertFile);
	
	int delBoardStatus(BoardVO boardVO);
	
}
