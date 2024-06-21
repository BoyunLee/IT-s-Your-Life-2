import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        String[] subject = new String[] {"국어", "영어", "수학", "컴퓨터", "회화"};
        int[] first = new int[] {44, 66, 22, 99, 100};
        int[] second = first.clone();
        second[0] = 22;
        second[2] = 88;

        System.out.print("1학기 성적 : [");
        for (int i = 0; i < first.length; i++) {
            System.out.print(first[i]);
            if (i < first.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.print("2학기 성적 : [");
        for (int i = 0; i < second.length; i++) {
            System.out.print(second[i]);
            if (i < second.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int count = 0;
        for (int i = 0; i < first.length; i++) {
            if (first[i] == second[i]) {
                count++;
            }
        }
        System.out.println("\n1학기와 2학기 성적이 동일한 과목 수 : " + count);

        int count2 = 0;
        int index = 0;
        for (int i = 0; i < first.length; i++) {
            if (first[i] < second[i]) {
                count2++;
                index = i;
            }
        }
        System.out.println("1학기보다 성적이 오른 과목 수 : " + count2);

        if (count2 > 0) {
            System.out.println("성적이 오른 과목명 : " + subject[index]);
        }
    }
}
