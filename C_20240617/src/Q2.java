package C_20240617;

import javax.swing.*;

public class Q2 {
    public static void main(String[] args) {
        String mathscore1 = JOptionPane.showInputDialog("첫 번째 수학 점수를 입력하세요 : ");
        String mathscore2 = JOptionPane.showInputDialog("두 번째 수학 점수를 입력하세요 : ");
        String englishscore1 = JOptionPane.showInputDialog("첫 번째 영어 점수를 입력하세요 : ");
        String englishscore2 = JOptionPane.showInputDialog("두 번째 영어 점수를 입력하세요 : ");

        int m1 = Integer.parseInt(mathscore1);
        int m2 = Integer.parseInt(mathscore2);
        int e1 = Integer.parseInt(englishscore1);
        int e2 = Integer.parseInt(englishscore2);

        // 수학 평균 계산
        double mathAverage = (m1 + m2) / 2.0;

        // 영어 평균 계산
        double englishAverage = (e1 + e2) / 2.0;

        // 메시지 다이얼로그로 평균 점수를 보여줌
        JOptionPane.showMessageDialog(null, "수학 평균 점수: " + mathAverage + "\n영어 평균 점수: " + englishAverage);

    }
}
