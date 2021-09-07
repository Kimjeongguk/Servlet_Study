<%@page import="com.memberandboard.model.MemberDto"%>
<%@page import="com.memberandboard.model.MemberDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8"); // 요청으로 들어오는 한글 인코딩을 utf-8로 처리하겠다.
   response.setContentType("text/html; charset=utf-8");// 출력용 한글깨짐 방짐...
   
   String userId = request.getParameter("userId");
   String userPw = request.getParameter("userPw");
   String userName = request.getParameter("userName");
   int zipcode = Integer.parseInt(request.getParameter("zipcode"));
   String address = request.getParameter("address01") + " " + request.getParameter("address02");
   String phone = request.getParameter("phoneNumber") + request.getParameter("phoneMiddleNumber")
         + request.getParameter("phoneLastNumber");
   String userEmail = request.getParameter("userEmail");
   
   MemberDao memberDao = new MemberDao();
   MemberDto memberDto = new MemberDto();
   
   memberDto.setId(userId);
   memberDto.setPassword(userPw);
   memberDto.setName(userName);
   memberDto.setZipcode(zipcode);
   memberDto.setAddress(address);
   memberDto.setHp(phone);
   memberDto.setEmail(userEmail);
   int result = memberDao.updateMember(memberDto);
   
   if (result > 0) {
	   MemberDto loggedMember = memberDao.getLoggedMember(memberDto);
	   session.setAttribute("loggedMember", loggedMember);
%>
	   <script>
	      alert("수정완료");
	      location.href = "../board/list.jsp";
	   </script>
<%
	} else {
%>
	   <script>
	      alert("다시입력하세요");
	      history.back();
	   </script>
<%
	}
%>
