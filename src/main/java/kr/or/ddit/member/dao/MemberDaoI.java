package kr.or.ddit.member.dao;

import kr.or.ddit.member.vo.MemberVO;

public interface MemberDaoI {
	
	MemberVO selectMember(String userid);

}
