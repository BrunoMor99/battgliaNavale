package BattagliaNavale;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BattagliaNavale {
    public static void main(String[] args){
        utente utente1 = new utente();
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
            set(nave, utente1);
        }
        grid.getM(utente1.Griglia);
    }

    static void set(Nave nave, utente utente){
        System.out.println("Iserire verso e cordinate iniziali di "+ nave.toString());
        Scanner MyScan = new Scanner(System.in);
        String direzione = MyScan.nextLine();
        int cX = MyScan.nextInt();
        int cY = MyScan.nextInt();

        nave.creaNave(direzione, cX, cY);
        nave.setNave(utente.Griglia);

    }
}


