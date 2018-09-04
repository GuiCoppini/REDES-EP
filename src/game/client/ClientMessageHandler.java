package game.client;

import java.util.Scanner;

public class ClientMessageHandler {
    static void handleMessage(Object message) {
        if(message instanceof String) {
            String[] messageParts = ((String)message).split(",");

            switch(messageParts[0]) {
                case ("broadcast"):
                    System.out.println();
                    for(int i = 1; i < messageParts.length; i++)
                        System.out.println(messageParts[i]);
                    break;

                case ("play"):
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Insira um x e um y:");
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    Client.connection.sendMessage("coord," + x + "," + y);
            }
        } else { //  mandou a table
            System.out.println("Mandou uma table");
        }
    }
}
