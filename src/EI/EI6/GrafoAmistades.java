package EI.EI6;

import ADT.*;
import ADT.Map;

import java.util.*;

public class GrafoAmistades {

    /**
     * Constructs a graph from an array of array strings.
     * Each edge connects two PerfilSocial objects with an optional integer weight.
     */
    public static Graph<PerfilSocial, Integer> graphFromEdgelist(PerfilSocial[][] perfiles, boolean directed) {
        Graph<PerfilSocial, Integer> g = new AdjacencyMapGraph<>(directed);

        // First pass to add all PerfilSocial objects as vertices
        HashMap<String, Vertex<PerfilSocial>> verts = new HashMap<>();
        for (PerfilSocial[] edge : perfiles) {
            for (PerfilSocial perfil : edge) {
                // Only add if not already present in the graph
                if (!verts.containsKey(perfil.getNombre())) {
                    verts.put(perfil.getNombre(), g.insertVertex(perfil));
                }
            }
        }

        // Now add edges to the graph
        for (PerfilSocial[] edge : perfiles) {
            Integer cost = (edge.length == 2 ? 1 : Integer.parseInt(edge[2].toString())); // Default weight is 1 if not specified
            g.insertEdge(verts.get(edge[0].getNombre()), verts.get(edge[1].getNombre()), cost);
        }
        return g;
    }
    public static void showPaths(Graph<PerfilSocial, Integer> graph, Map<Vertex<PerfilSocial>, Edge<Integer>> Forest){
        for (Vertex<PerfilSocial> v : Forest.keySet()) {
            List<Vertex<PerfilSocial>> path = new ArrayList<>();
            Vertex<PerfilSocial> current = v;

            // Trace back to the starting vertex using the forest map
            while (current != null) {
                path.add(current);
                Edge<Integer> edge = Forest.get(current);
                if (edge == null) break; // reached starting vertex
                current = graph.opposite(current, edge);
            }

            // Print the path in the correct order (from start to current vertex)
            Collections.reverse(path);
            System.out.print("Path to Vertex " + v.getElement().getNombre() + ": ");
            for (Vertex<PerfilSocial> vertex : path) {
                System.out.print(vertex.getElement().getNombre() + " -> ");
            }
            System.out.println();
        }
    }
}
