package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.file.vo.FileVO;
import kr.or.ddit.member.vo.MemberVO;



@WebServlet("/boardUpdate")
@MultipartConfig
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(BoardUpdateServlet.class);
	private BoardServiceI boardService;
	private List<FileVO> fileList;
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardSeq = Integer.parseInt(request.getParameter("boardSeq"));
		BoardVO boardVO = boardService.selectBoardInfo(boardSeq);
		
		fileList = boardService.selectFileList(boardSeq);
		
		request.setAttribute("boardVO", boardVO);
		request.setAttribute("fileList", fileList);
		request.getRequestDispatcher("/pages/board/boardUpdate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String[] delFileIdList = request.getParameterValues("delFileIdInfo");
		
		int boardSeq = Integer.parseInt(request.getParameter("BOARD_SEQ"));
		String testboardSeq = request.getParameter("BOARD_SEQ");
		String boardTitle = request.getParameter("boardTitleName");
		
		
		
		logger.debug("delFileIdList : {}", delFileIdList);
		
		
		String editordata = request.getParameter("editordata");
		int boardKindId = Integer.parseInt(request.getParameter("BOARD_KIND_ID"));
	
		logger.debug("editordata : {}", editordata);
		
		MemberVO memVO = (MemberVO)request.getSession().getAttribute("MEMBER");
		
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBOARD_SEQ(boardSeq);
		boardVO.setBOARD_TITLE(boardTitle);
		boardVO.setBOARD_CONTENT(editordata);
		boardVO.setUSERID(memVO.getUserid());
		boardVO.setBOARD_KIND_ID(boardKindId);
		boardVO.setBOARD_STATUS("Y");
		
		
		
		// board update
		// 파일 리스트에서 삭제한것이 있는지 확인
		List<Integer> fileIdList = null;
		if(delFileIdList != null) {
			fileIdList = new ArrayList<Integer>();
			for(String fileInfoId : delFileIdList) {
				int delFileId = Integer.parseInt(fileInfoId);
				fileIdList.add(delFileId);
			}
		}
		
		
		// 파일을 추가했는지에 대한 여부 확인
		List<FileVO> insertFileList = null;
		FileVO insertFileVO = null;
		Collection<Part> parts = request.getParts();
		for(Part part : parts) {
			
			Part partTemp  = part;
			String partName = partTemp.getName();
			
			String fileRealName = "";
			
			if(partName.equals("fileInput")) {
				
				String attchHeader = partTemp.getHeader("Content-disposition");
				logger.debug("attchHeader : {}", attchHeader);
				
				String[] headerInfo = attchHeader.split("; ");
				
				for(String headerSplit : headerInfo) {
					
					String[] temp = headerSplit.split("=");
					
					if("filename".equals(temp[0])) {
						
						if(!"\"\"".equals(temp[1])) {
							
							fileRealName = temp[1].split("\"")[1];
								
							insertFileList = new ArrayList<FileVO>();
							
							// uuid
							String tempName = UUID.randomUUID().toString();
							
							// file 확장자
							String fileEx = FileUploadUtil.getExtension(fileRealName);
							
							// db에 저장할 파일의 경로와 파일의 이름 + 확장자
							String filename = "D:\\upload\\" + tempName + "." + fileEx;
							
							// 파일 업로드
							partTemp.write(filename);
							partTemp.delete();
							
							// 파일경로를 db에 저장
							insertFileVO = new FileVO();
							insertFileVO.setFILE_NAME(filename);
							insertFileVO.setREAL_FILE_NAME(fileRealName);
							insertFileVO.setBOARD_KIND_ID(boardKindId);
							insertFileVO.setBOARD_SEQ(boardSeq);
							insertFileVO.setFILE_STATUS("Y");
							
							insertFileList.add(insertFileVO);
						}
						
					}
				}
			}
			logger.debug("fileName : {}", fileRealName);
		}
		
		
		
		
		
		
		
		Map<String, Object> updateInfoMap = new HashMap<String, Object>();
		updateInfoMap.put("boardVO", boardVO);
		updateInfoMap.put("fileIdList", fileIdList);
		updateInfoMap.put("insertFileList", insertFileList);
		
		int updateBoardCnt = boardService.updateBoardInfo(updateInfoMap);
		
		if(updateBoardCnt == 1) {
			response.sendRedirect(request.getContextPath() + "/boardInfo?boardId=" + boardSeq);
		}else {
			doGet(request, response);
		}
		
	}

}
