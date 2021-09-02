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
	<div class="form">
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
					
					
					<%
						
					}
				}catch (Exception e){
					e.printStackTrace();
				}finally {
					try{
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
						if(rs!=null) rs.close();
					}catch (Exception e2){
						e2.printStackTrace();
					}
				}
			%>
				
			</tbody>
		</table>
		<div class="btns center">
			<a href="delete.jsp?no=<%=no %>">삭제</a>
			<a href="modify.jsp">수정</a>
		</div>
	</div>
</div>
<%@ include file="./include/footer.jsp"%>