package com.clock.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClockDao {
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
	
	public int insertClock(ClockDto clockDto) {
		int result = 0;
		try {
			getConnection();
			String sql = "INSERT INTO CLOCK VALUES (SEQ_CLOCK.NEXTVAL,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clockDto.getCategory());
			pstmt.setString(2, clockDto.getTitle());
			pstmt.setString(3, clockDto.getDepth());
			pstmt.setInt(4, clockDto.getPrice());
			pstmt.setString(5, clockDto.getLink());
			pstmt.setString(6, clockDto.getClockImg());
			pstmt.setString(7, clockDto.getRealClockImg());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt,con);
		}
		return result;
	}
	
	public ArrayList<ClockDto> showAllClock() {
		ArrayList<ClockDto> clockList = new ArrayList<ClockDto>();
		try {
			getConnection();
			String sql = "SELECT * FROM CLOCK";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClockDto clockDto = new ClockDto();
				clockDto.setNo(rs.getInt("no"));
				clockDto.setCategory(rs.getString("category"));
				clockDto.setTitle(rs.getString("title"));
				clockDto.setDepth(rs.getString("depth"));
				clockDto.setPrice(rs.getInt("price"));
				clockDto.setLink(rs.getString("link"));
				clockDto.setClockImg(rs.getString("clockimg"));
				clockDto.setRealClockImg(rs.getString("realclockimg"));
				clockList.add(clockDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,pstmt,con);
		}
		return clockList;
	}
}
