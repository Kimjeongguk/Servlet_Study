<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 값을 받아와야함 -->
<%
	request.setCharacterEncoding("utf-8");
	String userId= request.getParameter("userId");
	String userPw= request.getParameter("userPw");
	String userName= request.getParameter("userName");
	int zipcode= Integer.parseInt(request.getParameter("address01"));
	String address= request.getParameter("address02")+" "+request.getParameter("address03");
	String phone= request.getParameter("phoneNumber")+request.getParameter("phoneMidleNumber")+request.getParameter("phoneLastNumber");
	String userEmail= request.getParameter("userEmail");
	
	//out.println(userId);
	//out.println(userPw);
	//out.println(userName);
	//out.println(zipcode);
	//out.println(address);
	//out.println(phone);
	//out.println(userEmail);

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String password = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql = "INSERT INTO MEMBER VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, password);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, userPw);
		pstmt.setString(3, userName);
		pstmt.setInt(4, zipcode);
		pstmt.setString(5, address);
		pstmt.setString(6, phone);
		pstmt.setString(7, userEmail);
		int result = pstmt.executeUpdate();
		if(result > 0){
		//	response.sendRedirect("list.jsp");//바로갈거면
%>
		<script>
			alert("회원가입 완료");
			location.href="list.jsp";
		</script>
<%
		}else {
%>
			<script>
				alert("회원가입 실패");
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