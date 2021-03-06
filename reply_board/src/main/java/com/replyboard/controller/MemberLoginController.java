package com.replyboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.replyboard.model.MemberDao;
import com.replyboard.model.MemberDto;
import com.replyboard.utils.ScriptWriterUtil;

@WebServlet("/MemberLogin.do")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		MemberDao memberDao = new MemberDao();
		MemberDto loggedMember = memberDao.getLoggedMember(memberDto);
		
		if(loggedMember != null){
			HttpSession session = request.getSession(); 
			session.setAttribute("loggedMember", loggedMember);
			
			ScriptWriterUtil.alertAndNext(response, "로그인 되었습니다.", "BoardList.do");
		}else {
			ScriptWriterUtil.alertAndBack(response, "패스워드를 확인하세요.");
		}
	}

}
