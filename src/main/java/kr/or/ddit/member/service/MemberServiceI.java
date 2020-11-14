package kr.or.ddit.member.service;

import kr.or.ddit.member.vo.MemberVO;

public interface MemberServiceI {

	MemberVO selectMember(String userid);
	
}
