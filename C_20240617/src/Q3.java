package C_20240617;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("여행지역을 입력하세요: ");
        String a = sc.nextLine();

        System.out.print("1인당 경비를 입력하세요: ");
        double b = sc.nextDouble();

        System.out.print("여행 인원을 입력하세요: ");
        int c = sc.nextInt();

        System.out.print("할인율(%)를 입력하세요: ");
        double d = sc.nextDouble();

        sc.nextLine();

        System.out.print("VIP 여부 (true/false) 를 입력하세요: ");
        String e = sc.nextLine();

        System.out.print("당부의 말을 입력하세요: ");
        String f = sc.nextLine();

        double g = 0.0;
        if (e.equalsIgnoreCase("true")) {
            g = 5.0;
        }

        double discount = d + g;

        double total = b * c;

        double minus = total * discount / 100.0;

        double finish = total - minus;


        sc.close();

        System.out.print("===== 여행 경비 계산 결과 =====");
        System.out.print("\n여행지역 : " + a);
        System.out.print("\n1인당 경비 : " + b + "원");
        System.out.print("\n여행 인원 : " + c + "명");
        System.out.print("\n기본 할인율 : " + d + "%");
        System.out.print("\nVIP 추가 할인율 : " + g + "%");
        System.out.print("\n최종 할인율 : " + discount + "%");
        System.out.print("\n총 경비 : " + total + "원");
        System.out.print("\n할인 금액 : " + minus + "원");
        System.out.print("\n할인 후 총 경비 : " + finish + "원");
        System.out.print("\n당부의 말 : " + f);

    }
}
