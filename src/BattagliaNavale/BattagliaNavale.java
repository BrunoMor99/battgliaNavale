package BattagliaNavale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BattagliaNavale {
    public static void main(String[] args){
        boolean gameOver = false;
        Utente utente1 = new Utente("User1");
        Utente utente2 = new Utente("User2");
        grid.setM(utente1.Griglia);
        //grid.getM(utente1.Griglia);
        Nave portaerei = new Portaerei();
        Nave corazzata1 = new Corazzata();
        Nave corazzata2 = new Corazzata();
        Nave sottomarino1 = new Sottomarino();
        Nave sottomarino2 = new Sottomarino();
        Nave sottomarino3 = new Sottomarino();
        Nave assalto1 = new Nave_Assalto();
        Nave assalto2 = new Nave_Assalto();
        Nave assalto3 = new Nave_Assalto();
        Nave assalto4 = new Nave_Assalto();
        List<Nave> navi = new ArrayList<>(Arrays.asList(portaerei, corazzata1, corazzata2, sottomarino1, sottomarino2, sottomarino3, assalto1, assalto2, assalto3, assalto4));

        for (Nave nave : navi){
            utente1.set(nave);
            grid.getM(utente1.Griglia);
        }
        grid.getM(utente1.Griglia);

        for (Nave nave : navi){
            utente2.set(nave);
            grid.getM(utente2.Griglia);
        }
        grid.getM(utente2.Griglia);

        while (!gameOver){

            gameOver=chiediCord(utente1);
            if(!gameOver)gameOver=chiediCord(utente2);
        }
        if (utente1.getPunteggio()>utente2.getPunteggio()){
            System.out.println(utente1.getNome()+" ha vinto!");
            System.out.println(utente1.getNome()+": "+utente1.getPunteggio());
            System.out.println(utente2.getNome()+": "+utente2.getPunteggio());
        } else if (utente1.getPunteggio()<utente2.getPunteggio()){
            System.out.println(utente2.getNome()+" ha vinto!");
            System.out.println(utente2.getNome()+": "+utente2.getPunteggio());
            System.out.println(utente1.getNome()+": "+utente1.getPunteggio());
        }else {
            System.out.println("Pareggio!");
            System.out.println(utente1.getNome()+": "+utente1.getPunteggio());
            System.out.println(utente2.getNome()+": "+utente2.getPunteggio());
        }
    }
    public static boolean chiediCord(Utente utente){
        System.out.println(utente.getNome()+"dove vuoi sparare?");
        Scanner MyScan = new Scanner(System.in);
        int cX = MyScan.nextInt();
        int cY = MyScan.nextInt();
        return utente.spara(cX, cY);
    }

}


