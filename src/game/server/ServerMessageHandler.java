package game.server;

import game.game.Player;

public class ServerMessageHandler {
    static void handleIncomingMessage(Object message, ClientConnection c) {
        if(message instanceof String) {
            String[] messageParts = ((String) message).split(",");
            switch(messageParts[0]) {
                case ("coord"):
                    System.out.println("X = "+messageParts[1] + " | Y = " + messageParts[2]);
                    MainThread.room.getTable().increment(Integer.valueOf(messageParts[1]), Integer.valueOf(messageParts[2]));

                    MainThread.broadcastToClients(MainThread.room.getTable());
                    break;
                case ("login"):
                    String nickname = messageParts[1];
                    Player joined = new Player(nickname);
                    MainThread.players.put(joined.getId(), c);

                    c.getConnection().sendMessage("play");

                    MainThread.broadcastToClients("Player " + nickname + " joined.");
            }
        }
    }
}
