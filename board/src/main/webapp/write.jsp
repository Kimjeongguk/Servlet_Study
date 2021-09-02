<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./include/header.jsp"%>
<div id=contents">
	<h2 class="contentsTitle">글쓰기</h2>
	<form method="POST" action="insert_board_action.jsp" class="form">
		<table>
			<cols>
			<col style="width: 150px;">
			<col>
			</cols>
			<tbody>
				<tr>
					<th>name</th>
					<td><input type="text" name="userName" placeholder="이름"></td>
				</tr>
				<tr>
					<th>email</th>
					<td><input type="text" name="email" placeholder="이메일"></td>
				</tr>
				<tr>
					<th>subject</th>
					<td><input type="text" name="subject" placeholder="제목"></td>
				</tr>

				<tr>
					<th>password</th>
					<td><input type="password" name="password" placeholder="비밀번호"></td>
				</tr>
				<tr>
					<th>content</th>
					<td><textarea rows="" cols="" name="contents" placeholder="내용"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="btns center">
			<input type="submit" value="확인"> <input type="button"
				value="취소">
		</div>
	</form>
</div>
<%@ include file="./include/footer.jsp"%>