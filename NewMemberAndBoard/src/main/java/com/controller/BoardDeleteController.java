package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.memberandboard.model.BoardDao;
import com.memberandboard.model.MemberDao;
import com.memberandboard.model.MemberDto;

@WebServlet("/BoardDelete.do")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDeleteController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;"); 
		PrintWriter out = response.getWriter();
		String stingNo = request.getParameter("no");
		String userPw = request.getParameter("userPw"); 
		int no = Integer.parseInt(stingNo);
		BoardDao boardDao = new BoardDao();

		int result = boardDao.deleteBoard(no, userPw);
		if(result > 0) {
			out.println("<script>");
			out.println("alert('게시물이 삭제 되었습니다.')");
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
