package game.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {
    PrintWriter out;
    BufferedReader in;

    public Connection(Socket socket) {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readMessage() {
        String input;
        try {
            while (true)
                if ((input = in.readLine()) != null) {
                    System.out.println("Received message: " + input);
                    return readMessage();
                }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Deu pau");
        }
    }

    public void sendMessage(String message) {
        out.write(message);
    }
}
