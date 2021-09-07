<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>문자열 분리</h1>
	<ul>
	<c:forTokens var="city" items="서울,대전,대구/부산" delims=",/
	">
		<li>${city}</li>
	</c:forTokens>
	</ul>
</body>
</html>