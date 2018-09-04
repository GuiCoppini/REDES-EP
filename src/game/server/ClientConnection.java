package game.server;

import game.game.Player;
import game.system.Connection;

import java.net.Socket;

public class ClientConnection implements Runnable {

    private Connection connection;

    protected ClientConnection(Socket client) {
        this.connection = new Connection(client);
    }

    @Override
    public void run() {
        String[] firstTimeMessage = connection.readMessage().split(",");

        System.out.println("Rodando o run");
        // adiciona player ao pool principal
        Player joined = new Player(firstTimeMessage[1]);

        MainThread.players.put(joined.getId(), this);
        MainThread.broadcastToClients("Player: "+joined.getName()+ " joined.");
    }

    public Connection getConnection() {
        return connection;
    }
}
