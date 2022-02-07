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
        boolean result = loginService.loginCheck(vo, session);
        ModelAndView mav = new ModelAndView();
        if (result == true) { // 로그인 성공
        	response.getWriter().print(true) ;
        } else {    // 로그인 실패
            // login.jsp로 이동
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
