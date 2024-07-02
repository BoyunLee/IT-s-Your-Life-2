package Q3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(7100);
        byte[] data = new byte[256];

        DatagramPacket packet = new DatagramPacket(data, data.length);
        System.out.println("받는 쪽 소켓 시작");
        System.out.println("받을 준비 끝");
        socket.receive(packet);

        System.out.println("받은 데이터 : " + new String(data).substring(0, 20));

        socket.close();
    }
}
