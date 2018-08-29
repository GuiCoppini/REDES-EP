package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ServerSocketFactory;

public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        ServerSocket serverSocket = ServerSocketFactory.getDefault().createServerSocket(port);
        System.out.println("Waiting for connections");
        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("socket connected:" + socket.getInetAddress().getHostAddress());

            ConnectionHandler connectionHandler = new ConnectionHandler(socket);
            connectionHandler.start();
        }
    }

    private static class ConnectionHandler implements Runnable {
        private Socket socket;

        public ConnectionHandler(Socket socket) {
            this.socket = socket;
        }

        public void start() throws Exception {
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                boolean run = true;

                while(run) {
                    try {
                        String command = reader.readLine();
                        if("quit".equals(command)) {
                            writer.write("bye\n");
                            writer.flush();
                            run = false;
                        } else {
                            System.out.println("unknown command:" + command);
                        }
                    } catch(Exception e) {
                        System.out.println("error reading command");
                        run = false;
                    }
                }
            } catch(Exception e) {

            }
            close();
        }

        private void close() {
            try {
                System.out.println("Connection closed");
                socket.close();
            } catch(Exception e) {
                // ignore
            }
        }
    }
}