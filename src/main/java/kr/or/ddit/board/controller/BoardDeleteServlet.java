package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.vo.BoardVO;


@WebServlet("/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardServiceI boardService;
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardSeq = Integer.parseInt(request.getParameter("boardSeq"));
		int boardKindId = Integer.parseInt(request.getParameter("boardKindId"));
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBOARD_SEQ(boardSeq);
		boardVO.setBOARD_STATUS("N");
		boardVO.setBOARD_TITLE("[삭제된 게시글 입니다.]");
		int delBoardCnt = boardService.delBoardStatus(boardVO);
		
		if(delBoardCnt == 1) {
			response.sendRedirect(request.getContextPath() + "/boardListPage?boardKindId=" + boardKindId);
		}else {
			response.sendRedirect(request.getContextPath() + "/boardListPage?boardKindId=" + boardKindId);			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
