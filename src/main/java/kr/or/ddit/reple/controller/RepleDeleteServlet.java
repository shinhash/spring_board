package kr.or.ddit.reple.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reple.service.RepleService;
import kr.or.ddit.reple.service.RepleServiceI;
import kr.or.ddit.reple.vo.RepleVO;


@WebServlet("/repleDelete")
public class RepleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RepleServiceI repleService;
	@Override
	public void init() throws ServletException {
		repleService = new RepleService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int repleId = Integer.parseInt(request.getParameter("repleId"));
		
		int delReple = repleService.deleteReple(repleId);
		
		if(delReple == 1) {
			int boardSeq = repleService.selectRepBoardId(repleId);
			response.sendRedirect(request.getContextPath() + "/boardInfo?boardId=" + boardSeq);
		}else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
