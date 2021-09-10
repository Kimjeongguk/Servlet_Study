package com.prugio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.FileDao;
import com.jjang051.model.FileDto;

@WebServlet("/VisualList.do")
public class VisualListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VisualListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileDao fileDao = new FileDao();
		ArrayList<FileDto> visualList = fileDao.showAllMainVisual();
	}

}
