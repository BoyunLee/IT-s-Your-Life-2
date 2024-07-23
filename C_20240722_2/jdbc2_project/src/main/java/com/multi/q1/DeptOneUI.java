package com.multi.q1;

import java.util.Scanner;

public class DeptOneUI {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("deptNo >> ");
            int deptNo = sc.nextInt();

            DeptDAO dao = new DeptDAO();
            DeptVO vo = dao.one(deptNo);
            if (vo != null) {
                System.out.println("검색 결과 >> deptNo = " + vo.getdeptNo());
                System.out.println("검색 결과 >> deptName = " + vo.getdname());
                System.out.println("검색 결과 >> Loc = " + vo.getloc());
            }else {
                System.out.println("검색결과 없음");
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
