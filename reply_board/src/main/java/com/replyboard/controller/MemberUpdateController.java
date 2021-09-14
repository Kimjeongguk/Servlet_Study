package com.replyboard.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.replyboard.model.MemberDao;
import com.replyboard.model.MemberDto;

@WebServlet("/MemberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html; charset=utf-8");
	   
	   PrintWriter out = response.getWriter();
	   
	   String userId = request.getParameter("userId");
	   String userPw = request.getParameter("userPw");
	   String userName = request.getParameter("userName");
	   int zipcode = Integer.parseInt(request.getParameter("zipcode"));
	   String address = request.getParameter("address01") + " " + request.getParameter("address02");
	   String phone = request.getParameter("phoneNumber") + request.getParameter("phoneMiddleNumber")+request.getParameter("phoneLastNumber");
	   String userEmail = request.getParameter("userEmail");
	   
	   MemberDao memberDao = new MemberDao();
	   MemberDto memberDto = new MemberDto();
	   
	   memberDto.setId(userId);
	   memberDto.setPassword(userPw);
	   memberDto.setName(userName);
	   memberDto.setZipcode(zipcode);
	   memberDto.setAddress(address);
	   memberDto.setHp(phone);
	   memberDto.setEmail(userEmail);
	   int result = memberDao.updateMember(memberDto);
		if(result > 0) {
			 MemberDto loggedMember = memberDao.getLoggedMember(memberDto);
			 HttpSession session = request.getSession();  
			 session.setAttribute("loggedMember", loggedMember);
		
			out.println("<script>");
			out.println("alert('수정완료')");
			out.println("location.href='MemberList.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원수정 실패하였습니다.')");
			out.println("history.back();");
			out.println("</script>");
		}
	}
}
