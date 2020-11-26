package BattagliaNavale;

public class Corazzata extends Nave{

    @Override
    public void creaNave(String direction, int xCord, int yCord) {
        this.direction=direction;
        this.length=4;
        this.cordinate=new Tupla(xCord, yCord);

    }
    @Override
    public String toString() {
        return "corazzata";
    }

}
