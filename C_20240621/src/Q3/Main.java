package Q3;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Kim", 2, "Computer Science");
        Student student2 = new Student(2, "Park", 3, "Computer Science");

        Subject subject1 = new Subject("Java", 100);
        Subject subject2 = new Subject("Python", 100);

        Course course = new Course("Programming", 5);
        course.addStudent(student1);
        course.addStudent(student2);

        course.addSubject(subject1);
        course.addSubject(subject2);

        course.printCourseInfo();
    }
}
