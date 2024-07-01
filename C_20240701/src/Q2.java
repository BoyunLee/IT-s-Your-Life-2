import java.util.HashMap;

public class Q2 {
    public static void main(String[] args) {
        HashMap system = new HashMap();
        system.put(100, "김데이");
        system.put(200, "김사전");
        system.put(300, "김구조");
        system.put(400, "김자료");

        system.remove(200);
        system.replace(300, "김충성");

        for(Object key : system.keySet()){
            System.out.println("고객번호: " + key + ", 이름: " + system.get(key));
        }
    }
}
