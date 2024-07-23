package com.multi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest2 {
    public static void main(String[] args) {
        String jdbcurl = "jdbc:mysql://localhost:3306/edudb";
        String username = "jdbctest";
        String password = "jdbctest";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//동적인 드라이브 로딩
            Connection connection= DriverManager.getConnection(jdbcurl, username, password);
            System.out.println("Database connection established");
            selectEmp(connection);
        }catch (Exception e){
            System.out.println("Could not establish database connection");
            e.printStackTrace();
        }
    }
    public static void selectEmp( Connection connection){
        //연결객체
        //System.out.println(connection);연결 객체를 확인
        String sql = "select EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO from emp";
        try {
            //운반객체
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet resultSet= preparedStatement.executeQuery();
            // while(resultSet.next()){}
            // if(resultSet.next()){
                  // int empno= resultSet.getInt(1);
                  // System.out.println(empno);
            //  }
            while(resultSet.next()){
                EmpVO empVO= new EmpVO();
                empVO.setEmpno(resultSet.getInt("empno"));
                empVO.setEname(resultSet.getString("ename"));
                empVO.setJob(resultSet.getString("job"));
                empVO.setComm(resultSet.getInt("comm"));
                empVO.setDeptno(resultSet.getInt("deptno"));
                empVO.setMgr(resultSet.getInt("mgr"));
                empVO.setHiredate(resultSet.getString("hiredate"));
                empVO.setSal(resultSet.getInt("sal"));
                System.out.println(empVO);
            }//while
            resultSet.close();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
