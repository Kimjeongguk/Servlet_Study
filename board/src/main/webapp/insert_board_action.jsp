<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	request.setCharacterEncoding("utf-8");//입력
	response.setContentType("text/html; charset=utf-8");//출력
	String userName = request.getParameter("userName");
	String email = request.getParameter("email");
	String subject = request.getParameter("subject");
	String userPw = request.getParameter("password");
	String contents = request.getParameter("contents");

	out.println(userName);
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String password = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql = "INSERT INTO BOARD VALUES (SEQ_BOARD.NEXTVAL, ?, ?, ?, ?, ?)";
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, password);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userName);
		pstmt.setString(2, email);
		pstmt.setString(3, subject);
		pstmt.setString(4, userPw);
		pstmt.setString(5, contents);
		int result = pstmt.executeUpdate(); //SELECT를 제외한 나머지는 이거
		
		if(result > 0){
			%>
			<script>
				alert("글이 입력되었습니다.");
				location.href="list.jsp";
			</script>
			<%
		}
	}catch (Exception e){
		e.printStackTrace();
	} finally {
		try{
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch (Exception e2){
			e2.printStackTrace();
		}
	}

%>
