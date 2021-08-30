<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- method = post, mapping = login, id/password h1로 보이게끔...-->
	<form action="login" method="POST" name="loginForm">
		<div>
			<input type="text" name="userId" placeholder="아이디를 입력하시오." id="userId">
		</div>
		<div>
			<input type="password" name="userPw" placeholder="패스워드를 입력하시오." id="userPw">
		</div>
		<div>
			<input type="text" name="userName" placeholder="아이디를 입력하시오." id="userName">
		</div>
		<div>
			<input type="text" name="userAge" placeholder="나이를 입력하시오." id="userAge">
		</div>
		<div>
			<input type="radio" name="userGender" value="남" checked="checked">남
			<input type="radio" name="userGender" value="여">여
		</div>
		<div>
			<select name="job">
				<option value = "">직업을 고르시오</option>
				<option value = "프로그래머">프로그래머</option>
				<option value = "DBA">DBA</option>
				<option value = "디자이너">디자이너</option>
				<option value = "기획자">기획자</option>
			</select>
		</div>
		<div>
			<p>취미를 고르시오.</p>
			<label>
				<span>낚시</span><input type="checkbox" name="interest" value="낚시">
			</label>
			<label>
				<span>음악</span><input type="checkbox" name="interest" value="음악">
			</label>
			<label>
				<span>영화</span><input type="checkbox" name="interest" value="영화">
			</label>
			<label>
				<span>보드</span><input type="checkbox" name="interest" value="보드">
			</label>
		</div>
		<div>
			<textarea placeholder="뭐라도 적어라" name="greeting"></textarea>
		</div>
		<div>
			<input type="submit" value="전송" onClick="return loginCheck()">
		</div>
	</form>
	<script>
		function loginCheck(){
			if(document.loginForm.userId.value==""){
				alert("아아디를 입력하시오");
				document.loginForm.userId.focus();
				return false;
			} else if (document.loginForm.userPw.value==""){
				alert("비밀번호를 입력하시오");
				document.loginForm.userPw.focus();
				return false;
			}else {
				return true;
			}
		}
	</script>
</body>
</html>