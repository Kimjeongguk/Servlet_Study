<%@page import="com.memberandboard.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


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
						<td><a href="BoardView.do?no=${boardDto.no}">${boardDto.subject }</a></td>
						<td>${boardDto.name }</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
		<%
			MemberDto loggedMember = (MemberDto)session.getAttribute("loggedMember");
			if(loggedMember!=null){
				%>
				<div class="btns center">
					<a href="BoardWriteForm.do">글쓰기</a>
				</div>
				<%
			}
		%>
		
	</form>
</div>
<%@ include file="../include/footer.jsp"%>



