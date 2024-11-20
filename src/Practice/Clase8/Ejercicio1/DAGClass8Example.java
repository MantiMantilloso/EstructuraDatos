package Practice.Clase8.Ejercicio1;

import ADT.Edge;
import ADT.Graph;
import ADT.PositionalList;
import ADT.Vertex;

import static ADT.GraphAlgorithms.topologicalSort;

public class DAGClass8Example {
    public static <V, E> void printEdges(Graph<V, E> g) {
        for (Edge<E> e : g.edges()) {
            Vertex<V>[] endpoints = g.endVertices(e);
            System.out.println("(" + endpoints[0].getElement() + " -> " + endpoints[1].getElement() + ")");
        }
    }
    public static <V, E> boolean isDAG(Graph<V, E> g) {
        PositionalList<Vertex<V>> topoOrder = topologicalSort(g);
        return topoOrder.size() == g.numVertices(); // Si orden topológico cubre todos los vértices, es un DAG
    }
    public static <V, E> void printTopologicalOrder(Graph<V, E> g) {
        PositionalList<Vertex<V>> topoOrder = topologicalSort(g);
        int index = 1;
        for (Vertex<V> v : topoOrder) {
            System.out.println(index + " <" + v.getElement() + ">");
            index++;
        }
    }



}
