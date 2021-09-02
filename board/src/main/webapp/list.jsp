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

%>
<div id=contents">
	<h2 class="contentsTitle">글쓰기</h2>
	<form method="POST" action="insert_board_action.jsp" class="form">
		<table>
			<cols>
			<col style="width: 50px;">
			<col>
			<col style="width: 150px;">
			</cols>
			<thead>
				<tr>
					<th>NO</th>
					<th>Subject</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
				<%
				try{
					Class.forName(driver);
					conn = DriverManager.getConnection(url, id, password);
					String sql = "SELECT * FROM BOARD ORDER BY NO DESC";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()){
						out.print("<tr>");
						out.print("<td>"+rs.getString("no")+"</td>");
						
						out.print("<td class='left'><a href='view.jsp?no="+rs.getString("no")+"'>"+rs.getString("subject")+"</a></td>");
						out.print("<td>"+rs.getString("name")+"</td>");
						out.print("</tr>");
						
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
			<a href="write.jsp">글쓰기</a>
		</div>
	</form>
</div>
<%@ include file="./include/footer.jsp"%>