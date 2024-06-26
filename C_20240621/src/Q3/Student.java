package Q3;

public class Student {
    private int id;
    private String name;
    private int grade;
    private String department;

    public Student(int id, String name, int grade, String department) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.department = department;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade + ", Department: " + department;
    }

    public String getName() {
        return name;
    }
}

