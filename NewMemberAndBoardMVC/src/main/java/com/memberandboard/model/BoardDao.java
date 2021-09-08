package com.memberandboard.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.memberandboard.model.BoardDto;

public class BoardDao {
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
	//insertBoard
	public int insertBoard(BoardDto boardDto) {
		int result = 0;
		getConnection();
		String sql = "INSERT INTO BOARD VALUES (SEQ_BOARD.NEXTVAL, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getName());
			pstmt.setString(2, boardDto.getEmail());
			pstmt.setString(3, boardDto.getSubject());
			pstmt.setString(4, boardDto.getPassword());
			pstmt.setString(5, boardDto.getContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt, conn);
		return result;
	}
	//deleteBoard
	public int deleteBoard(int no, String userPw) {
		   int result = 0;
		   getConnection();
		   String sql = "DELETE FROM BOARD WHERE NO = ? AND PASSWORD = ?";
		   try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setInt(1, no);
		         pstmt.setString(2, userPw);
		         result = pstmt.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      close(pstmt, conn);
		   return result;
	   }
	//updateBoard
	public int updateBoard(BoardDto boardDto) {
	      int result = 0;
	      getConnection();
	      String sql = "UPDATE  BOARD SET NAME=?,EMAIL=?,SUBJECT=?,CONTENTS=? WHERE NO=? AND PASSWORD=?";
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, boardDto.getName());
			pstmt.setString(2, boardDto.getEmail());
			pstmt.setString(3, boardDto.getSubject());
			pstmt.setString(4, boardDto.getContents());
			pstmt.setInt(5, boardDto.getNo());
			pstmt.setString(6, boardDto.getPassword());
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      close(pstmt, conn);
	      return result;
	   }
	//showAllList
	public ArrayList<BoardDto> showAllBoard() {
		ArrayList<BoardDto> boardList = new ArrayList<BoardDto>();
		getConnection();
		String sql = "SELECT * FROM BOARD";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNo(rs.getInt("no"));
				boardDto.setName(rs.getString("name"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setPassword(rs.getString("password"));
				boardDto.setContents(rs.getString("contents"));
				boardList.add(boardDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs,pstmt,conn);
		return boardList;
	}
	//oneSelect
	public BoardDto getSelectOne(int no) {
		  BoardDto boardDto = new BoardDto();
	      getConnection();
	      String sql = "SELECT * FROM BOARD WHERE NO = ?";
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt (1,no);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	        	boardDto.setNo(rs.getInt("no"));
				boardDto.setName(rs.getString("name"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setPassword(rs.getString("password"));
				boardDto.setContents(rs.getString("contents"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      close(rs,pstmt,conn);
	      return boardDto;
	   }
}
