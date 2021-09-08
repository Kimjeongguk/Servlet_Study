package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.memberandboard.model.MemberDao;
import com.memberandboard.model.MemberDto;

@WebServlet("/MemberList.do")
public class MemberLIstController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLIstController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		ArrayList<MemberDto> memberList = memberDao.showAllMember();
		request.setAttribute("memberList", memberList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/list.jsp");
		dispatcher.forward(request, response);
	}

}
