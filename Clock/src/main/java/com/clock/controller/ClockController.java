package com.clock.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clock.model.ClockDao;
import com.clock.model.ClockDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/Clock.do")
public class ClockController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClockController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		ClockDto clockDto = new ClockDto();
		
		String savePath = "upload_clock";
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath);
		
		int fileSize = 1024*1024*100;
		String encoding = "UTF-8";
		DefaultFileRenamePolicy clockPolicy = new DefaultFileRenamePolicy();
		
		
		MultipartRequest multipartRequest = new MultipartRequest(request, realPath, fileSize, encoding, clockPolicy);
		
		clockDto.setCategory(multipartRequest.getParameter("category"));
		clockDto.setTitle(multipartRequest.getParameter("title"));
		clockDto.setDepth(multipartRequest.getParameter("depth"));
		clockDto.setPrice(Integer.parseInt(multipartRequest.getParameter("price")));
		clockDto.setLink(multipartRequest.getParameter("link"));
		clockDto.setClockImg(multipartRequest.getOriginalFileName("clockImg"));
		clockDto.setRealClockImg(multipartRequest.getFilesystemName("clockImg"));
		ClockDao clockDao = new ClockDao();
		int result = clockDao.insertClock(clockDto);
		if(result > 0) {
			//입력됨
			response.sendRedirect("Main.do");
		}
	}

}
