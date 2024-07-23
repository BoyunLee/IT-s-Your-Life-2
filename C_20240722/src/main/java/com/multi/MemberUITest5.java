package com.multi;

import java.util.Scanner;

public class MemberUITest5 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디 입력: ");
        String id = scanner.nextLine();
        System.out.print("패스워드 입력: ");
        String pw = scanner.nextLine();

        // 입력한 데이터를 가지고 db에 넣읍시다!!
        // db의 member테이블에 넣고 싶어요!!
        // ==> MemberDAO사용하면 됨.
        MemberDAO dao = new MemberDAO();
        MemberVO bag = new MemberVO();
        bag.setId(id);
        bag.setPw(pw);
        int result = dao.login(bag);
        if (result == 0) {
            System.out.println("로그인 실패");
        } else {
            System.out.println("로그인 성공");
        }
        scanner.close();
    }
}
