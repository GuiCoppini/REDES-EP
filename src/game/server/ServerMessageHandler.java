package game.server;

import game.game.Player;

public class ServerMessageHandler {
    static void handleIncomingMessage(String message, ClientConnection c) {
        String[] messageParts = message.split(",");
        switch (messageParts[0]) {
            case("coord"):
                System.out.println("");
                break;
            case("login"):
                String nickname = messageParts[1];
                Player joined = new Player(nickname);
                MainThread.players.put(joined.getId(), c);

                MainThread.broadcastToClients("Player "+ nickname + " joined.");
        }
    }
}
