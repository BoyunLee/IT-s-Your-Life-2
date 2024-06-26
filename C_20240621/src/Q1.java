import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Q1 {
    private static final String ID = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 ID와 비밀번호 입력받기
        System.out.print("ID를 입력하세요: ");
        String inputId = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String inputPassword = scanner.nextLine();

        // ID와 비밀번호 검증
        if (ID.equals(inputId) && PASSWORD.equals(inputPassword)) {
            System.out.println("일기를 작성을 시작합니다.");
            writeDiary(scanner);
        } else {
            System.out.println("ID 또는 비밀번호가 잘못되었습니다.");
        }

        scanner.close();
    }

    private static void writeDiary(Scanner scanner) {
        // 날짜와 제목, 내용을 입력받기
        System.out.print("날짜를 입력하세요 (예 : 20240612) : ");
        String today = scanner.nextLine();
        System.out.print("제목을 입력하세요 : ");
        String title = scanner.nextLine();
        System.out.print("내용을 입력하세요 : ");
        String content = scanner.nextLine();

        String fileName = today + ".txt";

        // 파일에 날짜, 제목, 내용 저장
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("날짜: " + today + "\n");
            writer.write("제목: " + title + "\n");
            writer.write("내용: " + content + "\n");
            System.out.println("일기가 성공적으로 저장되었습니다. 파일명: " + fileName);
        } catch (IOException e) {
            System.out.println("파일을 저장하는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}

