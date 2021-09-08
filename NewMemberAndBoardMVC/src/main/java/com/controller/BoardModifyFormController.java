package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.memberandboard.model.BoardDao;
import com.memberandboard.model.BoardDto;

@WebServlet("/BoardModifyForm.do")
public class BoardModifyFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardModifyFormController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		boardDto = boardDao.getSelectOne(no);
		
		request.setAttribute("boardDto", boardDto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/update.jsp");
		dispatcher.forward(request, response);
	}

}
