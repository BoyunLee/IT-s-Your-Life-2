package com.multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect_mySQL {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
// 1. 드라이버 설정
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("1. 드라이버 설정 성공..");
// 2. 데이터베이스 연결
            String url = "jdbc:mysql://localhost:3306/shop";
            String user = "root";
            String password = "1234";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db 연결 성공.");
// 3. SQL 문 객체 생성
            String sql = "insert into member values ('win', 'win', 'win', 'win')";
            ps = con.prepareStatement(sql);
            System.out.println("3. sql 문 객체 생성 성공.");
// 4. SQL 문 실행 및 결과 출력
            int result = ps.executeUpdate();
            System.out.println("4. sql 문 전송 성공, 결과>> " + result);
        } catch (ClassNotFoundException e) {
            System.out.println(" 드라이버 로드 실패: " +
                    e.getMessage());
        } catch (SQLException e) {
            System.out.println("DB 실패: " + e.getMessage());
        }finally {
            // 자원 해제
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(" 자원 해제 실패: " + e.getMessage());
            }
        }
    }
}
