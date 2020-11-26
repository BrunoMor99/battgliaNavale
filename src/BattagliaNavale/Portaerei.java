package BattagliaNavale;

public class Portaerei extends Nave{

    @Override
    public void creaNave(String direction, int xCord, int yCord) {
        this.direction=direction;
        this.length=5;
        this.cordinate=new Tupla(xCord, yCord);

    }

    @Override
    public String toString() {
        return "portaerei";
    }
}
