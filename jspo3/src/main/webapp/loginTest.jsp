<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<!-- 넘겨받은 아이디 패스워드가 자기가 정한거랑 맞으면 loginOk.jsp 가고 그렇지 않으면 loginFail.jsp로 보내기.... -->
<%
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	//out.print(userId+"==="+userPw);
	if(userId.equals("1") && userPw.equals("1")) {
		//response.sendRedirect("loginOk.jsp?name=jjang051");
%>
	<script>
		location.href="loginOk.jsp?name=1";
	</script>
<%
	} else {
		//response.sendRedirect("loginFail.jsp");
%>
	<script>
		alert("아이디 비밀번호 확인해주세요.");
		history.back();
	</script>
<%
	}
%>
<main>
	<div id="contents">
		<h2 class="contentsTitle">로그인</h2>
		fjdkjslfjdskljflk djslkf jd lsjf jdslfjdsljkf jkdsjkl fjlkds
		fj dslkfjd sjflkdjsl
	</div>
</main>
<%@ include file="./include/footer.jsp" %>