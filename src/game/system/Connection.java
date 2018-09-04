package game.system;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {
    PrintWriter out;
    BufferedReader in;
    Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
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
                    return input;
                }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Deu pau");
        }
    }

    public void sendMessage(String message) {
        out.write(message + "\n");
        out.flush();
    }
}
