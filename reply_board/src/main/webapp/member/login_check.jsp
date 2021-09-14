<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "test_user";
	String password = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "SELECT * FROM MEMBER WHERE ID=? AND PASSWORD=?";
	
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url,id,password);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,userId);
		pstmt.setString(2,userPw);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			//로그인완료
			session.setAttribute("name", rs.getString("name"));
			session.setAttribute("userId", rs.getString("id"));
			response.sendRedirect("../board/list.jsp");
		}else {
			//로그인 실패
			%>
				<script>
					alert("아이디 비밀번호를 확인해 주세요.");
					history.back();
				</script>
			<%
		}
		
		
	}catch (Exception e){
		e.printStackTrace();
	}
%>