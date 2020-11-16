package kr.or.ddit.reple.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.reple.service.RepleServiceI;
import kr.or.ddit.reple.vo.RepleVO;


@RequestMapping("/reple")
@Controller
public class RepleController {
	
	@Resource(name = "repleService")
	private RepleServiceI repleService;
	
	
	
	
	
	@RequestMapping("/regist")
	public String repleRegist(HttpSession session, int boardSeq, int boardKindId, String repleContent) {
		
		MemberVO member = (MemberVO) session.getAttribute("MEMBER");
		
		RepleVO repleVO = new RepleVO();
		repleVO.setBOARD_SEQ(boardSeq);
		repleVO.setBOARD_KIND_ID(boardKindId);
		repleVO.setUSERID(member.getUserid());
		repleVO.setREPLE_STATUS("Y");
		repleVO.setREPLE_CONTENT(repleContent);
		
		
		int insertRepleCnt = repleService.insertReple(repleVO);
		
		String path = "redirect:/board/boardInfo?boardSeq="+boardSeq;
		return path;
	}
	
	
	
	
	
	
	
	@RequestMapping("/delete")
	public String repleDelete(int repleId) {
		
		int delReple = repleService.deleteReple(repleId);
		
		
		int boardSeq = repleService.selectRepBoardId(repleId);
		String path = "redirect:/board/boardInfo?boardSeq="+boardSeq;
		return path;
	}
	
	
	
	
}
