package server;

import observer.Observable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SocketClientConnection extends Observable<String> implements IClientConnection, Runnable {

    private Socket socket;
    private ObjectOutputStream outputStream;
    private Server server;

    private boolean active = true;

    public SocketClientConnection(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    private synchronized boolean isActive() {
        return active;
    }

    private synchronized void send(Object message) {
        try {
            outputStream.reset();
            outputStream.writeObject(message);
            outputStream.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void close() {
        closeConnection();
        System.out.println("Deregistering client...");
//        server.deregisterConnection(this);
        System.out.println("Done!");
    }

    @Override
    public void run() {

        Scanner inputStream;
        String name;

        try {

            inputStream = new Scanner(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());

            send("BATTAGLIA NAVALE 2.0\ndeveloped by Bruno Morelli, Alberto Mosconi\n\nWhat is your name?");
            String read = inputStream.nextLine();
            name = read;


        } catch (IOException | NoSuchElementException e) {
            System.err.println("Error! " + e.getMessage());
        } finally {
            close();
        }

    }

    @Override
    public void closeConnection() {

        send("Connection closed!");

        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Error when closing socket!");
        }

        active = false;

    }

    @Override
    public void asyncSend(Object message) {

    }
}
