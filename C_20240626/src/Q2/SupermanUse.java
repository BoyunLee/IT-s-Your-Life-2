package Q2;

public class SupermanUse {
    public static void main(String[] args) {
        // Superman 객체 생성
        Superman superman = new Superman("클라크 켄트", 30, 100, true);

        // 속성 설정 후 메서드 호출
        superman.eat();
        superman.run();
        superman.space();

        System.out.println(superman.toString());
    }
}
