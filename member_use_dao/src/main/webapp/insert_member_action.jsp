<%@page import="com.member.model.MemberDto"%>
<%@page import="com.member.model.MemberDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String userId= request.getParameter("userId");
	String userPw= request.getParameter("userPw");
	String userName= request.getParameter("userName");
	int zipcode= Integer.parseInt(request.getParameter("address01"));
	String address= request.getParameter("address02")+" "+request.getParameter("address03");
	String phone= request.getParameter("phoneNumber")+request.getParameter("phoneMidleNumber")+request.getParameter("phoneLastNumber");
	String userEmail= request.getParameter("userEmail");
	
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = new MemberDto(userId,userName,userPw,zipcode,address,phone,userEmail);
	int result = memberDao.insertMember(memberDto);	
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
%>