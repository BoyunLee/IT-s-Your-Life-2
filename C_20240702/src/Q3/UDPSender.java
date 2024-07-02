package Q3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        InetAddress ip = InetAddress.getByName("127.0.0.1");
        String str = "I am a ai programmer";
        byte[] data = str.getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, ip, 7100);
        System.out.println("클라이언트 포트 >> " + packet.getPort());

        socket.send(packet);
        socket.close();
    }
}