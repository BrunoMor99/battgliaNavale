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
}
