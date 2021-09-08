<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	alert("${loggedMember.name}님 안녕히 가세요");
</script>
<%
	session.invalidate();
//	response.sendRedirect("../board/login.jsp");
%>

<script>
	location.href="../board/list.jsp";
</script>