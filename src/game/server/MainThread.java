package game.server;

import java.util.ArrayList;
import java.util.List;

import game.client.Connection;
import game.game.Room;

public class MainThread {
    private static Server server;
    protected static Room room = new Room();
    protected static List<ClientConnection> connections = new ArrayList<>();

    public static void main(String[] args) {
        runServerSocket();


    }

    private static void runServerSocket() {
        server = new Server();

        Thread thread = new Thread(server);
        thread.start();
    }

    public static void broadcastToClients(String message) {
        for(ClientConnection c : connections)
            c.sendMessage("BROADCAST: " + message);
    }
}
