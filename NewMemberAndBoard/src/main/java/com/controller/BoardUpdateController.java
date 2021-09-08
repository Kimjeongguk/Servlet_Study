package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.memberandboard.model.BoardDao;
import com.memberandboard.model.BoardDto;

@WebServlet("/BoardUpdate.do")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;"); 
		PrintWriter out = response.getWriter();
		String stringNo = request.getParameter("no");
		int no = Integer.parseInt(stringNo);
		String userName = request.getParameter("userName");
		String password = request.getParameter("password"); 
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		
		BoardDto boardDto = new BoardDto();
		BoardDao boardDao = new BoardDao();
		boardDto.setNo(no);
		boardDto.setName(userName);
		boardDto.setEmail(email);
		boardDto.setPassword(password);
		boardDto.setSubject(subject);
		boardDto.setContents(contents);

		int result = boardDao.updateBoard(boardDto);
		if(result > 0) {
			out.println("<script>");
			out.println("alert('업데이트 되었습니다.')");
			out.println("location.href='BoardList.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('실패하였습니다.')");
			out.println("history.back();");
			out.println("</script>");
		} 
	}

}
