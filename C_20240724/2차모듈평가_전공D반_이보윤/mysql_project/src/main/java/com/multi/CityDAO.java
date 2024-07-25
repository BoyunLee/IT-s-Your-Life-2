package com.multi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//mySQLDB연결 처리 담당 클래스
public class CityDAO {
    private Connection conn;
    private String url = "jdbc:mysql://localhost:3306/world2";
    private String user = "root";
    private String password = "1234";

    //객체생성시 클래스로딩과 DB연결
    public CityDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("발생한 에러 정보>> " + e.getMessage());
        }
    }

    //city테이블에 데이터를 삽입 처리 기능 구현
    //문제 4-2. insert()메서드를 완성하여 데이터 삽입 처리를 구현하시오.
    //     조건1) try-catch를 이용하여 "하나 이상의 예외처리"를 하시오.
    //     조건2) db처리와 관련된 모든 객체에 대해 "자원해제 처리"를 하시오.
    //     조건3) city테이블에 넣을 데이터는 "sql문에 직접 필드 타입에 맞게 넣어" SQL문을 완성하시오.
    //     조건4) 해당 메서드에서 데이터 삽입 처리후 결과는 반환하지 않는다.

    public int insert() {

        //SQL문 완성
        String sql = "insert into city (name, countryCode, district, population) values ('Cairo', 'EGY', 'Cairo Governorate', 9500000)";

        /***********************************************
         * 구현 코드
         *
         *
         *
         */
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            int result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                ps.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    } //insert기능 구현

    //city테이블에서 검색하여 UI에 반환 처리 기능 구현
    //문제 5-1. select()메서드를 완성하여 데이터 검색 처리를 구현하시오.
    //   조건1)  try-catch를 이용하여 "하나 이상의 예외처리"를 하시오.
    //   조건2)  db처리와 관련된 모든 객체에 대해 "자원해제 처리"를 하시오.
    //   조건3)  city테이블에서 검색에 사용할 SQL문은
    //          CityUI.java에서 전달된 데이터를 이용하여 완성한다.
    //   조건4)  해당 메서드에서 데이터 검색 처리후 결과 목록은 List<CityVO>타입으로 반환한다.

    public List<CityVO> select(int ID) {

        //SQL문 완성
        String sql = "SELECT * FROM city WHERE ID >= ?";

        /***********************************************
         * 구현 코드
         *
         *
         *
         */
        List<CityVO> cityVOList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                CityVO cityVO = new CityVO();
                cityVO.setID(rs.getInt("ID"));
                cityVO.setName(rs.getString("NAME"));
                cityVO.setCountryCode(rs.getString("COUNTRYCODE"));
                cityVO.setDistrict(rs.getString("DISTRICT"));
                cityVO.setPopulation(rs.getInt("POPULATION"));
                cityVOList.add(cityVO);
            }
            return cityVOList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                rs.close();
                ps.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    } //select기능 구현
}
