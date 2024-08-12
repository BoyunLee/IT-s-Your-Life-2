package com.multi.spring2.board.dao;

import java.sql.*;

public class JDBCUtil {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			System.out.println("------------ called ------------");
			// JDBC 1단계 : 드라이버 객체 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. driver loaded");

			// JDBC 2단계 : 커넥션 연결
			String jdbcUrl = "jdbc:mysql://localhost:3306/shop2?useSSL=false&allowPublicKeyRetrieval=true";
			conn = DriverManager.getConnection(jdbcUrl, "root", "1234");
			System.out.println("2. connection established");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(PreparedStatement stmt, Connection conn) {
		// JDBC 5단계 : 연결 해제
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		// JDBC 5단계 : 연결 해제
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
