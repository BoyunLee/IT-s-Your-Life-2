import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q1 {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("사과", "바나나", "포도", "바나나", "멜론");
        List<String> getNumbers = numbers.stream()
                                            .distinct()
                                            .toList();

        System.out.println(getNumbers);
    }
}
