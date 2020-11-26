package BattagliaNavale;

public class Tupla {
    private int xCord;
    private int yCord;

    public Tupla(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public int getxCord() {
        return xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public void printCord(){
        System.out.println("("+xCord+","+yCord+")");
    }
}
