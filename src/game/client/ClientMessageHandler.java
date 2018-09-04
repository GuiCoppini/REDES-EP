package game.client;

import java.util.Scanner;

public class ClientMessageHandler {
    static void handleMessage(String message) {
        String[] messageParts = message.split(",");

        switch(messageParts[0]) {
            case("broadcast"):
                System.out.println();
                for(int i = 1; i<messageParts.length; i++)
                    System.out.println(messageParts[i]);
                break;

            case("play"):
                Scanner sc = new Scanner(System.in);
                System.out.println("Insira um x e um y:");
                int x = sc.nextInt();
                int y = sc.nextInt();

                Client.connection.sendMessage("coord,"+x+","+y);

        }
    }
}
