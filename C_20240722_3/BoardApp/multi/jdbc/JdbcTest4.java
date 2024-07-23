package com.multi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//CREATE TABLE Action (
//action_id INT AUTO_INCREMENT PRIMARY KEY,
//action_name VARCHAR(50) NOT NULL,
//action_description VARCHAR(255),
//action_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//);
public class JdbcTest4{

    private static final String URL = "jdbc:mysql://localhost:3306/edudb";
    private static final String USER = "jdbctest";
    private static final String PASSWORD = "jdbctest";

    public static void main(String[] args) {
        try {
            // 1. JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 데이터베이스 연결
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 3. 데이터 삽입
            ActionVO vo=new ActionVO("play","hard");
            insertAction(connection,vo);

            // 4. 데이터 갱신
            updateActionDescription(connection, 4, "Updated action description");

            // 5. 데이터 삭제
            //deleteAction(connection, 4);

            // 6. 연결 종료
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 또는 쿼리 실행 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    public static void insertAction(Connection connection,ActionVO  vo) {
        String sql = "INSERT INTO Action (action_name, action_description) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vo.getAction_name());
            preparedStatement.setString(2, vo.getAction_description());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("새로운 액션이 성공적으로 삽입되었습니다.");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("데이터 삽입 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    public static void updateActionDescription(Connection connection, int actionId, String newDescription) {
        String sql = "UPDATE Action SET action_description = ? WHERE action_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newDescription);
            preparedStatement.setInt(2, actionId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("액션 설명이 성공적으로 갱신되었습니다.");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("데이터 갱신 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    public static void deleteAction(Connection connection, int actionId) {
        String sql = "DELETE FROM Action WHERE action_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, actionId);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("액션이 성공적으로 삭제되었습니다.");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("데이터 삭제 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
