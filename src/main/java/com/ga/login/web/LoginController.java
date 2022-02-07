package com.ga.login.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ga.login.service.impl.LoginService;
import com.ga.member.service.MemberVO;
import com.ga.util.SHA256Util;

@Controller
@RequestMapping("/login/*")
public class LoginController {
	@Inject
	LoginService loginService;
	 // 01. 로그인 화면 
    @RequestMapping("login.do")
    public String login(){
        return "member/login";    // views/member/login.jsp로 포워드
    }
    
 // 02. 로그인 처리
    @RequestMapping("loginCheck.do")
    public void loginCheck(@ModelAttribute MemberVO vo, HttpSession session, HttpServletResponse response) throws IOException{
    	String salt=loginService.getSaltById(vo);
    	String pwd=vo.getUserPw();
    	
    	pwd=SHA256Util.getEncrypt(pwd, salt);
    	vo.setUserPw(pwd);
    	boolean result = loginService.loginCheck(vo, session);
        if (result == true) { // 로그인 성공시 true 반환
        	response.getWriter().print(true) ;
        } else {    // 로그인 실패시 false 반환
        	response.getWriter().print(false) ;
        }
    }
 // 03. 로그아웃 처리
    @RequestMapping("logout.do")
    public ModelAndView logout(HttpSession session){
    	loginService.logout(session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/login");
        mav.addObject("msg", "logout");
        return mav;
    }
    
}
