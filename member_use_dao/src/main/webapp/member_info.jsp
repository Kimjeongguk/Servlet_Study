<%@page import="com.member.model.MemberDto"%>
<%@page import="com.member.model.MemberDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="./include/header.jsp"%>

<%
	String userId = request.getParameter("userId");
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.getSelectOne(userId);
	request.setAttribute("memberDto", memberDto);
%>
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
	         		<td>${memberDto.id}</td>
	         	</tr>
	         	<tr>
	         		<th>NAME</th>
	         		<td>${memberDto.name}</td>
	         	</tr>
	         	<tr>
	         		<th>ZIPCODE</th>
	         		<td>${memberDto.zipcode}</td>
	         	</tr>
	         	<tr>
	         		<th>ADDRESS</th>
	         		<td>${memberDto.address}</td>
	         	</tr>
	         	<tr>
	         		<th>HP</th>
	         		<td>${memberDto.hp}</td>
	         	</tr>
	         	<tr>
	         		<th>EMAIL</th>
	         		<td>${memberDto.email}</td>
	         	</tr>
	         </tbody>
	      </table>
      </div>
   </div>
   <!-- contents end -->
</main>
<%@ include file="./include/footer.jsp"%>




