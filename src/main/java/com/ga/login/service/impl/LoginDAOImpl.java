package com.ga.login.service.impl;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ga.member.service.MemberVO;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@Inject
	SqlSession sqlSession;
	 // 01_01. 회원 로그인체크
    @Override
    public boolean loginCheck(MemberVO vo) {
        String name = sqlSession.selectOne("member.loginCheck", vo);
        return (name == null) ? false : true;
    }
    // 01_02. 회원 로그인 정보
    @Override
    public MemberVO viewMember(MemberVO vo) {
        return sqlSession.selectOne("member.viewMember", vo);
    }
    // 02. 회원 로그아웃
    @Override
    public void logout(HttpSession session) {
    }
	@Override
	public String getSaltById(MemberVO vo) {
		return sqlSession.selectOne("member.getSaltById",vo);
	}
}
