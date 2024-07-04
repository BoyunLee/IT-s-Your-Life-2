import java.util.Arrays;
import java.util.List;

public class Q3 {
    String name;
    String department;
    int age;

    Q3(String name, String department, int age) {
        this.name = name;
        this.department = department;
        this.age = age;
    }

    public String getName() {return name;}
    public String getDepartment() {return department;}
    public int getAge() {return age;}

    public static void main(String[] args) {
        List<Q3> employees = Arrays.asList(
                new Q3("Michael", "Manager", 35),
                new Q3("Sarah", "HR", 32),
                new Q3("Roger", "Manager", 44),
                new Q3("Mike", "Manager", 30),
                new Q3("Maureen", "IT", 37)
        );

        double total = employees.stream()
                .filter(e -> e.getDepartment().equals("Manager"))
                .mapToInt(Q3::getAge)
                .average()
                .orElse(0);

        System.out.println(total);
    }
}
