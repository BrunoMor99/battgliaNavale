package BattagliaNavale;

public class Nave_Assalto extends Nave{
    @Override
    public void creaNave(String direction, int xCord, int yCord) {
        this.direction=direction;
        this.length=2;
        this.cordinate=new Tupla(xCord, yCord);

    }
    @Override
    public String toString() {
        return "nave d'assalto";
    }
}
