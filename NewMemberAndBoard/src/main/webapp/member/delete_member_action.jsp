<%@page import="com.memberandboard.model.MemberDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // 읽을때 한글 깨지지 않게 읽기...
	response.setContentType("text/html; charset=utf-8;");  // 출력할때 한글 깨지지 않게 내보내기...
	
	String userId =  (String)session.getAttribute("userId");
	String userPw = request.getParameter("userPw"); 
	
	MemberDao memberDao = new MemberDao();

	int result = memberDao.deleteMember(userId, userPw);
	if(result > 0) {
		session.invalidate();
%>	
	<script>
		alert("회원탈퇴 되었습니다.");
		location.href="login.jsp";
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

%>







