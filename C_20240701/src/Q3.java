import java.util.ArrayList;

public class Q3 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("자바");

        list.add(new Q3());
        list.add(new ArrayList());

        // 강제형변환: list.get(0) 반환 타입은 Object, 이를 String으로 캐스팅
        String s = (String)list.get(0);

        // 박싱: 기본 타입 int가 Integer 객체로 변환되어 추가
        // 자바의 오토박싱(auto-boxing) 기능을 통해 이루어짐.
        list.add(100);

        // 언박싱: list.get(3) 반환 타입은 Object, 이를 Integer로 캐스팅하고 int로 언박싱
        // 자바의 오토언박싱(auto-unboxing) 기능을 통해 이루어짐.
        int i = (Integer)list.get(3);
    }
}
