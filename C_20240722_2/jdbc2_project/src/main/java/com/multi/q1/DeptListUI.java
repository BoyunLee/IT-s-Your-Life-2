package com.multi.q1;

import java.util.ArrayList;

public class DeptListUI {
    public static void main(String[] args) {
        DeptDAO dao = new DeptDAO();
        ArrayList<DeptVO> list = dao.list();
        if (list.size() != 0) {
            for (DeptVO vo : list) {
                System.out.println("검색 결과 >> deptNo = " + vo.getdeptNo());
                System.out.println("검색 결과 >> deptName = " + vo.getdname());
                System.out.println("검색 결과 >> Loc = " + vo.getloc());
                System.out.println("----------------------------------");
            }
        }else {
            System.out.println("검색결과 없음");
        }
    } //main
} //class


