package game.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5555);

            for (int i = 0; i<2; i++) {
                System.out.println("Waiting connection");
                Socket clientSocket = serverSocket.accept();

                System.out.println("Client connected");
                Thread thread = new Thread(new ConnectionHandler(clientSocket));
                thread.start();
            }

            ConnectionHandler.broadcast("EAE BOYS");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
