<%@page import="com.memberandboard.model.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.memberandboard.model.BoardDao"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/header.jsp"%>
<%
	BoardDao boardDao = new BoardDao();
	ArrayList<BoardDto> boardList = boardDao.showAllBoard();
	request.setAttribute("boardList", boardList);
	
		
%>

<div id="contents">
	<h2 class="contentsTitle">목록</h2>
	<form method="POST" action="insert_board_action.jsp" class="form">
		<table>
			<cols>
				<col style="width: 50px;">
				<col>
				<col style="width: 150px;">
			</cols>
			<thead>
				<tr>
					<th>No</th>
					<th>subject</th>
					<th>name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="boardDto" items="${boardList}">
					<tr>
						<td>${boardDto.no }</td>
						<td>${boardDto.subject }</td>
						<td>${boardDto.name }</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
		<%
			String name = (String)session.getAttribute("name");
			if(name!=null){
				%>
				<div class="btns center">
					<a href="write.jsp">글쓰기</a>
				</div>
				<%
			}
		%>
		
	</form>
</div>
<%@ include file="../include/footer.jsp"%>



