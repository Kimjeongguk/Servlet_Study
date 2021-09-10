<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/layout.css">
</head>
<body>
	<div class="formBox">
		<h2>자유게시판</h2>
		<form action="Visual.do" id="joinForm" method="POST" enctype="multipart/form-data">
			<table>
				<colgroup>
					<col style="width:150px">
					<col style="width:850px">
				</colgroup>
				<tbody>
					<tr>
						<th>CONTENTS01</th>
						<td>
							<input type="text" name="contents01" id="contents01">
						</td>
					</tr>
					<tr>
						<th>CONTENTS02</th>
						<td>
							<input type="text" name="contents02" id="contents02">
						</td>
					</tr>
					<tr>
						<th>FILE</th>
						<td>
							<input type="file" name="file" id="file">
						</td>
					</tr>
				</tbody>
			</table>
			<div class="btns">
				<input type="submit" value="확인" id="join">
				<input type="reset" value="취소" id="cancel">
			</div>
		</form>
	</div>
</body>
</html>