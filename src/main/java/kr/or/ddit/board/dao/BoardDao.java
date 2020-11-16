package kr.or.ddit.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.vo.BoardKindVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.file.vo.FileVO;
import kr.or.ddit.page.PageVO;
import kr.or.ddit.reple.vo.RepleVO;



@Repository("boardRepository")
public class BoardDao implements BoardDaoI {

	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<BoardKindVO> selectAllBoardKind() {
		return sqlSession.selectList("board.selectAllBoardKind");
	}
	
	
	@Override
	public List<BoardKindVO> selectAddedBoardKind(String userid) {
		return sqlSession.selectList("board.selectAddedBoardKind", userid);
	}
	
	
	
	@Override
	public int insertBoardKind(BoardKindVO bkVO) {
		return sqlSession.insert("board.insertBoardKind", bkVO);
	}




	@Override
	public List<BoardVO> selectBoardPageList(PageVO pageVO) {
		return sqlSession.selectList("board.selectBoardPageList", pageVO);
	}


	@Override
	public int selectBoardTotal(int BOARD_KIND_ID) {
		return sqlSession.selectOne("board.selectBoardTotal", BOARD_KIND_ID);
	}


	
	@Override
	public int updateBoardKind(BoardKindVO bkVO) {
		return sqlSession.update("board.updateBoardKind", bkVO);
	}


	@Override
	public BoardVO selectBoardInfo(int boardSeq) {
		return sqlSession.selectOne("board.selectBoardInfo", boardSeq);
	}
	
	
	
	


	@Override
	public List<BoardVO> selectBoardGnVO(int boardPseqNum) {
		return sqlSession.selectList("board.selectBoardGnVO", boardPseqNum);
	}





	@Override
	public int insertBoard(BoardVO boardVO) {
		int insertUpdateCnt = 0;
		
		int insertCnt = sqlSession.insert("board.insertNewBoard", boardVO);
		
		if(insertCnt == 1) {
			insertUpdateCnt = sqlSession.update("board.updateNewInsertFile", boardVO);	
		}
		
		logger.debug("insertCnt : {}", insertCnt);
		logger.debug("insertUpdateCnt : {}", insertUpdateCnt);
		return insertUpdateCnt;
	}


	@Override
	public String selectBoardKindTitle(int boardKindId) {
		return sqlSession.selectOne("board.selectBoardKindTitle", boardKindId);
	}

	
	
	@Override
	public int insertBoardFile(FileVO fileVO) {
		return sqlSession.insert("board.insertBoardFile", fileVO);	
	}


	@Override
	public int selectBoardSeq() {
		return sqlSession.selectOne("board.selectBoardSeq");
	}


	@Override
	public List<FileVO> selectFileList(int boardSeq) {
		return sqlSession.selectList("board.selectFileList", boardSeq);
	}


	@Override
	public int updateBoardInfo(BoardVO updateBoardVO) {
		return sqlSession.update("board.updateBoardInfo", updateBoardVO);
	}


	@Override
	public int updateFileInfo(FileVO updatefileVO) {
		return sqlSession.update("board.updateFileInfo", updatefileVO);
	}


	@Override
	public int updateInsertFileInfo(FileVO insertFile) {
		return sqlSession.insert("board.insertBoardFile", insertFile);
	}


	@Override
	public int delBoardStatus(BoardVO boardVO) {
		return sqlSession.update("board.delBoardStatus", boardVO);
	}


	@Override
	public int selectFileSeq() {
		return sqlSession.selectOne("board.selectFileSeq");
	}



	
}
