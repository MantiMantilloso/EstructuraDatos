package Practice.Clase8.Ejercicio1;

import ADT.AdjacencyMapGraph;
import ADT.Graph;
import ADT.Vertex;

import static ADT.GraphAlgorithms.transitiveClosure;
import static Practice.Clase8.Ejercicio1.DAGClass8Example.*;

public class Main {
    public static void main(String[] args) {
        Graph<String, Integer> g = getGraph();

        System.out.println("Aristas originales:");
        printEdges(g);

        // Verificar si es DAG
        System.out.println("¿Es DAG?: " + isDAG(g));

        // Imprimir orden topológico
        System.out.println("Orden topológico:");
        printTopologicalOrder(g);

        // Realizar cierre transitivo
        transitiveClosure(g);

        System.out.println("Aristas después del cierre transitivo:");
        printEdges(g);
    }

    private static Graph<String, Integer> getGraph() {
        Graph<String, Integer> g = new AdjacencyMapGraph<>(true); // Crear el grafo dirigido

        // Añadir vértices
        Vertex<String> b = g.insertVertex("B");
        Vertex<String> m = g.insertVertex("M");
        Vertex<String> a = g.insertVertex("A");
        Vertex<String> j = g.insertVertex("J");
        Vertex<String> f = g.insertVertex("F");

        // Añadir aristas
        g.insertEdge(b, m, 1);
        g.insertEdge(b, a, 1);
        g.insertEdge(b, j, 1);
        g.insertEdge(a, m, 1);
        g.insertEdge(a, f, 1);
        return g;
    }

}
