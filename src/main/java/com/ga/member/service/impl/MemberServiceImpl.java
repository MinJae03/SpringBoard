package com.ga.member.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ga.member.service.MemberVO;

//현재 클래스를 스프링에서 관리하는 service bean으로 등록
@Service
public class MemberServiceImpl implements MemberService {
 
 // MemberDAOImpl 객체를 스프링에서 생성하여 주입시킴
 @Inject
 MemberDAOImpl memberDao;
 
 @Override
 public List<MemberVO> memberList() throws Exception{
     return memberDao.memberList();
 }

//02. 회원 등록
 @Override
 public void insertMember(MemberVO vo) {
     memberDao.insertMember(vo);
 }

 @Override
 public MemberVO viewMember() throws Exception{
     return null;
 }

 @Override
 public void deleteMember(String userId) throws Exception{
     
 }

 @Override
 public void updateMember(MemberVO vo) throws Exception{
     
 }
}
