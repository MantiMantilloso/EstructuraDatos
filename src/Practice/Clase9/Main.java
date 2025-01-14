package Practice.Clase9;

import ADT.Vertex;

import static ADT.GraphAlgorithms.shortestPathLengths;

public class Main {
    public static void main(String[] args) {
        HDMQ hospital = new HDMQ(false);

        Vertex<Habitacion> em1 = hospital.insertHabitacion(new Habitacion("Emergencias 1"));
        Vertex<Habitacion> em2 = hospital.insertHabitacion(new Habitacion("Emergencias 2"));
        Vertex<Habitacion> es1 = hospital.insertHabitacion(new Habitacion("Espera 1"));

        hospital.insertPasillo(em1, em2, 10);
        hospital.insertPasillo(em2, es1, 5);
        hospital.insertPasillo(em1, es1, 20);

// Imprimir caminos más cortos
        hospital.printShortestPaths();

    }

}
