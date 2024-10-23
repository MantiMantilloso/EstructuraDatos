package Practice.Clase5.Ejercicio4;

import ADT.Entry;
import ADT.Position;
import ADT.TreeMap;

public class Main {
    public static class ArbolEjemplo<Integer,String> extends TreeMap<Integer,String>{
        public void balancetree(Position<Entry<Integer,String>> center){
            restructure(center);
        }
        public void rotateTree(Position<Entry<Integer,String>> center){
            rotate(center);
        }

        public void newrotate(Integer k){
           Position<Entry<Integer, String >> center = treeSearch(root(), k);
           rotateTree(center);
        }
    }
    public static void main(String[] args) {

        ArbolEjemplo<Integer, String> arbol = new ArbolEjemplo<>();
        arbol.put(1,"A");
        arbol.put(2,"B");
        arbol.put(3,"C");
        arbol.put(4,"D");
        arbol.put(5,"E");

        arbol.newrotate(2);
    }
}
