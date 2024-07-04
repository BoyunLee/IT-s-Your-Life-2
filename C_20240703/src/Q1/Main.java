package Q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ObjectFactory factory = new ObjectFactory();

        while (true) {
            System.out.print("어떤 객체를 생성하시겠습니까? (Apple, Banana, Ice) : ");
            String input = scanner.nextLine();

            Object obj = factory.createObject(input);

            if (obj == null) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

        scanner.close();
    }
}
