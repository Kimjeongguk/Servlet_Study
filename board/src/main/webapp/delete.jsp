<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./include/header.jsp"%>
<%
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String password = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	int no = Integer.parseInt(request.getParameter("no"));
%>
<div id=contents">
	<h2 class="contentsTitle">VIEW</h2>
	<form method="POST" action="delete_board_action.jsp" class="form">
		<table>
			<cols>
			<col style="width: 150px;">
			<col>
			</cols>
			<tbody>
			<%
				try{
					Class.forName(driver);
					conn = DriverManager.getConnection(url, id, password);
					String sql = "SELECT  * FROM BOARD WHERE NO = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, no);
					rs = pstmt.executeQuery();
									
					while(rs.next()){
					%>
						<tr>
							<th>name</th>
							<td><%=rs.getString("name") %></td>
						</tr>
						<tr>
							<th>email</th>
							<td><%=rs.getString("email") %></td>
						</tr>
						<tr>
							<th>subject</th>
							<td><%=rs.getString("subject") %></td>
						</tr>
						<tr>
							<th>content</th>
							<td><%=rs.getString("contents") %></td>
						</tr>
						<tr>
							<th>password</th>
							<td>
								<input type="password" name="userPw" placeholder="패스워드를 입력하세요.">
								<input type="hidden" name="no" value="<%=no %>">
							</td>
						</tr>
					<%
						
					}
					
				}catch (Exception e){
					e.printStackTrace();
				}
			%>
				
			</tbody>
		</table>
		<div class="btns center">
			<input type="submit" value="삭제">
			<a href="modify.jsp">수정</a>
		</div>
	</form>
</div>
<%@ include file="./include/footer.jsp"%>