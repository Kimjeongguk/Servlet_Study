<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="contents">
	<h2 class="contentsTitle">글쓰기</h2>
	<form method="POST" action="BoardWrite.do" class="form">
		<table class="tdLeft">
			<cols>
			<col style="width: 150px;">
			<col>
			</cols>
			<tbody>
				<tr>
					<th>name</th>
					<td><input type="text" name="userName" placeholder="이름을 쓰세요"></td>
				</tr>
				<tr>
					<th>email</th>
					<td><input type="text" name="email" placeholder="메일을 쓰세요"></td>
				</tr>
				<tr>
					<th>subject</th>
					<td><input type="text" name="subject" placeholder="제목을 쓰세요"></td>
				</tr>
				<tr>
					<th>password</th>
					<td><input type="password" name="password"
						placeholder="패스워드를 쓰세요"></td>
				</tr>
				<tr>
					<th>contents</th>
					<td><textarea rows="" cols="" name="contents"
							placeholder="내용을 쓰세요"></textarea></td>
				</tr>
			</tbody>
		</table>
		<div class="btns center">
			<input type="submit" value="확인"> 
			<input type="button" value="취소">
		</div>
	</form>
</div>
<%@ include file="../include/footer.jsp"%>



