package Practice.Clase3;
import ADT.DoublyLinkedList;

public class Hospital {
    private String nombre;
    private String direccion;
    private int numPacientesMax;
    private DoublyLinkedList<Paciente> pacientes;

    Hospital(String nombre, String direccion, int numPacientesMax) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numPacientesMax = numPacientesMax;
    }

    public void atenderPaciente(Paciente paciente){// atiende y añade a la lista de atendidos al paciente atendido
        if (paciente.getEdad()<10){
            paciente.setAtendido();
            pacientes.addFirst(paciente);}
        else if(paciente.getEdad()>60){
            paciente.setAtendido();
            pacientes.addLast(paciente);
        }else{
            eliminarPaciente(paciente);
        }
    }

    public Paciente eliminarPaciente(Paciente paciente){
        DoublyLinkedList.Node<Paciente> current = pacientes.header.getNext();
        while (current != pacientes.trailer) { // Recorre la lista hasta llegar al trailer
            if (current.getElement().equals(paciente)) { // Compara el paciente actual con el paciente a eliminar
                pacientes.remove(current); // Utiliza el metodo remove de DoublyLinkedList para eliminarlo
                return paciente; // Retorna el paciente eliminado
            }
            current = current.getNext(); // Avanza al siguiente nodo
        }
        return null;
    }



}
