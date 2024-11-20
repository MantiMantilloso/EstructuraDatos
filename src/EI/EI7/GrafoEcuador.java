package EI.EI7;

import ADT.*;

import java.util.HashMap;

import static ADT.GraphAlgorithms.topologicalSort;
import static ADT.GraphAlgorithms.transitiveClosure;

/**Una pequeña implementacion usando ciudades de ecuador como ejemplo
 * Esta de aqui es un ejemplo del uso de AdjacencyMapGraph como un digraph
 * Vias hacia las demas ciudades desde Guayaquil
 */
public class GrafoEcuador {

    public static Graph<Ciudad, Integer> createGraph(Ciudad[][] ciudades, boolean directed) {
        Graph<Ciudad, Integer> g = new AdjacencyMapGraph<>(directed);

        HashMap<String, Vertex<Ciudad>> verts = new HashMap<>();
        for (Ciudad[] edge : ciudades) {
            for (Ciudad ciudad : edge) {
                // Only add if not already present in the graph
                if (!verts.containsKey(ciudad.getNombre())) {
                    verts.put(ciudad.getNombre(), g.insertVertex(ciudad));
                }
            }
        }

        // Now add edges to the graph
        for (Ciudad[] edge : ciudades) {
            Integer cost = (edge.length == 2 ? 1 : Integer.parseInt(edge[2].toString())); // Default weight is 1 if not specified
            g.insertEdge(verts.get(edge[0].getNombre()), verts.get(edge[1].getNombre()), cost);
        }
        return g;
    }
    public static <Ciudad, Integer> void printEdges(Graph<Ciudad, Integer> g) {
        for (Edge<Integer> edge : g.edges()) {
            Vertex<Ciudad>[] endpoints = g.endVertices(edge);
            System.out.println(endpoints[0].getElement() + " -> " + endpoints[1].getElement() );
        }
    }

    public static <Ciudad, Integer> void printTopologicalOrder(Graph<Ciudad, Integer> g) {
        PositionalList<Vertex<Ciudad>> topoOrder = topologicalSort(g);
        int count = 1;
        for (Vertex<Ciudad> vertex : topoOrder) {
            System.out.println(count++ + " " + vertex.getElement());
        }
    }

    public static <Ciudad, Integer> void performTransitiveClosure(Graph<Ciudad, Integer> g) {
        transitiveClosure(g);
    }
}
