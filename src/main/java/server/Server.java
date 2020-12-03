package server;

import model.Player;
import view.RemoteView;
import view.View;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int PORT = 12345;
    private ServerSocket serverSocket;
    private ExecutorService executor = Executors.newFixedThreadPool(128);

    private Map<String, IClientConnection> waitingConnection = new HashMap<>();
    private Map<IClientConnection, IClientConnection> playingConnection = new HashMap<>();

    public synchronized void lobby(IClientConnection c, String name) {
        // add player to waiting list
        waitingConnection.put(name, c);
        // if there are two players that are waiting, start a game between them
        if (waitingConnection.size() == 2) {
            List<String> keys = new ArrayList<>(waitingConnection.keySet());
            IClientConnection c1 = waitingConnection.get(keys.get(0));
            IClientConnection c2 = waitingConnection.get(keys.get(1));
            Player player1 = new Player(keys.get(0));
            Player player2 = new Player(keys.get(1));
            View player1View = new RemoteView(player1, keys.get(1), c1);
            View player2View = new RemoteView(player2, keys.get(0), c2);


            playingConnection.put(c1, c2);
            playingConnection.put(c2, c1);
            waitingConnection.clear();
        }
    }

    public Server() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
    }

    public void run() {
        while (true) {
            try {
                Socket newSocket = serverSocket.accept();
                SocketClientConnection socketConnection = new SocketClientConnection(newSocket, this);
                executor.submit(socketConnection);
            } catch (IOException e) {
                System.out.println("connection error!");
            }
        }
    }

}
