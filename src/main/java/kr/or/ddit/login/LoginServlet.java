package kr.or.ddit.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.vo.BoardKindVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.member.vo.MemberVO;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	private MemberServiceI memService;
	private BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		memService = new MemberService();
		boardService = new BoardService();
	}
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String userid = request.getParameter("userid");
//		String pass = request.getParameter("pass");
//		
//		MemberVO member = memService.selectMember(userid);
//		
//		if(member == null || !pass.equals(member.getPass())) {
//			request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
//			
//		}else if(pass.equals(member.getPass())) {
//			SqlSession sqlSession = MybatisUtil.getSqlSession();
//			List<BoardKindVO> bkList = boardService.selectAllBoardKind(sqlSession);
//			sqlSession.close(); 
//			
//			request.getSession().setAttribute("bkList", bkList);
//			request.getSession().setAttribute("MEMBER", member);
//			response.sendRedirect(request.getContextPath() + "/pages/main/main.jsp");
//		}
		
		
	}

}
