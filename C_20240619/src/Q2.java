import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        String[] menu = new String[] {"샌드위치", "바게트"};
        int[] price = new int[] {2000, 3500};
        int count1 = 0;
        int count2 = 0;
        int total = 0;

        while(true) {
            System.out.print("\n주문할 상품을 선택하세요 (");
            for (int i = 0; i < menu.length; i++) {
                System.out.print((i + 1) + " : " + menu[i] + ", ");
            }
            System.out.println("0 : 주문 종료 ) :");

            Scanner sc = new Scanner(System.in);
            int pick = sc.nextInt();

            if (pick == 0){
                System.out.print("최종 주문 내역 : ");
                System.out.print("\n샌드위치 : " + count1 + "개");
                System.out.print("\n바게트 : " + count2 + "개");
                total = count1 * price[0] + count2 * price[1];
                System.out.print("\n현재까지 총 주문 금액 : " + total + "원");
                break;
            } else if (pick == 1) {
                System.out.print("선택한 상품 : " + menu[0]);
                System.out.print("\n주문할 수량을 입력하세요 :");
                count1 += sc.nextInt();

                System.out.print("현재 주문 상황 : ");
                System.out.print("\n샌드위치 : " + count1 + "개");
                System.out.print("\n바게트 : " + count2 + "개");

                total = count1*price[0] + count2*price[1];

                System.out.print("\n현재까지 총 주문 금액 : " + total + "원");

            } else if (pick == 2) {
                System.out.print("선택한 상품 : " + menu[1]);
                System.out.print("\n주문할 수량을 입력하세요 :");
                count2 += sc.nextInt();

                System.out.print("현재 주문 상황 : ");
                System.out.print("\n샌드위치 : " + count1 + "개");
                System.out.print("\n바게트 : " + count2 + "개");

                total = count1 * price[0] + count2 * price[1];

                System.out.print("\n현재까지 총 주문 금액 : " + total + "원");
            }
        }

    }
}
