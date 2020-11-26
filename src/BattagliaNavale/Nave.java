package BattagliaNavale;

public abstract class Nave {
    protected int length;
    protected String direction;
    protected Tupla cordinate;

    public abstract void creaNave(String direction, int xCord, int yCord);
    public  void setNave(char griglia[][]){
        griglia[cordinate.getyCord()][cordinate.getxCord()]='X';
        if (this.direction.equals("orizzontale")){
            for (int i = 1;i<length;i++){
                griglia[cordinate.getyCord()][cordinate.getxCord()+i]='X';
            }
        }else if (this.direction.equals("verticale")){
            for (int i = 1;i<length;i++){
                griglia[cordinate.getyCord()+i][cordinate.getxCord()]='X';
            }
        }
    }
    public abstract String toString();

    public int getLength() {
        return length;
    }
}
