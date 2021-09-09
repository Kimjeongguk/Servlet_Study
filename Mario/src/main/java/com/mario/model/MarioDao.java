package com.mario.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarioDao {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String password = "1234";
	
	Connection  conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//getConnection
		public void getConnection() {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,id,password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//close(rs, pstmt, conn)
		public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//close(pstmt, conn)
		public void close(PreparedStatement pstmt, Connection conn) {
			try {
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//insert
		public int insertMario(MarioDto marioDto) {
			int result = 0;
			getConnection();
			String sql = "INSERT INTO MARIO VALUES (SEQ_MARIO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, marioDto.getTitle());
				pstmt.setString(2, marioDto.getContents());
				pstmt.setString(3, marioDto.getBg());
				pstmt.setString(4, marioDto.getLink());
				pstmt.setString(5, marioDto.getMarioImg());
				pstmt.setString(6, marioDto.getMarioRealImag());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(pstmt, conn);
			return result;
		}
		
		public ArrayList<MarioDto> selectAllMario(){
			ArrayList<MarioDto> marioList = new ArrayList<MarioDto>();
			getConnection();
			String sql = "SELECT * FROM MARIO";
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					MarioDto marioDto = new MarioDto();
					marioDto.setNo(rs.getInt("no"));
					marioDto.setTitle(rs.getString("title"));
					marioDto.setContents(rs.getString("contents"));
					marioDto.setBg(rs.getString("bg"));
					marioDto.setLink(rs.getString("link"));
					marioDto.setMarioImg(rs.getString("marioimg"));
					marioDto.setMarioRealImag(rs.getString("mariorealimg"));
					marioList.add(marioDto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(rs,pstmt,conn);
			
			return marioList;
		}
}
