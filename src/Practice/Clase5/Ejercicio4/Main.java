package Practice.Clase5.Ejercicio4;


import Practice.Clase5.BalanceArbol;

public class Main {

    public static void main(String[] args) {

        BalanceArbol<Integer, String> arbol = new BalanceArbol<>();
        arbol.put(1,"A");
        arbol.put(2,"B");
        arbol.put(3,"C");
        arbol.put(4,"D");
        arbol.put(5,"E");

        arbol.rotateTree(2);
        arbol.rotateTree(3);
    }
}
