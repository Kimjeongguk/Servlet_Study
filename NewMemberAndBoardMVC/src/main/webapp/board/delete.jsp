
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div id="contents">
	<h2 class="contentsTitle">VIEW</h2>
	<form method="POST" action="BoardDelete.do" class="form">
		<table class="tdLeft">
			<cols>
				<col style="width: 150px;">
				<col>
			</cols>
			<tbody>
				<tr>
					<th>name</th>
					<td>${boardDto.name}</td>
				</tr>
				<tr>
					<th>email</th>
					<td>${boardDto.email}</td>
				</tr>
				<tr>
					<th>subject</th>
					<td>${boardDto.subject}</td>
				</tr>
				<tr>
					<th>contents</th>
					<td>${boardDto.contents}</td>
				</tr>
				<tr>
					<th>password</th>
					<td>
						<input type="password" name="userPw" placeholder="패스워드를 입력하세요.">
						<input type="hidden"   name="no" value="${boardDto.no}"> <!-- hidden 화면에 노출하지 않고 데이터 보낼때.... -->
					</td>
				</tr>
			</tbody>
		</table>
		<div class="btns center">
			<input type="submit" value="삭제">
			<a href="BoardView.do?no=${boardDto.no}">취소</a>  <!-- a 태그도 submit 기능을 할 수 있다. js   form.submit(); -->
		</div>
	</form>
</div>
<%@ include file="../include/footer.jsp"%>



