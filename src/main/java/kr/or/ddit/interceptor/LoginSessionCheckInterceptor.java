package kr.or.ddit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.ddit.member.vo.MemberVO;


public class LoginSessionCheckInterceptor extends HandlerInterceptorAdapter{

	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 사용자가 정상적으로 접속 했는지 체크
		// LoginController를 통해 정삭적으로 접속 했을 경우
		// Session에 S_MEMBER 속성이 존재해야함
		HttpSession session = request.getSession();
		MemberVO memVO = (MemberVO) session.getAttribute("MEMBER");
		
		// 로그인 페이지로 이동
		if(memVO == null) {
			response.sendRedirect(request.getContextPath() + "/login/view");
			return false;
		}
		return true;
	}
}
