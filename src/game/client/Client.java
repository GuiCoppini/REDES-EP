package game.client;

import game.game.Player;

import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.in;

public class Client {
    static Player player;
    static Scanner scanner = new Scanner(in);
    static Connection connection;

    public static void connect(String ip, int port) {
        try {
            connection = new Connection(new Socket(ip, port));
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        System.out.println("Insira seu nick");
        String name = scanner.nextLine();
        player = new Player(name);
        connect("localhost", 5555);
        System.out.println("Connected to server");

        System.out.println("Insira um x");
        int x = scanner.nextInt();
        System.out.println("Insira um y");
        int y = scanner.nextInt();

        //mandou uma string "nickname,x,y"
        connection.sendMessage(player.getName() + "," + x + "," + y);
    }
}
