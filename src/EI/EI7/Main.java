package EI.EI7;

import ADT.Graph;

public class Main {
    public static void main(String[] args) {

        // Create the graph with example data
        Ciudad[][] ciudades = getCiudades();
        Graph<Ciudad, Integer> ciudadesEcuador = GrafoEcuador.createGraph(ciudades, true);

        // Print edges before transitive closure
        System.out.println("Transciciones antes de transitive closure:");
        GrafoEcuador.printEdges(ciudadesEcuador);

        // Perform transitive closure
        GrafoEcuador.performTransitiveClosure(ciudadesEcuador);

        // Print edges after transitive closure
        System.out.println("Transciciones despues transitive closure:");
        GrafoEcuador.printEdges(ciudadesEcuador);

        // Print topological order
        System.out.println("Topological order de los vertices:");
        GrafoEcuador.printTopologicalOrder(ciudadesEcuador);
    }

    private static Ciudad[][] getCiudades() {
        Ciudad gye = new Ciudad("Guayaquil", 2000000);
        Ciudad uio = new Ciudad("Quito", 2500000);
        Ciudad cue = new Ciudad("Cuenca", 1000000);
        Ciudad amb = new Ciudad("Ambato", 800000);
        Ciudad man = new Ciudad("Manta", 400000);

        return new Ciudad[][]{
                {gye, man},
                {gye, cue},
                {cue, amb},
                {amb, man},
                {amb, uio},
                {man, uio}
        };
    }
}