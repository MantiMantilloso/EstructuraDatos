package Practice.Clase1.Ejercicio2;
import ADT.SinglyLinkedList;

public class Biblioteca {
    private SinglyLinkedList<Solicitud> rechazadas;
    private SinglyLinkedList<Solicitud> aceptadas;

    private SinglyLinkedList<Libro>libros;
    public Biblioteca() {
        rechazadas = new SinglyLinkedList<>();
        aceptadas = new SinglyLinkedList<>();
        libros = new SinglyLinkedList<>();
    };


    public void addLibro(Libro libro) {
        libros.addFirst(libro);
    }
    public void procesarSolicitud(Solicitud solicitud) {
        SinglyLinkedList.Node<Libro> current = libros.head;
        //Se itera por la lista de libros hasta encontrar uno que coincida con la solicitud
        while (current != null &&
                (!current.getElement().getAutor().equals(solicitud.getAutorSolicitado()) ||
                        !current.getElement().getTitulo().equals(solicitud.getTituloSolicitado()))) {
            current = current.getNext();
        }
        // Si se encontró el libro
        if (current != null) {
            if (current.getElement().isAvailable()) {
                current.getElement().removeEjemplar();
                aceptadas.addFirst(solicitud);
            } else {
                rechazadas.addFirst(solicitud);
            }
            return; // Salimos del metodo después de procesar la solicitud
        }

        // Si no se encontró el libro, rechazamos la solicitud
        rechazadas.addFirst(solicitud);
    }

    @Override
    public String toString() {
        return "aceptadas: " + aceptadas + " rechazadas: " + rechazadas;
    }



}
