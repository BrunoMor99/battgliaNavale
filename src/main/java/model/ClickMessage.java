package model;

public class ClickMessage {

    private final Player player;

    private final Board board;

    public ClickMessage(Board board, Player player) {
        this.player = player;
        this.board = board;
    }

    public Player getPlayer() {
        return player;
    }

    public Board getBoard() {
        return board;
    }
}
