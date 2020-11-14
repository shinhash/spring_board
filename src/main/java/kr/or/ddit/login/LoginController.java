package kr.or.ddit.login;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.vo.BoardKindVO;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.member.vo.MemberVO;



@RequestMapping("/login")
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	

	@Resource(name = "memberService")
	private MemberServiceI memService;
	
	@Resource(name = "boardService")
	private BoardServiceI boardService;
	
	
	
	
	
	@RequestMapping("/view")
	public String loginView() {
		return "login/view";
	}
	
	
	
	@RequestMapping("/check")
	public String loginCheck(MemberVO memVO, HttpSession session) {
		
		logger.debug("member : {}", memVO);
		
		MemberVO dbMember = memService.selectMember(memVO.getUserid());
		
		if(dbMember != null && memVO.getPass().equals(dbMember.getPass())) {
			
			List<BoardKindVO> bkList = boardService.selectAllBoardKind();
			
			session.setAttribute("bkList", bkList);
			session.setAttribute("MEMBER", dbMember);
			return "tiles/layout/main_content";
			
		}else {
			return "redirect:/login/view";
		}
		
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
