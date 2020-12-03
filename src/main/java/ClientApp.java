import client.Client;
import model.Player;
import view.RemoteView;
import view.View;

import java.io.IOException;

public class ClientApp {

    public static void main(String[] args) {

        Client client = new Client("localhost", 12345);
        try {
            client.run();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
