import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> newNumbers = numbers.stream()
                .filter(number -> number > 3)
                .collect(Collectors.toList());
        System.out.println(newNumbers);

        List<Integer> tenNumbers = numbers.stream()
                .map(number -> number * 10)
                .collect(Collectors.toList());
        System.out.println(tenNumbers);
    }
}
