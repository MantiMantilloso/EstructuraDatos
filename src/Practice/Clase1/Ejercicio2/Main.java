package Practice.Clase1.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioUsfq = new Biblioteca();
        Libro libro1 = new Libro("1984", "George Orwell", 3);
        Libro libro2 = new Libro("La Granja", "George Orwell", 3);

        Solicitud solicitudMauricio = new Solicitud("Mauricio", "1984", "George Orwell");
        Solicitud solicitudJames = new Solicitud("James", "1984", "George Orwell");
        Solicitud solicitudJosues = new Solicitud("Josues", "1984", "George Orwell");
        Solicitud solicitudMapu = new Solicitud("Mapu", "1984", "George Orwell");



        biblioUsfq.addLibro(libro1);
        biblioUsfq.procesarSolicitud(solicitudMauricio);
        biblioUsfq.procesarSolicitud(solicitudMapu);
        biblioUsfq.procesarSolicitud(solicitudJames);
        biblioUsfq.procesarSolicitud(solicitudJosues);

        System.out.println(biblioUsfq);
    }
}
