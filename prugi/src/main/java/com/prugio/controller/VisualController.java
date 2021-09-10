package com.prugio.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.FileDao;
import com.jjang051.model.FileDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/Visual.do")
public class VisualController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VisualController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		FileDto fileDto = new FileDto();
		
		String savePath = "upload_visual";
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath);
		
		int fileSize = 1024*1024*50;
		String encoding = "UTF-8";
		DefaultFileRenamePolicy filePolicy = new DefaultFileRenamePolicy();
		
		
		MultipartRequest multipartRequest = new MultipartRequest(request, realPath, fileSize, encoding, filePolicy);
		fileDto.setContents01(multipartRequest.getParameter("contents01"));
		fileDto.setContents02(multipartRequest.getParameter("contents02"));
		fileDto.setVisual(multipartRequest.getOriginalFileName("file"));
		fileDto.setRealVisual(multipartRequest.getFilesystemName("file"));
		
		FileDao fileDao = new FileDao();
		int result = fileDao.insertVisual(fileDto);
		if(result > 0) {
			//입력됨
			response.sendRedirect("Main.do");
		}
	}

}
