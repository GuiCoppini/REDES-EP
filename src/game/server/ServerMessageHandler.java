package game.server;

import game.game.Player;
import game.system.Message;

public class ServerMessageHandler {

    static void handleIncomingMessage(Message message, ClientConnection c) {
        switch(message.getCommand()) {
            case ("coord"):
                int x = (int) message.getArguments().get(0);
                int y = (int) message.getArguments().get(1);
                System.out.println("X = " + x + " | Y = " + y);
                MainThread.room.getTable().increment(x, y);

//                MainThread.broadcastToClients(MainThread.room.getTable());
                break;
            case ("login"):
                String nickname = (String) message.getArguments().get(0);
                Player joined = new Player(nickname);
                MainThread.players.put(joined.getId(), c);

//                c.getConnection().sendMessage(new Message("play"));

                MainThread.broadcastToClients(new Message("print","Player " + nickname + " joined."));
        }
    }
}
