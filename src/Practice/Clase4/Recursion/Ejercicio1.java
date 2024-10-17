package Practice.Clase4.Recursion;

public class Ejercicio1 {

    //Algorithim for n-th Harmonic number

    /**Returns the n-th harmonic series number*/
    public static double nHarmonicNumber(int n){
        if (n == 1)
            return 1;
        else
            return (double) 1 /n + (nHarmonicNumber(n-1));
    }

    public static void main(String[] args) {
        for (int i = 0 ; i<10; i++){
            System.out.println(nHarmonicNumber(i+1));
        }
    }
}
