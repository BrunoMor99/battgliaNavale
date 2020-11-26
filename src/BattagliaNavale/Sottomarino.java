package BattagliaNavale;

public class Sottomarino extends Nave {
    @Override
    public void creaNave(String direction, int xCord, int yCord) {
        this.direction=direction;
        this.length=3;
        this.cordinate=new Tupla(xCord, yCord);

    }
    @Override
    public String toString() {
        return "sottomorino";
    }
}
