package kr.or.ddit.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.vo.BoardKindVO;


public class BoardKindSessionInterceptor extends HandlerInterceptorAdapter{

	@Resource(name = "boardService")
	private BoardServiceI boardService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 사용자가 정상적으로 접속 했는지 체크
		// LoginController를 통해 정삭적으로 접속 했을 경우
		// Session에 S_MEMBER 속성이 존재해야함
		HttpSession session = request.getSession();
		List<BoardKindVO> bkList = boardService.selectAllBoardKind();
		session.setAttribute("bkList", bkList);
		return true;
	}
}
