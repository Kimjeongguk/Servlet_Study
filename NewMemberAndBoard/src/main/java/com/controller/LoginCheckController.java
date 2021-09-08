package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.memberandboard.model.MemberDao;
import com.memberandboard.model.MemberDto;

@WebServlet("/LoginCheck.do")
public class LoginCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginCheckController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html; charset=utf-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		PrintWriter out = response.getWriter();
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		MemberDto loggedMember = memberDao.getLoggedMember(memberDto);
		if(loggedMember != null){
			//session 내장객체는 jsp에 사용가능
			HttpSession session = request.getSession(); //servlet에서 session을 사용하려면
			session.setAttribute("loggedMember", loggedMember);
			
			out.println("<script>");
			out.println("alert('로그인 되었습니다.')");
			out.println("location.href='BoardList.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('로그인 실패하였습니다.')");
			out.println("history.back();");
			out.println("</script>");
		}
	}
}	
