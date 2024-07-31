package com.example.jsp03.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			System.out.println("------------ called ------------");
			// JDBC 1단계 : 드라이버 객체 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 로딩 성공");

			// JDBC 2단계 : 커넥션 연결
			String jdbcUrl = "jdbc:mysql://localhost:3306/shop2";
			conn = DriverManager.getConnection(jdbcUrl, "root", "1234");
			System.out.println("2. 커넥션 연결");
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
