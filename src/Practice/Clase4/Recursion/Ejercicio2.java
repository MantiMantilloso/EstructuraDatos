package Practice.Clase4.Recursion;

public class Ejercicio2 {
    public static void hanoiSolve(int n, int start, int end){
        if (n == 1) printMove(start, end); //Caso base, mover una ficha de start a end
        else{
            int other = 6-(start+end); //other es el poste que "no se usa acualmente" tamaño ya que start=1 y end=3
            hanoiSolve(n-1, start, other); //recursivamente mover n-1 fichas to other
            printMove(start, end); // mostar el movimiento
            hanoiSolve(n-1, other, end); // recursivamente mover de other al final
        }
    }
    public static void printMove(int start, int end){
        System.out.println(start+" -> "+end);
    }
    public static void main(String[] args) {
        hanoiSolve(3,1,3);
        System.out.println("Next Case:");
        hanoiSolve(4,1,3);
    }
}
