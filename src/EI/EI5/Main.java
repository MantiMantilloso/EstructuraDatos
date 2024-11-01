package EI.EI5;

import ADT.*;

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
        System.out.println("-------------------------------------------------------\nPrueba de colisiones 1: Separate Chaining");
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
        System.out.println("-------------------------------------------------------\nPrueba de colisiones 2: Linear Probing");
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
         */
        System.out.println("-------------------------------------------------------\nPrueba de colisiones 3: Double Hashing");
        DoubleHashMap<String,Factura> doubleMap = new DoubleHashMap<>(cap);
        System.out.println("Estructura de la DoubleHashMap:");
        for (Factura factura : facturas){
            doubleMap.put(factura.getNumero(), factura);
            System.out.println(doubleMap);
        }


    }
}
