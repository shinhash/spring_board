package kr.or.ddit.board.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Part;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.vo.BoardKindVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.file.vo.FileVO;
import kr.or.ddit.page.PageVO;
import kr.or.ddit.reple.vo.RepleVO;



@Service("boardService")
public class BoardService implements BoardServiceI {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

	@Resource(name = "boardRepository")
	private BoardDaoI boardDao;
	

	@Override
	public List<BoardKindVO> selectAllBoardKind() {
		return boardDao.selectAllBoardKind();
	}
	
	@Override
	public List<BoardKindVO> selectAddedBoardKind(String userid) {
		return boardDao.selectAddedBoardKind(userid);
	}

	

	@Override
	public int insertBoardKind(BoardKindVO bkVO) {
		return boardDao.insertBoardKind(bkVO);
	}


	@Override
	public Map<String, Object> selectBoardPageList(int boardKindId, int pageNum, int pageSize) {
		
		Map<String, Object> boardInfoMap = new HashMap<String, Object>();
		
		
		String boardKindTitle = boardDao.selectBoardKindTitle(boardKindId);
		logger.debug("service => boardKindTitle : {}", boardKindTitle);
		
		
		
		// 리스트 전체 길이
		int totalCnt = boardDao.selectBoardTotal(boardKindId);			

		
		PageVO pageVO = new PageVO(pageNum, pageSize, boardKindId);
		logger.debug("BOARD_KIND_ID : {}", boardKindId);
		
		
		// 계층, 페이징 처리된 리스트
		List<BoardVO> boardList = boardDao.selectBoardPageList(pageVO);
		
		// 페이지 정보
		int pageCnt = (int)(Math.ceil(totalCnt / (float)pageVO.getPageSize()));
		
		boardInfoMap.put("pageCnt", pageCnt);
		boardInfoMap.put("boardList", boardList);
		boardInfoMap.put("boardKindTitle", boardKindTitle);
		
		return boardInfoMap;
	}


	@Override
	public int updateBoardKind(BoardKindVO bkVO) {
		return boardDao.updateBoardKind(bkVO);
	}


	@Override
	public BoardVO selectBoardInfo(int boardSeq) {
		return boardDao.selectBoardInfo(boardSeq);
	}


	@Override
	public int insertBoard(BoardVO boardVO) {
		return boardDao.insertBoard(boardVO);
	}
	
	
	@Override
	public BoardVO selectBoardGnVO(int boardPseqNum) {
		
		List<BoardVO> boardList = boardDao.selectBoardGnVO(boardPseqNum);
		BoardVO boardVO = null;
		if(boardList != null && boardList.size() > 0) {
			boardVO = boardList.get(0);
		}else{
			boardVO = new BoardVO();
		}
		return boardVO;
	}

	


	@Override
	public int insertBoardFile(FileVO fileVO) {
		fileVO.setFILE_SEQ(boardDao.selectFileSeq());
		return boardDao.insertBoardFile(fileVO);
	}


	@Override
	public int selectBoardSeq() {
		return boardDao.selectBoardSeq();
	}


	@Override
	public List<FileVO> selectFileList(int boardSeq) {
		return boardDao.selectFileList(boardSeq);
	}


	@Override
	public int updateBoardInfo(Map<String, Object> updateInfoMap) {
		
		BoardVO updateBoardVO = (BoardVO) updateInfoMap.get("boardVO");
		List<Integer> delFileIdList = (List<Integer>) updateInfoMap.get("fileIdList");
		List<FileVO> insertFileList = (List<FileVO>) updateInfoMap.get("insertFileList");
		
		int updateBoardCnt = boardDao.updateBoardInfo(updateBoardVO);
		int updateFileInfoCnt = 0;
		
		int insertFileInfoCnt = 0;
		
		int updateResult = 0;
		if(updateBoardCnt == 1) {
			
			// 파일 수정
			if(delFileIdList != null) {
				for(int fileId : delFileIdList) {
					FileVO updateFileVO = new FileVO();
					updateFileVO.setFILE_SEQ(fileId);
					updateFileVO.setFILE_STATUS("N");
					
					updateFileInfoCnt = boardDao.updateFileInfo(updateFileVO);
				}
			}else {
				delFileIdList = new ArrayList<Integer>();
			}
			
			// 파일 추가
			if(insertFileList != null) {
				logger.debug("insertFileList length : {}", insertFileList.size());
				for(FileVO insertFile : insertFileList) {
					
					logger.debug("file name : {}", insertFile.getREAL_FILE_NAME());
					
					int fileSeq = boardDao.selectFileSeq();
					insertFile.setFILE_SEQ(fileSeq);
					insertFileInfoCnt = boardDao.updateInsertFileInfo(insertFile);
					
					logger.debug("file insert 완료");
				}
			}else {
				insertFileList = new ArrayList<FileVO>();
			}
		}
		
		
		return updateBoardCnt;
	}


	@Override
	public int delBoardStatus(BoardVO boardVO) {
		return boardDao.delBoardStatus(boardVO);
	}




}
