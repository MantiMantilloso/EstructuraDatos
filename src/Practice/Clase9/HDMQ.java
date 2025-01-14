package Practice.Clase9;

import ADT.AdjacencyMapGraph;
import ADT.Edge;
import ADT.Map;
import ADT.Vertex;

import static ADT.GraphAlgorithms.shortestPathLengths;


//Short for: Hospital Distrito Metropolitano de Quito
public class HDMQ{

    public AdjacencyMapGraph<Habitacion,Integer> graph;

    public Vertex<Habitacion> insertHabitacion(Habitacion habitacion){
        return graph.insertVertex(habitacion);
    }
    public Edge<Integer> insertPasillo(Vertex<Habitacion> v1, Vertex<Habitacion> v2, Integer dist){
        return graph.insertEdge(v1, v2, dist);
    }

    public HDMQ(boolean directed){
        this.graph = new AdjacencyMapGraph<>(directed);
    }


    private Habitacion[][] getHabitaciones() {
        Habitacion emergencias1 = new Habitacion("EM1");
        Habitacion emergencias2 = new Habitacion("EM2");
        Habitacion espera1 = new Habitacion("ES1");
        Habitacion espera2 = new Habitacion("ES2");
        Habitacion espera3 = new Habitacion("ES3");
        Habitacion consultorio3 = new Habitacion("CO3");
        Habitacion consultorio4 = new Habitacion("CO4");

        Habitacion[][] habitaciones ={
                {emergencias1, emergencias2, },
                {espera1, espera2},
                {espera3, espera2},
                {consultorio3, consultorio4},
                {emergencias1, consultorio3}
        };

        return habitaciones;
    }

    public void printShortestPaths() {
        // Seleccionar un vértice inicial (puedes ajustar esto según tu preferencia)
        Vertex<Habitacion> src = graph.vertices().iterator().next();

        // Ejecutar el algoritmo de Dijkstra desde el vértice inicial
        Map<Vertex<Habitacion>, Integer> shortestPaths = shortestPathLengths(graph, src);

        // Imprimir los resultados
        System.out.println("Caminos más cortos desde: " + src.getElement().id);
        for (Vertex<Habitacion> v : shortestPaths.keySet()) {
            int distancia = shortestPaths.get(v);
            System.out.println("Hasta " + v.getElement().id + ": " + distancia + " unidades");
        }
    }

}
