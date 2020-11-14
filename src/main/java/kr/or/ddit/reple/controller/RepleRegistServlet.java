package kr.or.ddit.reple.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reple.service.RepleService;
import kr.or.ddit.reple.service.RepleServiceI;
import kr.or.ddit.reple.vo.RepleVO;


@WebServlet("/repleRegist")
public class RepleRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private RepleServiceI repleService;
	@Override
	public void init() throws ServletException {
		repleService = new RepleService();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(RepleRegistServlet.class);


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug("댓글등록 시작");
		
		
		int boardSeq = Integer.parseInt(request.getParameter("boardSeq"));
		int boardKindId = Integer.parseInt(request.getParameter("boardKindId"));
		String userId = request.getParameter("userId");
		String repleContent = request.getParameter("repleContent");
		
		
		
		RepleVO repleVO = new RepleVO();
		repleVO.setBOARD_SEQ(boardSeq);
		repleVO.setBOARD_KIND_ID(boardKindId);
		repleVO.setUSERID(userId);
		repleVO.setREPLE_STATUS("Y");
		repleVO.setREPLE_CONTENT(repleContent);
		
		int insertRepleCnt = repleService.insertReple(repleVO);
		if(insertRepleCnt == 1) {
			response.sendRedirect(request.getContextPath() + "/boardInfo?boardId=" + boardSeq);
		}
	}

}
