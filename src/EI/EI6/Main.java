package EI.EI6;

import ADT.Edge;
import ADT.Graph;
import ADT.Map;
import ADT.Vertex;

import static ADT.GraphAlgorithms.BFSComplete;
import static ADT.GraphAlgorithms.DFSComplete;
import static EI.EI6.GrafoAmistades.showPaths;


public class Main {

    public static void main(String[] args) {
        // Crea algunos perfiles
        PerfilSocial[][] amistades = getPerfilesSociales();

        // Crear el grafo a partir de los perfiles y aristas
        Graph<PerfilSocial, Integer> grafo = GrafoAmistades.graphFromEdgelist(amistades, false);

        System.out.println("Alphabet");
        System.out.println(grafo);
        System.out.println("DFS Traversal:");
        Map<Vertex<PerfilSocial>, Edge<Integer>> dfsForest = DFSComplete(grafo);
        showPaths(grafo, dfsForest);
        System.out.println("BFS Traversal:");
        Map<Vertex<PerfilSocial>, Edge<Integer>> bfsForest = BFSComplete(grafo);
        showPaths(grafo, bfsForest);


    }

    private static PerfilSocial[][] getPerfilesSociales() {
        PerfilSocial p1 = new PerfilSocial("Alice", 25, "F");
        PerfilSocial p2 = new PerfilSocial("Bob", 30, "M");
        PerfilSocial p3 = new PerfilSocial("Charlie", 22, "M");
        PerfilSocial p4 = new PerfilSocial("David", 30, "M");
        PerfilSocial p5 = new PerfilSocial("Daniel", 30, "M");
        PerfilSocial p6 = new PerfilSocial("Elizabeth", 30, "F");

        // Lista de aristas (parejas de PerfilSocial) para construir el grafo
        PerfilSocial[][] amistades = {
                {p1, p2},
                {p1, p3},
                {p2, p4},
                {p3, p5},
                {p2, p6},
                {p4, p5},

        };
        return amistades;
    }
}
