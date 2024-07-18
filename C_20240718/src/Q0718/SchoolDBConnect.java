package Q0718;

import java.sql.Connection;
import java.sql.DriverManager;

public class SchoolDBConnect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("1. MYSQL 자바 연결할 DRIVER 설정 성공");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String jdbcUrl = "jdbc:mysql://localhost:3306/School2";
        String username = "root";
        String password = "1234";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("2. MYSQL 연결 성공");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

