package game.server;

import game.client.Connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientConnection implements Runnable {
    // TODO tirar o connection daqui e fazer o server conhecer so esse aqui

//    private Socket clientSocket;
    private static List<ClientConnection> connections = MainThread.connections;

    PrintWriter out;
    BufferedReader in;

    protected ClientConnection(Socket client) {
//        this.clientSocket = client;
        try {
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            MainThread.connections.add(this);
            System.out.println("Added a player");

//            MainThread.broadcastToClients("AAAAAAAAAAAA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for(ClientConnection c : connections) {
            c.sendMessage("Eae men");
//            String name = c.readMessage();
//            System.out.println("Player "+ name + " added.");
        }
    }

    protected String readMessage() {
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

    protected void sendMessage(String message) {
        out.write(message);
        out.flush();
    }


}
