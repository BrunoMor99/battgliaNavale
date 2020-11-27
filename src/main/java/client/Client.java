package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {

    private String ip;
    private int port;

    private boolean active = true;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public synchronized boolean isActive(){
        return active;
    }

    public synchronized void setActive(boolean active){
        this.active = active;
    }

    public Thread asyncReadFromSocket(final ObjectInputStream socketInput) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isActive()) {
                        Object inputObject = socketInput.readObject();
                        if (inputObject instanceof String) {
                            System.out.println((String)inputObject);
//                        } else if (inputObject instanceof Board) {
//                            ((Board)inputObject).print();
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                } catch (Exception e) {
                    setActive(false);
                }
            }
        });
        t.start();
        return t;
    }

    public Thread asyncWriteToSocket(final Scanner stdin, final PrintWriter socketOutput) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    String inputLine = stdin.nextLine();
                    socketOutput.println(inputLine);
                    socketOutput.flush();

                } catch (Exception e) {
                    setActive(false);
                }
            }
        });
        t.start();
        return t;
    }

    public void run() throws IOException {
        Socket socket = new Socket(ip, port);
        System.out.println("connection established");

        ObjectInputStream socketInput = new ObjectInputStream(socket.getInputStream());
        PrintWriter socketOutput = new PrintWriter(socket.getOutputStream());
        Scanner stdin = new Scanner(System.in);

        try {
            Thread t0 = asyncReadFromSocket(socketInput);
            Thread t1 = asyncWriteToSocket(stdin, socketOutput);
            t0.join();
            t1.join();
        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println("connection closed from client side.");
        } finally {
            stdin.close();
            socketInput.close();
            socketOutput.close();
            socket.close();
        }

    }

}
