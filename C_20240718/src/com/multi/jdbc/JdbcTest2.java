package com.multi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest2 {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/edudb";
        String username = "root";
        String password = "1234";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection established");
            seletEmp(connection);

        } catch (Exception e) {
            System.out.println("Could not establish database connection");
            e.printStackTrace();
        }
    }

    public static void seletEmp(Connection connection) {
        // 연결 객체
        // System.out.println(connection);

        String sql = "select EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO from emp";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EmpVO empVO = new EmpVO();
                empVO.setEmpno(resultSet.getInt("EMPNO"));
                empVO.setEname(resultSet.getString("ENAME"));
                empVO.setJob(resultSet.getString("JOB"));
                empVO.setComm(resultSet.getInt("comm"));
                empVO.setDeptno(resultSet.getInt("deptno"));
                empVO.setMgr(resultSet.getInt("mgr"));
                empVO.setHiredate(resultSet.getString("hiredate"));
                empVO.setSal(resultSet.getInt("sal"));
                System.out.println(empVO);

            }
//            if (resultSet.next()) {
//                int empno = resultSet.getInt(1);
//                System.out.println(empno);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
