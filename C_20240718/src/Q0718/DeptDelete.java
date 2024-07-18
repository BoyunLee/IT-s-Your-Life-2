package Q0718;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeptDelete {
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
            selectDept(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void selectDept(Connection connection) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("deptNo >>");
        int deptNo = scanner.nextInt();


        String sql = "Delete from dept where deptNo = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, deptNo);
            System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("4. SQL문 MYSQL로 보내기 성공");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("삭제 성공");
            scanner.close();
        }
    }
}
