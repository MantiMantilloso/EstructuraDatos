package Examenes.Examen3.Ejercicio2;

import ADT.AdjacencyMapGraph;
import ADT.Edge;
import ADT.Vertex;

import java.util.HashMap;
import java.util.Map;

import static ADT.GraphAlgorithms.shortestPathLengths;

public class RedCISCO {

    private Map<Electronic, Vertex<Electronic>> vertexMap = new HashMap<>();


    public AdjacencyMapGraph<Electronic, Integer> red =
            new AdjacencyMapGraph<Electronic,Integer>(false);

    private Vertex<Electronic> insertElemento(Electronic objeto) {
        // Verifica si el objeto ya tiene un vértice asociado
        if (!vertexMap.containsKey(objeto)) {
            Vertex<Electronic> vertex = red.insertVertex(objeto);
            vertexMap.put(objeto, vertex);
        }
        return vertexMap.get(objeto); // Retorna el vértice
    }
    private Edge<Integer> insertPeso(Electronic e1, Electronic e2, Integer weight){
        return red.insertEdge(insertElemento(e1), insertElemento(e2), weight);
    }

    public RedCISCO(){
        Electronic c1 = new Electronic("c1");
        Electronic s2 = new Electronic("s2");
        Electronic s3 = new Electronic("s3");
        Electronic c4 = new Electronic("c4");
        Electronic s5 = new Electronic("s5");
        Electronic s6 = new Electronic("s6");
        Electronic c7 = new Electronic("c7");
        Electronic c8 = new Electronic("c8");

        insertPeso(c1, s2, 2);
        insertPeso(c1, s3, 2);
        insertPeso(s2, c4, 4);
        insertPeso(s3, c4, 10);
        insertPeso(s2, s5, 10);
        insertPeso(c4, s5, 4);
        insertPeso(c4, s6, 8);
        insertPeso(s3, c8, 10);
        insertPeso(s5, c7, 2);
        insertPeso(s6, c8, 2);
        insertPeso(s6, c7, 1);
    }

    public void printShortestPaths() {
        // Seleccionar un vértice inicial (puedes ajustar esto según tu preferencia)
        Vertex<Electronic> src = red.vertices().iterator().next();

        // Ejecutar el algoritmo de Dijkstra desde el vértice inicial
        ADT.Map<Vertex<Electronic>, Integer> shortestPaths = shortestPathLengths(red, src);

        // Imprimir los resultados
        System.out.println("Caminos más cortos desde: " + src.getElement().id);
        for (Vertex<Electronic> v : shortestPaths.keySet()) {
            int distancia = shortestPaths.get(v);
            System.out.println("Hasta " + v.getElement().id + ": " + distancia + " unidades");
        }
    }

}
