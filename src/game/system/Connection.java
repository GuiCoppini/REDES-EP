package game.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {
    ObjectOutputStream out;
    ObjectInputStream in;
    Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object readMessage() {
        Object input;
        try {
            while (true)
                if ((input = in.readObject()) != null) {
                    return input;
                }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Deu pau");
        }
    }

    public void sendMessage(Object message) {
        try {
//            if(message instanceof String) message += "\n";
            out.writeObject(message);
            out.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
