package EI;
import ADT.LinkedStack;
import ADT.LinkedQueue;

public class EI2 {
    public static void main(String[] args) {
        // Hacer ejemplo de queue y stack
        LinkedQueue<Usuario> colaUsuarios = new LinkedQueue<>();
        LinkedStack<Usuario> pilaUsuarios = new LinkedStack<>();

        Usuario invitado1 = new Usuario("usfqinvitado1", "invitado1@usfq.edu.ec");
        Usuario invitado2 = new Usuario("usfqinvitado2", "invitado2@usfq.edu.ec");
        Usuario computacion1 = new Usuario("computacion1", "computacion1@usfq.edu.ec");
        Usuario computacion2 = new Usuario("computacion2", "computacion2@usfq.edu.ec");
        Usuario finanzas1 = new Usuario("finanzas1", "finanzas@usfq.edu.ec");
        Usuario finanzas2 = new Usuario("finanzas2", "finanzas@usfq.edu.ec");

        //Ejemplo LinkedQueue
        System.out.println("-------Inicio de la cola de espera-------");
        colaUsuarios.enqueue(computacion1);
        System.out.println(colaUsuarios);
        colaUsuarios.enqueue(computacion2);
        colaUsuarios.enqueue(finanzas1);
        colaUsuarios.enqueue(finanzas2);
        System.out.println(colaUsuarios);
        System.out.println("En este momento se encuentran " + colaUsuarios.size() + " usuarios en la cola, el primero es:" + colaUsuarios.first());
        colaUsuarios.dequeue();
        System.out.println(colaUsuarios);
        while (!colaUsuarios.isEmpty()) {
            System.out.println("En este momento se encuentran " + colaUsuarios.size() + " usuarios en la cola, el primero es:" + colaUsuarios.first().getUsername());
            colaUsuarios.dequeue();
        }
        System.out.println(colaUsuarios);
        System.out.println("Se ha vaciado la cola");

        //Ejemplo LinkedStack
        System.out.println("-------Inicio de la pila -------");
        pilaUsuarios.push(computacion1);
        pilaUsuarios.push(computacion2);
        pilaUsuarios.push(invitado1);
        pilaUsuarios.push(invitado2);
        System.out.println(pilaUsuarios);
        while (!pilaUsuarios.isEmpty()) {
            System.out.println("En este momento se encuentran "  + pilaUsuarios.size() +  " usuarios en la pila, el primero es:" + pilaUsuarios.top().getUsername());
            pilaUsuarios.pop();
        }
        System.out.println(pilaUsuarios);
        System.out.println("Se ha vaciado la pila");
    }

    public static class Usuario{
        //Para el ejemplo de queue
        private String username;
        private String email;

        Usuario (String username, String email){
            this.username = username;
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        @Override
        public String toString() {
            return username + " " + " " + email;
        }

    }


}
