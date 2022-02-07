package com.ga.login.service.impl;

import javax.servlet.http.HttpSession;

import com.ga.member.service.MemberVO;

public interface LoginDAO {
	 // 01_01. 회원 로그인 체크
    public boolean loginCheck(MemberVO vo);
    // 01_02. 회원 로그인 정보
    public MemberVO viewMember(MemberVO vo);
    // 02. 회원 로그아웃
    public void logout(HttpSession session);
    //salt값 가져오기
    public String getSaltById(MemberVO vo);
}
