package com.ga.login.service.impl;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ga.member.service.MemberVO;
@Service
public class LoginServiceImpl implements LoginService{
	
	 //LoginDAOImpl 객체를 스프링에서 생성하여 주입시킴
	 @Inject
	 LoginDAOImpl loginDao;
	 
	//01_01. 회원 로그인체크
	 @Override
	 public boolean loginCheck(MemberVO vo, HttpSession session) {
	     boolean result = loginDao.loginCheck(vo);
	     if (result) { // true일 경우 세션에 등록
	         MemberVO vo2 = viewMember(vo);
	         // 세션 변수 등록
	         session.setAttribute("userId", vo2.getUserId());
	         session.setAttribute("userName", vo2.getUserName());
	     } 
	     return result;
	 }
	 // 01_02. 회원 로그인 정보
	 @Override
	 public MemberVO viewMember(MemberVO vo) {
	     return loginDao.viewMember(vo);
	 }
	 // 02. 회원 로그아웃
	 @Override
	 public void logout(HttpSession session) {
	     // 세션 변수 개별 삭제
	     // session.removeAttribute("userId");
	     // 세션 정보를 초기화 시킴
	     session.invalidate();
	 }

}
