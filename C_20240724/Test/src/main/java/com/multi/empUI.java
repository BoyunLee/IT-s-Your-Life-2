package com.multi;

import java.util.ArrayList;
import java.util.Scanner;

public class empUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        empDAO dao = new empDAO();
        empVO vo = new empVO();

        while (true) {
            System.out.println("1. SelectOne 2. SelectAll 3. Insert 4. Updated 5. Delete 6. Exit");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("ID : ");
                    vo = dao.selectOne(sc.nextInt());
                    if (vo.getId() != 0) {
                        System.out.println(vo);
                    }
                    break;
                case 2:
                    ArrayList<empVO> list = dao.selectAll();
                    System.out.println(list);
                    break;
                case 3:
                    System.out.print("ID 입력 : ");
                    vo.setId(sc.nextInt());
                    System.out.print("Name 입력 : ");
                    vo.setName(sc.next());
                    System.out.print("Age 입력 : ");
                    vo.setAge(sc.nextInt());
                    System.out.print("Office 입력 : ");
                    vo.setOffice(sc.next());
                    System.out.print("Phone 입력 : ");
                    vo.setPhone(sc.next());

                    if(dao.insert(vo) ==1) {
                        System.out.println("insert 성공");
                    } else {
                        System.out.println("실패");
                    }
                    break;
                case 4:
                    System.out.print("ID 입력 : ");
                    vo.setId(sc.nextInt());
                    System.out.print("Name 입력 : ");
                    vo.setName(sc.next());
                    System.out.print("Age 입력 : ");
                    vo.setAge(sc.nextInt());
                    System.out.print("Office 입력 : ");
                    vo.setOffice(sc.next());
                    System.out.print("Phone 입력 : ");
                    vo.setPhone(sc.next());

                    if(dao.update(vo) == 1) {
                        System.out.println("update 성공");
                    } else {
                        System.out.println("실패");
                    }
                    break;
                case 5:
                    System.out.println("ID 입력 : ");
                    int id = sc.nextInt();
                    vo.setId(id);

                    if(dao.delete(id) == 1) {
                        System.out.println("delete 성공");
                    } else {
                        System.out.println("실패");
                    }
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                    System.out.println("종료");
            }
        }
    }
}
