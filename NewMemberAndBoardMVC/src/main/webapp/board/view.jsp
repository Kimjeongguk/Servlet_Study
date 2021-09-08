<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div id="contents">
	<h2 class="contentsTitle">VIEW</h2>
	<div class="form">
		<table class="tdLeft">
			<cols>
				<col style="width: 150px;">
				<col>
			</cols>
			<tbody>
				<tr>
					<th>name</th>
					<td>${boardDto.name }</td>
				</tr>
				<tr>
					<th>email</th>
					<td>${boardDto.email }</td>
				</tr>
				<tr>
					<th>subject</th>
					<td>${boardDto.subject }</td>
				</tr>
				<tr>
					<th>contents</th>
					<td class="txtContent">${boardDto.contents }</td>
				</tr>
			</tbody>
		</table>
		<div class="btns center">
			<a href="BoardDeleteForm.do?no=${boardDto.no}">삭제</a>
			<a href="BoardModifyForm.do?no=${boardDto.no}">수정</a>
		</div>
	</div>
</div>
<script>
	$(".txtContents").html($(".txtContents"));
</script>
<%@ include file="../include/footer.jsp"%>



