package game.server;

import game.game.Room;

import java.util.HashMap;
import java.util.Map;

public class MainThread {
    private static Server server;
    protected static Room room = new Room();

    // map de players por ID
    protected static Map<Integer, ClientConnection> players = new HashMap<>();

    public static void main(String[] args) {
        runServerSocket();

    }

    private static void runServerSocket() {
        server = new Server();

        Thread thread = new Thread(server);
        thread.start();
    }

    public static void broadcastToClients(String message) {
        for(Integer id : players.keySet()) {
            System.out.println("Sending message to player of ID="+id);
            players.get(id).getConnection().sendMessage("broadcast,"+message);
        }
    }
}
