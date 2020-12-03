package model;

import view.View;

public class BoardClick {

    private final int row;
    private final int column;
    private final String orientation;
    private final Player player;
    private final View view;

    public BoardClick(Player player, int row, int column, String orientation, View view) {
        this.player = player;
        this.row = row;
        this.column = column;
        this.orientation = orientation;
        this.view = view;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Player getPlayer() {
        return player;
    }

    public View getView() {
        return view;
    }

    public String getOrientation() {
        return orientation;
    }
}
