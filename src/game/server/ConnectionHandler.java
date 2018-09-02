package game.server;

import game.client.Connection;
import game.game.Player;
import game.game.Room;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ConnectionHandler implements Runnable {
    private Socket clientSocket;
    public static Room room = new Room();
    private static List<Connection> connections = new ArrayList<>();

    public ConnectionHandler(Socket client) {
        this.clientSocket = client;
        this.connections.add(new Connection(clientSocket));
    }

    public static void broadcast(String message) {
        for(Connection c : connections)
            c.sendMessage("BROADCAST: " + message);
    }

    @Override
    public void run() {
        for(Connection c : connections) {
            String name = c.readMessage();
            MainGame.room.addPlayer(new Player(name));
            System.out.println("Player "+ name + " added.");
        }
    }
}
