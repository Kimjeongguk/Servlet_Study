<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="contents">
		<h2 class="contentsTitle">목록</h2>
		<div class="form">
			<table>
				<colgroup>
					<col style="width: 30px;">
					<col>
					<col style="width: 150px;">
					<col style="width: 200px;">
					<col style="width: 30px;">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th class="left">Subject</th>
						<th>Name</th>
						<th>Date</th>
						<th>Hit</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${replyList.get(0).getNo() }</td>
						<td>${replyList.get(0).getName() }</td>
						<td>${replyList.get(0).getSubject() }</td>
						<td>${replyList.get(0).getRegDate() }</td>
						<td>${replyList.get(0).getReadCount() }</td>
					</tr>
					<tr>
						<td>${replyList.get(1).getNo() }</td>
						<td>${replyList.get(1).getName() }</td>
						<td>${replyList.get(1).getSubject() }</td>
						<td>${replyList.get(1).getRegDate() }</td>
						<td>${replyList.get(1).getReadCount() }</td>
					</tr>
				</tbody>
			</table>
			<div class="btns center">
				<a href="ReplyForm.do">글쓰기</a>
			</div>
		</div>
	</div>
</body>
</html>