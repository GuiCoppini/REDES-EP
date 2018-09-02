package game.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            while (true) {
                System.out.println("Awaiting connection");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                Thread thread = new Thread(new ConnectionHandler(clientSocket));
                thread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
