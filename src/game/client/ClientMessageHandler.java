package game.client;

import java.io.Serializable;

import game.system.Message;

public class ClientMessageHandler {
    static void handleMessage(Message message) {

        switch(message.getCommand()) {
            case ("print"):
                System.out.println();
                for(Serializable arg : message.getArguments()) {
                    System.out.println(arg);
                }
                break;

//            case ("play"):
//                Scanner sc = new Scanner(System.in);
//                System.out.println("Insira um x e um y:");
//                int x = sc.nextInt();
//                int y = sc.nextInt();
//
//                Client.connection.sendMessage(new Message("coordinates", x, y));
        }
    }
}
