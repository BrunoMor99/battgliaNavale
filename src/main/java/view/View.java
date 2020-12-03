package view;

import model.BoardClick;
import model.ClickMessage;
import model.Player;
import observer.Observable;
import observer.Observer;

public abstract class View extends Observable<BoardClick> implements Observer<ClickMessage> {

    private Player player;

    protected View(Player player) {
        this.player = player;
    }

    protected abstract void showMessage(Object message);

    void handleClick(int row, int col, String orientation) {
        System.out.println(row + " " + col + " " + orientation);
        notify(new BoardClick(player, row, col, orientation, this));
    }

    public void reportError(String message){
        showMessage(message);
    }

}
