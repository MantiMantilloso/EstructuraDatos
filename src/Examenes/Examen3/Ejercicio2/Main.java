package Examenes.Examen3.Ejercicio2;

import static ADT.GraphAlgorithms.shortestPathLengths;

public class Main {
    public static void main(String[] args) {
        RedCISCO redCISCO = new RedCISCO();
        System.out.println(redCISCO.red.numVertices());

        redCISCO.printShortestPaths();

    }
}
