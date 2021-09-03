<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String name = (String)session.getAttribute("name");
%>

<script>
	alert("<%=name%>님 안녕히 가세요");
</script>
<%
	session.invalidate();
//	response.sendRedirect("../board/login.jsp");
%>

<script>
	location.href="../board/list.jsp";
</script>