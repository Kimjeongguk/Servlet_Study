<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	request.setCharacterEncoding("utf-8");//입력
	response.setContentType("text/html; charset=utf-8");//출력
	int no = Integer.parseInt(request.getParameter("no"));
	String userPw = request.getParameter("userPw");

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String password = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, password);
		String sql = "DELETE FROM BOARD WHERE NO =? AND PASSWORD =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, userPw);
		int result = pstmt.executeUpdate(); //SELECT를 제외한 나머지는 이거
		
		if(result > 0){
			%>
			<script>
				alert("글 삭제 완료");
				location.href="list.jsp";
			</script>
			<%
		} else {
			%>
			<script>
				alert("비밀번호를 확인해주세요.");
				history.back();	
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
