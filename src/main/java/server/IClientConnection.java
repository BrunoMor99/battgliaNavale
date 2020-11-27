package server;

import observer.Observer;

public interface IClientConnection {

    void closeConnection();

    void addObserver(Observer<String> observer);

    void asyncSend(Object message);
}
