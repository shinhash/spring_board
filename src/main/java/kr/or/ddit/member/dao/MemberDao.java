package kr.or.ddit.member.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.member.vo.MemberVO;

@Repository("memberRepository")
public class MemberDao implements MemberDaoI {

	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public MemberVO selectMember(String userid) {
		return sqlSession.selectOne("member.selectMember", userid);
	}
}
