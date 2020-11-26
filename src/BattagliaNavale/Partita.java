package BattagliaNavale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partita {
    Utente utente1;
    Utente utente2;

    public Partita(String utente1, String utente2) {
        this.utente1 = new Utente(utente1);
        this.utente2 = new Utente(utente2);
        this.utente1.setAvversario(this.utente2);
        this.utente2.setAvversario(this.utente1);
    }

    public List<Nave> createList(){
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

        return navi;
    }

    public Utente getUtente1() {
        return utente1;
    }

    public Utente getUtente2() {
        return utente2;
    }
}
