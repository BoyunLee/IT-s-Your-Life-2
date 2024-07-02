package Q2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        int count = 0;
        ServerSocket server = new ServerSocket(9000);
        System.out.println("서버 소켓 시작됨.");
        System.out.println("클라이언트의 요청을 기다리는 중...");
        while(true) {
            Socket socket = server.accept();
            count ++;
            System.out.println("서버가" + count + "개의 클라이언트 요청을 승인함.");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String data = "I am a java programmer!!";
            out.println(data);
            out.close();
            socket.close();
        }
    }
}
