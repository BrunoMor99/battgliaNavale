package BattagliaNavale;

import java.util.Scanner;

public class Utente implements grid{
    protected char Griglia[][]=new char[10][10];
    private int punteggio=0;
    private String nome;
    private Utente avversario;




    public Utente(String nome) {
        this.nome = nome;
    }

    public void setAvversario(Utente avversario) {
        this.avversario = avversario;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void IncrementaPunteggio() {
        this.punteggio++;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getNome() {
        return nome;
    }

    void set(Nave nave){
        System.out.println(this.nome+" inserisci verso e cordinate iniziali di "+ nave.toString());
        Scanner MyScan = new Scanner(System.in);
        String direzione = MyScan.nextLine();
        int cX = MyScan.nextInt();
        int cY = MyScan.nextInt();

        nave.creaNave(direzione, cX, cY);
        nave.setNave(this.Griglia);

    }
    boolean spara(int X, int Y, Partita partita){
        if(avversario.Griglia[Y][X]=='X'){
            this.IncrementaPunteggio();
            grid.colpito(X, Y, avversario.Griglia);
            if (!grid.controlloAffondata(X, Y, avversario.Griglia))System.out.println("Colpita");
            else System.out.println("Colpita e affondata");
            return grid.controlloVittoria(partita, this);
        }else {
            System.out.println("Mancato");
            return false;
        }
    }
}
