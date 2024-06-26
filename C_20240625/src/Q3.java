class Employee {
    private String name;

    private int age;

    private String gender;

    private static int totalAge = 0;

    private static int totalMember = 0;

    public Employee(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;

        totalAge += age;
        totalMember++;
    }

    public static int getTotalMember() {
        return totalMember;
    }

    // 평균 나이를 반환하는 정적 메서드
    public static double getTotalAge() {
        return (double) totalAge / totalMember;  // 총 활동 시간을 인스턴스 수로 나누어 평균 계산
    }

    // 각 일자의 활동 정보를 출력하는 메서드
    public void printMemberInfo() {
        System.out.println("이름 : " + name + ", 나이 : " + age + ", 성별 : " + gender);
    }
}

public class Q3 {
    public static void main(String[] args) {
        Employee work1 = new Employee("홍길동", 25, "여");
        Employee work2 = new Employee("김길동", 24, "남");
        Employee work3 = new Employee("송길동", 26, "여");

        System.out.println("우리 회사의 직원 수는? : " + Employee.getTotalMember());
        System.out.println("우리 회사의 직원 각각의 정보를 프린트 : ");
        work1.printMemberInfo();
        work2.printMemberInfo();
        work3.printMemberInfo();

        System.out.println("우리 회사의 직원의 평균 나이를 프린트 : " + Employee.getTotalAge());

    }
}
