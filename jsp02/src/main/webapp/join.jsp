<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
</style>
<body>
<form action="signUp" method="POST" name="singInForm">
        <table>
            <tr>
                <th>기본정보(필수)</th>
            </tr>
            <tr>
                <td>아이디*</td>
                <td><input type="text" name="userId">(영문소문자/숫자,4~16)</td>
            </tr>
            <tr>
                <td>비밀번호*</td>
                <td><input type="password" name="userPw">(영문 대문자/숫자/특수문자 중 2가지 이상 조합,10자~16)</td>
            </tr><tr>
                <td>비밀번호 확인*</td>
                <td><input type="password" name="userPwCheck"></td>
            </tr><tr>
                <td>비밀번호 확인 질문*</td>
                <td>
                    <select name="passwordQuestion">
                        <option value="기억에 남는 추억의 장소는?">기억에 남는 추억의 장소는?</option>
                        <option value="인생 좌우명">인생 좌우명</option>
                        <option value="보물 1호">보물 1호</option>
                    </select>
                </td>
            </tr><tr>
                <td>비밀번호 확인 답변*</td>
                <td><input type="text" name="passwordQuestionCheck"></td>
            </tr><tr>
                <td>이름*</td>
                <td><input type="text" name="userName"></td>
            </tr><tr>
                <td>주소</td>
                <td>
                    <input type="number" name="address1">
                    <input type="button" name="addressBtn" value="우편번호"> <br>
                    <input type="text" name="address2">기본주소<br>
                    <input type="text" name="address3">나머지주소
                </td>
            </tr><tr>
                <td>일반전화</td>
                <td>
                    <select name="homeNumber">
                        <option value="02">02</option>
                        <option value="031">031</option>
                        <option value="032">032</option>
                        <option value="033">033</option>
                    </select>
                    -
                    <input type="number" name="homeMidleNumber">
                    -
                    <input type="number" name="homeLastNumber">
                </td>
            </tr><tr>
                <td>휴대전화</td>
                <td><select name="phoneNumber">
                    <option value="02">010</option>
                    <option value="031">011</option>
                    <option value="032">017</option>
                </select>
                -
                <input type="number" name="phoneMidleNumber">
                -
                <input type="number" name="phoneLastNumber"></td>
            </tr><tr>
                <td>SMS수신여부*</td>
                <td>
                    <input type="checkbox" name="SMSCheck" value="true">동의함 <br>
                    <p>
                        쇼핑몰에서 제공하는 유익한 이벤트 소식을 SMS로 받으실 수 있습니다.<br>
(※ 선택하지 않을 시 수신 미동의로 가입됩니다.)
                    </p>
                </td>
            </tr><tr>
                <td>이메일</td>
                <td><input type="text" name="userEmail"></td>
            </tr><tr>
                <td>이메일 수신여부*</td>
                <td>
                    <input type="checkbox" name="EmailCheck" value="true">동의함 <br>
                    <p>
                        쇼핑몰에서 제공하는 유익한 이벤트 소식을 이메일로 받으실 수 있습니다.<br>
(※ 선택하지 않을 시 수신 미동의로 가입됩니다.)
                    </p>
                </td>
            </tr>
        </table>
        <div>
			<input type="submit" value="join" onClick="return signInCheck()">
		</div>
    </form>
    <script>
		function signInCheck(){
			if(document.singInForm.userId.value==""){
				alert("아아디를 입력하시오");
				document.singInForm.userId.focus();
				return false;
			} else if (document.singInForm.userPw.value==""){
				alert("비밀번호를 입력하시오");
				document.singInForm.userPw.focus();
				return false;
			} else if (document.singInForm.userPwCheck.value==""){
				alert("비밀번호 확인을 입력하시오");
				document.singInForm.userPw.focus();
				return false;
			} else if (document.singInForm.userPwCheck.value!=document.singInForm.userPw.value){
				alert("비밀번호 불일치");
				document.singInForm.userPw.focus();
				return false;
			} else if (document.singInForm.passwordQuestionCheck.value==""){
				alert("비밀번호 확인 답변을 입력하시오");
				document.singInForm.userPw.focus();
				return false;
			} else if (document.singInForm.userName.value==""){
				alert("이름을 입력하시오");
				document.singInForm.userPw.focus();
				return false;
			} else if (document.singInForm.userEmail.value==""){
				alert("이메일을 입력하시오");
				document.singInForm.userPw.focus();
				return false;
			}else {
				return true;
			}
		}
	</script>
</body>
</html>