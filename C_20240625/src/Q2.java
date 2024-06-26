import java.util.Scanner;
class Day {
    // 하는 일을 저장하는 변수
    private String activity;

    // 활동에 소요된 시간을 저장하는 변수
    private int hours;

    // 활동이 이루어진 장소를 저장하는 변수
    private String location;

    // 모든 인스턴스가 공유하는 총 활동 시간을 저장하는 정적 변수
    private static int totalHours = 0;

    // 생성된 인스턴스의 수를 저장하는 정적 변수
    private static int numberOfDays = 0;

    // Q2 클래스의 생성자
    public Day(String activity, int hours, String location) {
        this.activity = activity;     // 하는 일 초기화
        this.hours = hours;           // 활동 소요 시간 초기화
        this.location = location;     // 활동 장소 초기화

        totalHours += hours;          // 총 활동 시간 업데이트
        numberOfDays++;               // 생성된 인스턴스 수 업데이트
    }

    // 총 활동 시간을 반환하는 정적 메서드
    public static int getTotalHours() {
        return totalHours;
    }

    // 평균 활동 시간을 반환하는 정적 메서드
    public static double getAverageHours() {
        return (double) totalHours / numberOfDays;  // 총 활동 시간을 인스턴스 수로 나누어 평균 계산
    }

    // 각 일자의 활동 정보를 출력하는 메서드
    public void printDayInfo() {
        System.out.println("하는일 : " + activity + ", 시간 : " + hours + ", 장소 : " + location);
    }
}

public class Q2 {
    public static void main(String[] args) {
        Day day1 = new Day("자바공부", 10, "강남");
        Day day2 = new Day("여행", 15, "강원도");
        Day day3 = new Day("운동", 11, "피트니스");

        System.out.println("전체 하는 일의 시간은 : " + Day.getTotalHours());
        System.out.println("평균 하는 일의 시간은 : " + Day.getAverageHours());

        System.out.println("매일 무엇을 얼마나 어디에서 했는지 프린트 :");
        day1.printDayInfo();
        day2.printDayInfo();
        day3.printDayInfo();
    }
}


