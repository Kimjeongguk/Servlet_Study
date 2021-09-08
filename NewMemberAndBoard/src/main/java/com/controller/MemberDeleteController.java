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

@WebServlet("/MemberDelete.do")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDeleteController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;"); 
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		MemberDto loggedMember = (MemberDto)session.getAttribute("loggedMember");
		String userPw = request.getParameter("userPw"); 
		
		MemberDao memberDao = new MemberDao();

		int result = memberDao.deleteMember(loggedMember.getId(), userPw);
		if(result > 0) {
			session.invalidate();
			out.println("<script>");
			out.println("alert('회원탈퇴 되었습니다.')");
			out.println("location.href='MemberList.do'");
			out.println("</script>");
		}else {
			
			
			out.println("<script>");
			out.println("alert('실패하였습니다.')");
			out.println("history.back();");
			out.println("</script>");
		} 

	}

}
