package BattagliaNavale;

public interface grid {


    public static void setM(char M[][]) {
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                M[i][j]='_';
            }
        }
    }
    public static void getM(char M[][]){
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                System.out.print(M[i][j]);
            }
            System.out.println("\n");
        }
    }
    public static void colpito(int X, int Y, char M[][]){
        M[Y][X]='_';
    }
    public static boolean controlloAffondata(int X, int Y, char M[][]){
        if(M[Y-1][X]=='_'&&M[Y+1][X]=='_'&&M[Y][X-1]=='_'&&M[Y][X+1]=='_')return true;
        else return false;
    }
    public static boolean controlloVittoria(Partita partita, Utente utente){
        if (utente.getPunteggio()==partita.getPunteggioMassimo())return true;
        else return false;
    }
}
