package BattagliaNavale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BattagliaNavale {
    public static void main(String[] args){
        boolean gameOver = false;
        Partita partita=new Partita("User1", "User2");
        grid.setM(partita.getUtente1().Griglia);
        //grid.getM(utente1.Griglia);

        List<Nave> navi;
        navi=partita.createList();

        for (Nave nave : navi){
            partita.getUtente1().set(nave);
            grid.getM(partita.getUtente1().Griglia);
        }
        grid.getM(partita.getUtente1().Griglia);

        for (Nave nave : navi){
            partita.getUtente2().set(nave);
            grid.getM(partita.getUtente2().Griglia);
        }
        grid.getM(partita.getUtente2().Griglia);

        while (!gameOver){

            gameOver=chiediCord(partita.getUtente1(), partita);
            if(!gameOver)gameOver=chiediCord(partita.getUtente2(), partita);
        }
        if (partita.getUtente1().getPunteggio()>partita.getUtente2().getPunteggio()){
            System.out.println(partita.getUtente1().getNome()+" ha vinto!");
            System.out.println(partita.getUtente1().getNome()+": "+partita.getUtente1().getPunteggio());
            System.out.println(partita.getUtente2().getNome()+": "+partita.getUtente2().getPunteggio());
        } else if (partita.getUtente1().getPunteggio()<partita.getUtente2().getPunteggio()){
            System.out.println(partita.getUtente2().getNome()+" ha vinto!");
            System.out.println(partita.getUtente2().getNome()+": "+partita.getUtente2().getPunteggio());
            System.out.println(partita.getUtente1().getNome()+": "+partita.getUtente1().getPunteggio());
        }else {
            System.out.println("Pareggio!");
            System.out.println(partita.getUtente1().getNome()+": "+partita.getUtente1().getPunteggio());
            System.out.println(partita.getUtente2().getNome()+": "+partita.getUtente2().getPunteggio());
        }
    }
    public static boolean chiediCord(Utente utente, Partita partita){
        System.out.println(utente.getNome()+"dove vuoi sparare?");
        Scanner MyScan = new Scanner(System.in);
        int cX = MyScan.nextInt();
        int cY = MyScan.nextInt();
        return utente.spara(cX, cY, partita);
    }

}


