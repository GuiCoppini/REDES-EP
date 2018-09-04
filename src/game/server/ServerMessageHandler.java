package game.server;

public class ServerMessageHandler {
    static void handleIncomingMessage(String message) {
        String[] messageParts = message.split(",");
        switch (messageParts[0]) {
            case("coord"):
                System.out.println("");
        }
    }
}
