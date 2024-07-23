package com.multi.q1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeptDAO {
    public DeptVO one(int deptNo) {
        DeptVO dept = new DeptVO();

        try {
            // 1.mysql8과 연결한 라이브러리 설정
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("1. MYSQL 자바 연결할 부품 설정 성공.");

            // 2.mysql8에 연결해보자.(java --- mysql)
            String url = "jdbc:mysql://localhost:3306/school2";
            String user = "root";
            String password = "1234";
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("2. MYSQL 연결 성공.");

            String sql = "select * from dept where deptNo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, deptNo);
            System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

            ResultSet result = ps.executeQuery();
            System.out.println("4. SQL문 MYSQL로 보내기 성공.");

            if (result.next()){
                dept = new DeptVO();
                dept.setdeptNo(result.getInt(1));
                dept.setdname(result.getString(2));
                dept.setloc(result.getString(3));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dept;
    }

    public ArrayList<DeptVO> list() {
        ArrayList<DeptVO> list = new ArrayList<>();

        try {
            // 1.mysql8과 연결한 라이브러리 설정
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("1. MYSQL 자바 연결할 부품 설정 성공.");

            // 2.mysql8에 연결해보자.(java --- mysql)
            String url = "jdbc:mysql://localhost:3306/school2";
            String user = "root";
            String password = "1234";
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("2. MYSQL 연결 성공.");

            String sql = "select * from dept";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

            ResultSet result = ps.executeQuery();
            System.out.println("4. SQL문 MYSQL로 보내기 성공.");

            while (result.next()){
                DeptVO dept = new DeptVO();
                dept.setdeptNo(result.getInt(1));
                dept.setdname(result.getString(2));
                dept.setloc(result.getString(3));
                list.add(dept);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

