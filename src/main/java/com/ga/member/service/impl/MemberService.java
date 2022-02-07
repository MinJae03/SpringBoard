package com.ga.member.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ga.member.service.MemberVO;

public interface MemberService {
    // 회원 목록 
    public List<MemberVO> memberList() throws Exception;
    // 회원 입력
    public void insertMember(MemberVO vo) throws Exception;
    // 회원 정보 상세보기
    public MemberVO viewMember() throws Exception;
    // 회원삭제
    public void deleteMember(String userId) throws Exception;
    // 회원정보 수정
    public void updateMember(MemberVO vo) throws Exception;

}
