package Q3;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private int maxStudents;
    private int currentStudents;
    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;

    public Course(String courseName, int maxStudents) {
        this.courseName = courseName;
        this.maxStudents = maxStudents;
        this.currentStudents = 0;
        this.students = new ArrayList<>();
        this.subjects = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (currentStudents < maxStudents) {
            students.add(student);
            currentStudents++;
        } else {
            System.out.println("Cannot add student: course is full.");
        }
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void printCourseInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Course Name: ").append(courseName).append("\n")
                .append("Max Students: ").append(maxStudents).append("\n")
                .append("Current Students: ").append(currentStudents).append("\n")
                .append("Students:\n");

        for (Student student : students) {
            info.append("  - ").append(student).append("\n");
        }

        info.append("Subjects:\n");
        for (Subject subject : subjects) {
            info.append("  - ").append(subject).append("\n");
        }

        System.out.println(info.toString());
    }
}
