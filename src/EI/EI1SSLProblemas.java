package EI;
import ADT.SinglyLinkedList;
//ESTUDIO INDEPENDIENTE 1 MAURICIO MANTILLA
public class EI1SSLProblemas {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
        }
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        list.addLast(55);
        System.out.println(list);

        SinglyLinkedList<Mascota> listaMascota = new SinglyLinkedList<>();
        Mascota mascota1 = new Mascota("Pisco", "Gato");
        Mascota mascota2 = new Mascota("Luna", "Gato");
        Mascota mascota3 = new Mascota("Bruce", "Perro");



        listaMascota.addFirst(mascota1);
        listaMascota.addFirst(mascota2);
        listaMascota.addLast(mascota3);

        System.out.println(listaMascota);
        listaMascota.removeFirst();
        System.out.println(listaMascota);
    }

    public static class Mascota{

        private String nombre;
        private String especie;

        public Mascota(String nombre, String especie) {
            this.especie = especie;
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre + " " + especie;
        }
    }
}
