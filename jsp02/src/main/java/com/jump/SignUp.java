package com.jump;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userPwCheck = request.getParameter("userPwCheck");
		String passwordQuestion = request.getParameter("passwordQuestion");
		String passwordQuestionCheck = request.getParameter("passwordQuestionCheck");
		String userName = request.getParameter("userName");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		String homeNumber = request.getParameter("homeNumber");
		String homeMidleNumber = request.getParameter("homeMidleNumber");
		String homeLastNumber = request.getParameter("homeLastNumber");
		String phoneNumber = request.getParameter("phoneNumber");
		String phoneMidleNumber = request.getParameter("phoneMidleNumber");
		String phoneLastNumber = request.getParameter("phoneLastNumber");
		String SMSCheck = request.getParameter("SMSCheck");
		String userEmail = request.getParameter("userEmail");
		String EmailCheck = request.getParameter("EmailCheck");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>????????? : " + userId+"</h1>");
		out.println("<h1>???????????? : " + userPw+"</h1>");
		out.println("<h1>???????????? ?????? : " + userPwCheck+"</h1>");
		out.println("<h1>???????????? ?????? ?????? : " + passwordQuestion+"</h1>");
		out.println("<h1>???????????? ?????? ?????? : " + passwordQuestionCheck+"</h1>");
		out.println("<h1>?????? : " + userName+"</h1>");
		out.println("<h1>?????? : " + "???????????? = " + address1+ "</h1>");
		out.println("<h1>???????????? = " + address2+ "</h1>");
		out.println("<h1>????????? ?????? = " + address3+ "</h1>");
		out.println("<h1>???????????? : " + homeNumber+"-"+homeMidleNumber+"-"+homeLastNumber+"</h1>");
		out.println("<h1>???????????? : " + phoneNumber+"-"+phoneMidleNumber+"-"+phoneLastNumber+"</h1>");
		if(SMSCheck==null) {
			out.println("<h1>SMS ???????????? : ??????</h1>");
		}else {
			out.println("<h1>SMS ???????????? : ??????</h1>");
		}
		out.println("<h1>?????????  : " + userEmail+"</h1>");
		if(EmailCheck == null) {
			out.println("<h1>SMS ???????????? : ??????</h1>");
		}else {
			out.println("<h1>????????? ???????????? : ??????</h1>");
		}
		
		
	}

}
