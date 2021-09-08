<%@page import="com.memberandboard.model.MemberDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%
	MemberDao memberDao = new MemberDao();

%>
<main>
	<div id="contents">
		<h2 class="contentsTitle">회원탈퇴</h2>
		<form method="POST" action="MemberDelete.do" class="form">
			<table border="1" class="tdLeft">
				<cols>
				<col style="width: 150px">
				<col style="width: 550px">
				</cols>
				<tbody>
					<tr>
						<th>ID</th>
						<td>${loggedMember.getId()}</td>
					</tr>
					<tr>
						<th>password</th>
						<td><input type="password" placeholder="패스워드를 입력하세요." name="userPw"></td>
					</tr>
				</tbody>
			</table>
			<div class="btns center">
				<input type="submit" value="회원탈퇴">
				<a href="MemberInfo.do">취소</a>
			</div>
		</form>
	</div>
	<!-- contents end -->
</main>
<%@ include file="../include/footer.jsp"%>





