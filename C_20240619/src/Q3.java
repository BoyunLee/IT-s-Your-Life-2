import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] A = new int[1000];
        int[] B = new int[1000];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            A[i] = rand.nextInt(4) + 1;
        }
        for (int i = 0; i < B.length; i++) {
            B[i] = rand.nextInt(4) + 1;
        }

        System.out.println("Index\tCorrect Answer\tMy Answer");
        for (int i = 0; i < A.length; i++) {
            System.out.println(i + "\t\t" + A[i] + "\t\t\t\t" + B[i]);
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                count += 1;
            }
        }
        System.out.println("맞춘 갯수 : " + count);
    }
}
