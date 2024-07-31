package com.example.jsp02.common;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class dbTest {
    public static void main(String[] args) throws Exception {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into users values ('a','a','a','a')");
        int result = ps.executeUpdate();
        System.out.println("success");
    }
}
