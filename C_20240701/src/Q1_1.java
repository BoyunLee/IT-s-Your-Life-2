import java.util.ArrayList;

public class Q1_1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("박소정");
        list.add("김경민");
        list.add("소지현");
        list.add("김개빈");

        list.remove(1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "등: " + list.get(i));
        }
    }
}
