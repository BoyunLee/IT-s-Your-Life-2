import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        String[] title = new String[] {"Quiet Place", "Avengers: Endgame", "Inception", "Parasite", "Interstellar"};
        int[] price = new int[] {15000, 23000, 18000, 21000, 19000};

        System.out.println("네이버 시리즈 온 실시간 영화 목록:");
        for (int i = 0; i < title.length; i++) {
            System.out.println((i+1) + ". " + title[i] + " - 가격 : " + price[i] + "원");
        }
        System.out.println("정보를 확인하고 싶은 영화 번호를 선택하세요 (1 - " + title.length + ") :");

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        if (a >= 1 && a <= title.length) {
            int index = a - 1;
            System.out.println("선택한 영화 : " + title[index]);
            System.out.println("가격 : " + price[index] + "원");
        } else {
            System.out.println("잘못된 번호를 선택하셨습니다.");
        }
        scanner.close();
    }
}

