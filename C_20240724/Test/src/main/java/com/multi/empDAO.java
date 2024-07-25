package com.multi;

import java.sql.*;
import java.util.ArrayList;

public class empDAO {
    public empVO selectOne(int id) {
        empVO emp = new empVO();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/company";
            String user = "root";
            String password = "1234";

            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "select * from emp where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setOffice(rs.getString("office"));
                emp.setPhone(rs.getString("phone"));
            } else {
                System.out.println("해당 ID 없음");
            }
            conn.close();
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    public ArrayList<empVO> selectAll() {
        ArrayList<empVO> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/company";
            String user = "root";
            String password = "1234";

            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from emp";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                empVO emp = new empVO();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setOffice(rs.getString("office"));
                emp.setPhone(rs.getString("phone"));
                list.add(emp);
            }
            conn.close();
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int insert(empVO emp) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/company";
            String user = "root";
            String password = "1234";
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into emp values(?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setInt(3, emp.getAge());
            ps.setString(4, emp.getOffice());
            ps.setString(5, emp.getPhone());

            int result = ps.executeUpdate();
            conn.close();
            ps.close();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(empVO emp) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/company";
            String user = "root";
            String password = "1234";
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "update emp set name=?,age=?,office=?,phone=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getName());
            ps.setInt(2, emp.getAge());
            ps.setString(3, emp.getOffice());
            ps.setString(4, emp.getPhone());
            ps.setInt(5, emp.getId());

            int result = ps.executeUpdate();
            conn.close();
            ps.close();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/company";
            String user = "root";
            String password = "1234";

            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "delete from emp where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            int result = ps.executeUpdate();
            conn.close();
            ps.close();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
