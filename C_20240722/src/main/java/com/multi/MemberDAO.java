package com.multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
    public void delete(String id) throws Exception {
        // 1. 드라이버(커넥터) 설정
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버 설정 ok....");
        // 2. db연결(shop, root, 1234)
        String url = "jdbc:mysql://localhost:3306/shop";
        String user = "root";
        String password = "1234";
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("2. DB연결 ok....");
        // 3. sql문 생성
        String sql = "delete from member where id = ?";
        // SQL문장을 담당하는 객체로 만들어주어야 자바는 인식
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        System.out.println("3. SQL문 생성 ok....");
        // 4. sql문 전송
        ps.executeUpdate();
        System.out.println("4. SQL문 전송 ok....");
        ps.close();
        con.close();
    }

    public int insert(MemberVO bag) throws Exception {
        // 1. 드라이버(커넥터) 설정
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버 설정 ok....");
        // 2. db연결(shop, root, 1234)
        String url = "jdbc:mysql://localhost:3306/shop";
        String user = "root";
        String password = "1234";
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("2. DB연결 ok....");
        // 3. sql문 생성
        String sql = "insert into member values (?, ?, ?, ?)";
        // String sql = "delete from member where id = '700' ";
        // SQL문장을 담당하는 객체로 만들어주어야 자바는 인식
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, bag.getId());
        ps.setString(2, bag.getPw());
        ps.setString(3, bag.getName());
        ps.setString(4, bag.getTel());
        System.out.println("3. SQL문 생성 ok....");
        // 4. sql문 전송
        int result = ps.executeUpdate();
        System.out.println("4. SQL문 전송 ok....");
        ps.close();
        con.close();

        return result;
    }

    // 기능하나씩 메서드 하나 구현(검색 1명 기능-row 1개)
    public MemberVO one(String id) {
        // 검색한 결과를 리턴해주어야 함.
        System.out.println(id);
        MemberVO bag = null;
        try {
            // 1. 드라이버 설정 - 드라이버(커넥터) 로딩
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("1. 드라이버 설정 성공.@@@@");
            // 2. db연결(shop, root, 1234)
            String url = "jdbc:mysql://localhost:3306/shop";
            String user = "root";
            String password = "1234";
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결 성공.@@@@");
            // 3. sql문을 만든다.
            String sql = "select * from member where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            System.out.println("3. sql문 생성 성공.@@@@");
            // 4. sql문을 전송한다.
            ResultSet rs = ps.executeQuery();
            System.out.println("4. sql문 전송 성공.@@@@");
            // 검색결과가 있는지 체크해주어야 함. rs.next()
            if (rs.next()) { // true이면 있다라는 의미, false이면 없다라는 의미
                System.out.println("검색결과 있음. 성공.@@@@");
                String id2 = rs.getString(1); // id
                String pw = rs.getString(2); // pw
                String name = rs.getString(3); // name
                String tel = rs.getString(4); // tel
                // 5. 가방을 만들자.
                bag = new MemberVO();
                System.out.println("가방만들기 성공.@@@@");
                bag.setId(id2);
                bag.setPw(pw);
                bag.setName(name);
                bag.setTel(tel);
            } else {
                System.out.println("검색결과 없음.");
            }
            // 자원 해제
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bag; //가방을 전달
    }

    public int login(MemberVO bag) {
        int result = 0; // 없는 경우
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("1. 드라이버 설정 성공.@@@@");
            // 2. db연결(shop, root, 1234)
            String url = "jdbc:mysql://localhost:3306/shop";
            String user = "root";
            String password = "1234";
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결 성공.@@@@");
            // 3. sql문을 만든다.
            String sql = "select * from member where id = ? and pw = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bag.getId());
            ps.setString(2, bag.getPw());
            System.out.println("3. sql문 생성 성공.@@@@");
            // 4. sql문을 전송한다.
            ResultSet rs = ps.executeQuery();
            System.out.println("4. sql문 전송 성공.@@@@");
            // 검색결과가있는지 체크해주어야함. rs.next()
            if (rs.next()) { // true이면 있다라는 의미
                System.out.println("검색결과 있음. 성공.@@@@");
                result = 1;
            }
            // 자원 해제
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<MemberVO> list() {
        ArrayList<MemberVO> list = new ArrayList<>();
        try {
            //1. driver로딩
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("1. 드라이버 설정 성공.@@@@");
            // 2. db연결(shop, root, 1234)
            String url = "jdbc:mysql://localhost:3306/shop";
            String user = "root";
            String password = "1234";
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결 성공.@@@@");
            // 3. sql문을 만든다.
            String sql = "select * from member";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("3. sql문 생성 성공.@@@@");
            // 4. sql문을 서버에 보낸다. --> 결과가 어떻게 되었는지 자바프로그램 알려줌.
            ResultSet rs = ps.executeQuery();
            System.out.println("4. sql문 전송 성공.@@@@");

            // 결과를 검색해서 list에 넣어줌
            while (rs.next()) { // 결과값이 true이면!!
                String id2 = rs.getString(1); // 컬럼의 순서 1번 id값 추출
                String pw = rs.getString(2);
                String name = rs.getString(3);
                String tel = rs.getString(4);

                MemberVO bag = new MemberVO();
                bag.setId(id2);
                bag.setPw(pw);
                bag.setName(name);
                bag.setTel(tel);
                list.add(bag);
            }
            // 자원 해제
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
