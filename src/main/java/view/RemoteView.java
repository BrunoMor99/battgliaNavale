package view;

import model.ClickMessage;
import model.Player;
import observer.Observer;
import server.IClientConnection;

public class RemoteView extends View {

    private class MessageReceiver implements Observer<String> {

        @Override
        public void update(String message) {
            System.out.println("Received: " + message);

            try {
                String[] inputs =message.split(",");

                handleClick(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), inputs.length == 3 ? inputs[2] : "o");

            } catch (IllegalArgumentException e) {
                clientConnection.asyncSend("Error!");
            }
        }
    }

    private IClientConnection clientConnection;

    public RemoteView(Player player, String opponent, IClientConnection c) {
        super(player);
        this.clientConnection = c;

        c.asyncSend("Your opponent is " + opponent);
        c.addObserver(new MessageReceiver());
    }


    @Override
    protected void showMessage(Object message) {
        clientConnection.asyncSend(message);
    }

    @Override
    public void update(ClickMessage message) {

    }
}
