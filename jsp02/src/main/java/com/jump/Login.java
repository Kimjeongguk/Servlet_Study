package com.jump;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		//요청은 request
		//응답은 response
		request.setCharacterEncoding("utf-8");//요청으로 들어오는 한글 인코딩을 utf-8로 처리하겠다.
		response.setContentType("text/html; charset=utf-8;");//출력용 한글깨짐 방침...
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("userAge");
		String userGender = request.getParameter("userGender");
		String greeting = request.getParameter("greeting");
		String job = request.getParameter("job");
		String interests[] = request.getParameterValues("interest");//여러게의 값이 넘어올때는 배열로 처리한다.
		
		PrintWriter out = response.getWriter();//답변을 쓸 준비를 마친다.
		
		out.println("<h1>당신의 아이디는 " + userId+"</h1>");
		out.println("<h1>당신의 패스워드는 " + userPw+"</h1>");
		out.println("<h1>당신의 이름은 " + userName+"</h1>");
		out.println("<h1>당신의 나이는 " + userAge+"</h1>");
		out.println("<h1>당신의 성별은 " + userGender+"</h1>");
		out.println("<h1>당신의 직업은 " + job+"</h1>");
		out.println("<h1>당신의 취미는 ");
		if(interests == null) {
			out.println("없습니다.");
		}
		else {
			for(int i=0; i<interests.length; i++) {
				if(i==interests.length-1) {
					out.println(interests[i] + " 입니다.");
				}
				else {
					out.print(interests[i] + ", "); 
				}
			}
			out.println("<h1> "+ greeting+"</h1>");
		}
	}

}
