package Practice.Clase5.Ejercicio5;

import Practice.Clase5.BalanceArbol;

public class Main {
    public static void main(String[] args) {
        BalanceArbol<Integer, String> arbol2 = new BalanceArbol<>();
        arbol2.put(30,"input1");
        arbol2.put(40,"input2");
        arbol2.put(24,"input3");
        arbol2.put(58,"input4");
        arbol2.put(48,"input5");
        arbol2.put(26,"input6");
        arbol2.put(11,"input7");
        arbol2.put(13,"input8");

        System.out.println(arbol2.toString());
    }
}
