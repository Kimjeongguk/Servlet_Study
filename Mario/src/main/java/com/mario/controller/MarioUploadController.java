package com.mario.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mario.model.MarioDao;
import com.mario.model.MarioDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(name = "MarioInsertController", urlPatterns = { "/MarioUpload.do" })
public class MarioUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MarioUploadController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html; charset=utf-8");
		
		String savePath = "upload_mario";
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath);
		int fileSize = 1024*1024*100;//파일크기 지정
		String encoding = "UTF-8";
		DefaultFileRenamePolicy filePolicy = new DefaultFileRenamePolicy();
//		MultipartRequest multipartRequest = new MultipartRequest(request,);
		MultipartRequest multipartRequest = new MultipartRequest(request,realPath,fileSize,encoding,filePolicy);
		
		PrintWriter out = response.getWriter();
		
		String title = multipartRequest.getParameter("title");
		String background = multipartRequest.getParameter("background"); 
		String link = multipartRequest.getParameter("link");
		String contents = multipartRequest.getParameter("contents");
//		String file = multipartRequest.getParameter("file");
		String marioImg = multipartRequest.getOriginalFileName("file");
		String marioRealImg = multipartRequest.getFilesystemName("file");
		
		MarioDao marioDao = new MarioDao();
		MarioDto marioDto = new MarioDto();
		
		marioDto.setTitle(title);
		marioDto.setBg(background);
		marioDto.setLink(link);
		marioDto.setContents(contents);
		marioDto.setMarioImg(marioImg);
		marioDto.setMarioRealImag(marioRealImg);
		
		int result = marioDao.insertMario(marioDto);
		
	}

}
