package com.jump;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class GugudanResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GugudanResult() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	      response.setContentType("text/html; charset=utf-8");
	      PrintWriter out = response.getWriter();
	      int dan = Integer.parseInt(request.getParameter("dan"));
	      out.println("<!DOCTYPE html>");
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>자바 클래스로 작성하는  html파일...</title>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<h1>gugudan.jsp에서 넘어온 값은 "+dan+"</h1>");
	      out.println("<table border='1' style='width:300px; text-align: center;'>");
	      out.println("<thead><th colspan='5'>"+dan+"단</th></thead>");        
	      out.println("<tbody>");
	      for(int i=1;i<10;i++) {
	         out.println("<tr><td>"+dan+"</td><td>x</td><td>"+i+"</td><td>=</td><td>"+(dan*i)+"</td></tr>");
	      }
	      out.println("</tbody>");
	      out.println("</table>");
	      out.println("</body>");
	      out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
