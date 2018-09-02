package game.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.in;

public class Client {
    static Scanner scanner = new Scanner(in);

    public static void main(String[] args) {
        try {
            Socket serverSocket = new Socket("localhost", 5555);
            System.out.println("Connected to server");
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

            while (true) {
                String input = scanner.nextLine();
                out.write(input + "\n");
                out.flush();

                String serverInput;
                if ((serverInput = in.readLine()) != null)
                    System.out.println(serverInput);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
