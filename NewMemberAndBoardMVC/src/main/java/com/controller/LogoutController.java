package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.memberandboard.model.MemberDto;

@WebServlet("/Logout.do")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); 
		MemberDto loggedMember = (MemberDto)session.getAttribute("loggedMember");
		
		out.println("<script>");
		out.println("alert('"+loggedMember.getName()+"님 안녕히 가세요')");
		out.println("location.href='BoardList.do'");
		out.println("</script>");
		session.invalidate();
	
	}

}
