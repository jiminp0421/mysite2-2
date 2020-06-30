package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.BoardVo;


public class BoardDao {
	// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		private String driver = "oracle.jdbc.driver.OracleDriver";
		private String url = "jdbc:oracle:thin:@localhost:1521:xe";
		private String id = "webdb";
		private String pw = "webdb";

		private void getConnect() {
			try {
				// 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName(driver);

				// 2. Connection 얻어오기
				conn = DriverManager.getConnection(url, id, pw);
				// System.out.println("접속성공");

			} catch (ClassNotFoundException e) {
				System.out.println("error: 드라이버 로딩 실패 - " + e);
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

		public void close() {
			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

	
		public List<BoardVo> select() {
			
			System.out.println("select");
			List<BoardVo> boardList = new ArrayList<BoardVo>();
	    	getConnect();
	    	
			try {
				String query = "";
				query += " SELECT bo.no, " ;
				query += "       bo.title, " ;
				query += "       us.name," ;
				query += "       bo.hit," ;
				query += "       bo.reg_date" ;
				query += " FROM users us,board bo" ;
				query += " WHERE us.no=bo.user_no" ;
			
				System.out.println(query);
				
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
			    
				
			    // 4.결과처리
			    while(rs.next()) {
			    	int no = rs.getInt("no");
			    	String title = rs.getString("title");
			    	String name = rs.getString("name");
			    	int hit = rs.getInt("hit");
			    	String reg_date = rs.getString("reg_date");
			    	
			    	//리스트에 추가
			    	BoardVo boardVo = new BoardVo(no, title, name, hit, reg_date);
			    	boardList.add(boardVo);
			    }
			    System.out.println(boardList.toString());
		
			} catch (SQLException e) {
			    System.out.println("error:" + e);
			}
			
			close();
			return boardList;
		}
		
		
		
}//boardDao
