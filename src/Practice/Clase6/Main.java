package Practice.Clase6;

import ADT.ChainHashMap;
import ADT.DoubleHashMap;
import ADT.ProbeHashMap;

public class Main {
    public static void main(String[] args) {
        Integer[] keys = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16, 5};
        int capacity = 11; // Tamaño de tabla para ver mejor las colisiones

        ProbeHashMap<Integer, String> probeHashMap = new ProbeHashMap<Integer, String>(capacity);
        ChainHashMap<Integer, String> chainHashMap = new ChainHashMap<Integer, String>(capacity);
        DoubleHashMap<Integer, String> doubleHashMap = new DoubleHashMap<>(capacity);


        //no comprendo pq no funciona
        for (Integer key : keys) {
            probeHashMap.put(key, "proba");
            System.out.println("Probe: " + probeHashMap);

            chainHashMap.put(key, "chaina");
            System.out.println("Chain: " + chainHashMap);

            doubleHashMap.put(key, "double");
            System.out.println("Double: " + doubleHashMap);
        }




    }
}