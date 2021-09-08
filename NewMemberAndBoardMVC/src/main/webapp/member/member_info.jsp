<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/header.jsp"%>

<main>
	<div id="contents">
		<h2 class="contentsTitle">회원정보</h2>
		<div class="form">
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
						<th>NAME</th>
						<td>${loggedMember.getName()}</td>
					</tr>
					<tr>
						<th>EMAIL</th>
						<td>${loggedMember.getEmail()}</td>
					</tr>
					<tr>
						<th>H.P</th>
						<td>${loggedMember.getHp()}</td>
					</tr>
					<tr>
						<th>ADDRESS</th>
						<td>${loggedMember.getAddress()}</td>
					</tr>
				</tbody>
			</table>
			<div class="btns center">
				<a href="MemberModifyForm.do">회원정보 수정</a>
				<a href="MemberDeleteForm.do">회원탈퇴</a>
			</div>
		</div>
	</div>
	<!-- contents end -->
</main>
<%@ include file="../include/footer.jsp"%>





