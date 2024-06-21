import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] seats = new int[10];
        int totalBooked = 0;
        int pricePerSeat = 10000;

        while (true) {
            System.out.println("현재 좌석 상태:");
            for (int i = 0; i < seats.length; i++) {
                System.out.print((i + 1) + ":" + seats[i] + " ");
            }
            System.out.println();

            System.out.print("예매할 좌석 번호를 입력하세요 (종료하려면 0 입력): ");
            int seatNumber = scanner.nextInt();

            if (seatNumber == 0) {
                break;
            } else if (seatNumber < 1 || seatNumber > 10) {
                System.out.println("유효하지 않은 좌석 번호입니다. 1에서 10 사이의 번호를 입력하세요.");
            } else if (seats[seatNumber - 1] == 1) {
                System.out.println("이미 예매된 좌석입니다. 다른 좌석을 선택하세요.");
            } else {
                seats[seatNumber - 1] = 1;
                totalBooked++;
                System.out.println(seatNumber + "번 좌석이 예매되었습니다.");
            }
        }

        int totalAmount = totalBooked * pricePerSeat;
        System.out.println("예매된 좌석 수: " + totalBooked);
        System.out.println("총 예매 금액: " + totalAmount + "원");

        scanner.close();
    }
}

