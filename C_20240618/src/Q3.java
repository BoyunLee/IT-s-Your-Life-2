package C_20240618;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int student = 0; // 학생 수를 저장할 변수
        int[] scores = null; // 점수 배열 초기화

        while (true) {
            System.out.println("=====================================================" +
                    "\n1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료" +
                    "\n=====================================================");

            System.out.print("선택 > ");
            int a = sc.nextInt();

            if (a == 1) {
                System.out.print("학생수 > ");
                student = sc.nextInt(); // 학생 수 입력
                scores = new int[student]; // 학생 수에 따른 점수 배열 생성
            } else if (a == 2) {
                if (scores == null) {
                    System.out.println("학생수가 입력되지 않았습니다.");
                } else {
                    for (int i = 0; i < student; i++) {
                        System.out.print("scores[" + i + "] > ");
                        scores[i] = sc.nextInt(); // 점수 입력
                    }
                }
            } else if (a == 3) {
                if (scores == null) {
                    System.out.println("점수가 입력되지 않았습니다.");
                } else {
                    for (int i = 0; i < student; i++) {
                        System.out.println("scores[" + i + "] = " + scores[i]);
                    }
                }
            } else if (a == 4) {
                if (scores == null) {
                    System.out.println("점수가 입력되지 않았습니다.");
                } else {
                    int maxScore = Integer.MIN_VALUE; // 최대값 초기화
                    for (int i = 0; i < student; i++) {
                        if (scores[i] > maxScore) {
                            maxScore = scores[i]; // 최대값 업데이트
                        }
                    }
                    double totalScore = 0;
                    for (int i = 0; i < student; i++) {
                        totalScore += scores[i];
                        }
                    totalScore = totalScore / student;
                    System.out.println("최고 점수 : " + maxScore);
                    System.out.println("평균 점수 : " + totalScore);
                }
            } else if (a == 5) {
                System.out.println("프로그램 종료");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }

        sc.close(); // 스캐너 닫기
    }
}
