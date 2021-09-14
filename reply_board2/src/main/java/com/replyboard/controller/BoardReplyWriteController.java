package com.replyboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.replyboard.model.ReplyDao;
import com.replyboard.model.ReplyDto;

@WebServlet("/BoardReplyWrite.do")
public class BoardReplyWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardReplyWriteController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		ReplyDao replyDao = new ReplyDao();
		ReplyDto replyDto = new ReplyDto();
		
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String contents = request.getParameter("contents");
		
		int no = Integer.parseInt(request.getParameter("no"));
		int reGroup = Integer.parseInt(request.getParameter("reGroup"));
		int reStep = Integer.parseInt(request.getParameter("reStep"));
		int reLevel = Integer.parseInt(request.getParameter("reLevel"));
		
		replyDto.setName(userName);
		replyDto.setEmail(email);
		replyDto.setSubject(subject);
		replyDto.setPassword(password);
		replyDto.setContents(contents);
		replyDto.setNo(no);
		replyDto.setReGroup(reGroup);
		replyDto.setReStep(reStep);
		replyDto.setReLevel(reLevel);
		
		int result = replyDao.insertReplyBoard(replyDto);
	}

}
