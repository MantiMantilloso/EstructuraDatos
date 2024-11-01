package EI.EI5;

import ADT.ChainHashMap;
import ADT.Entry;
import ADT.ProbeHashMap;
import ADT.UnsortedTableMap;

public class Main {

    public static int hash1(String key, int capacity) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public static int hash2(String key) {
        return 7 - (Math.abs(key.hashCode()) % 7);  // Ejemplo usando 7 como un número primo
    }

    public static void main(String[] args) {
        int cap = 11; //capacity of the HashMap

        // Crear algunas facturas con colisiones intencionadas en los últimos dos dígitos
        Factura f1 = new Factura("12345", "Mauricio", 75.50);
        Factura f2 = new Factura("67845", "Arianna", 299.99);
        Factura f3 = new Factura("98765", "Estefania", 150.75);
        Factura f4 = new Factura("54345", "Andres", 45.30);
        Factura f5 = new Factura("12395", "Alejandro", 890.00);

        Factura [] facturas = {f1, f2, f3, f4, f5};

        /**
         * Section 1: Separate Chaining
         */
        ChainHashMap<String, Factura> chainMap = new ChainHashMap<>(cap); // Tamaño de capacidad inicial
        System.out.println("Estructura de la ChainHashMap:");
        // Insertar facturas en el mapa
        for (Factura factura : facturas){
            chainMap.put(factura.getNumero(), factura);
            System.out.println(chainMap);
        }

        /**
         * Section 2: Linear Probing
         */

        ProbeHashMap<String,Factura> probeMap = new ProbeHashMap<>(cap);

        // Imprimir la estructura completa de la ChainHashMap
        System.out.println("Estructura de la ProbeHashMap:");

        //insertar e imprimir
        for (Factura factura : facturas){
            probeMap.put(factura.getNumero(), factura);
            System.out.println(probeMap);
        }


        /**
         * Section 3: Double Hashing
         * No es una nueva estructura, se definieron dos funciones hash1 y hash2, las cuales simulan un double hash
         */

        String[] keys = {f1.getNumero(), f2.getNumero(), f3.getNumero(), f4.getNumero(), f5.getNumero()};
        System.out.println("Simulación de Double Hashing:");
        for (String key : keys) {
            int hash1 = hash1(key, cap);
            int hash2 = hash2(key);
            System.out.println("Clave: " + key);
            System.out.println("  - hash1: " + hash1);
            System.out.println("  - hash2: " + hash2);

            // Simular posiciones en caso de colisión
            for (int i = 0; i < cap; i++) {
                int index = (hash1 + i * hash2) % cap;
                System.out.println("    Intento " + (i + 1) + ": índice " + index);
            }
            System.out.println();
        }


    }
}
