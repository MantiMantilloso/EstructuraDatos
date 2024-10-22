package Practice.Clase5.Ejercicio4;

import ADT.Entry;
import ADT.Position;
import ADT.TreeMap;

public class Main {
    public static class ArbolEjemplo<Integer,String> extends TreeMap<Integer,String>{
        public void balancetree(Position<Entry<Integer,String>> center){
            restructure(center);
        }
    }
    public static void main(String[] args) {


        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
        map.put(4,"D");
        map.put(5,"E");

        ArbolEjemplo<Integer, String> arbol = new ArbolEjemplo<>();
        arbol.put(1,"A");
        arbol.put(2,"B");
        arbol.put(3,"C");
        arbol.put(4,"D");
        arbol.put(5,"E");

        Position<Entry<Integer,String>> root = arbol.root();
        arbol.balancetree(root);

    }
}
