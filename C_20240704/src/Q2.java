import java.util.Arrays;
import java.util.OptionalInt;

public class Q2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int number1 = Arrays.stream(arr)
                .filter(n -> n % 2 != 0)
                .sum();

        int[] arr2 = {5, 3, 10, 40, 2};
        int number2 = Arrays.stream(arr2)
                .max()
                .getAsInt();

        int[] arr3 = {1, 2, 2, 5, 5, 6, 7, 7, 9, 10};
        int[] number3 = Arrays.stream(arr3)
                .filter(n -> n > 5)
                .toArray();

        System.out.println(number1);
        System.out.println(number2);
        System.out.println(Arrays.toString(number3));
    }
}
