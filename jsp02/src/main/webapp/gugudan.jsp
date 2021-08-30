<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>몇단을 출력하시겠습니까?</h1>
		<h1><a href="result?dan=5">5단을 출력</a></h1>
        <form action="result" method="GET">
	        <input type="text" name="dan">
	        <input type="submit" value="보내기">
		</form>
</body>
</html>