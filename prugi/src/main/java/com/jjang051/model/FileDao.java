package com.jjang051.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FileDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String pw = "1234";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private void getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close(ResultSet rs,PreparedStatement pstmt, Connection con) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void close(PreparedStatement pstmt, Connection con) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//db에 밀어넣기
	public int insertVisual(FileDto fileDto) {
		int result = 0;
		try {
			getConnection();
			String sql = "INSERT INTO PRUGIO VALUES (SEQ_PRUGIO.NEXTVAL,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fileDto.getContents01());
			pstmt.setString(2, fileDto.getContents02());
			pstmt.setString(3, fileDto.getVisual());
			pstmt.setString(4, fileDto.getRealVisual());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt,con);
		}
		return result;
	}
	
	public ArrayList<FileDto> showAllMainVisual() {
		ArrayList<FileDto> visualList = new ArrayList<FileDto>();
		try {
			getConnection();
			String sql = "SELECT * FROM PRUGIO";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FileDto fileDto = new FileDto();
				fileDto.setNo(rs.getInt("no"));
				fileDto.setContents01(rs.getString("contents01"));
				fileDto.setContents02(rs.getString("contents02"));
				fileDto.setVisual(rs.getString("visual"));
				fileDto.setRealVisual(rs.getString("realvisual"));
				visualList.add(fileDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,pstmt,con);
		}
		return visualList;
	}
}












