package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 12345;
    private ServerSocket serverSocket;

    public Server() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
    }

    public void run() {
        while (true) {
            try {
                Socket newSocket = serverSocket.accept();
                SocketClientConnection socketConnection = new SocketClientConnection(newSocket, this);
                Thread t = new Thread(socketConnection);
                t.start();

            } catch (IOException e) {
                System.out.println("connection error!");
            }
        }
    }

}
