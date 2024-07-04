import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q3 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "Hi", "smile");

        for (int i = 0; i < words.size(); i++) {
            words.set(i, words.get(i).toUpperCase());
        }

        List<String> bigWords = words.stream()
                .filter(word -> word.length() > 4)
                .collect(Collectors.toList());
        System.out.println(bigWords);

        List<String> nWords = words.stream()
                .map(number -> number + "님")
                .collect(Collectors.toList());
        System.out.println(nWords);
    }
}
