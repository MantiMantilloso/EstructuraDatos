package Practice.Clase1.Ejercicio1;
import ADT.SinglyLinkedList;

import java.util.TreeSet;


public class TGrupo {
    private SinglyLinkedList<TEstud> listaEstud;
    //Builder
    TGrupo() {
        listaEstud = new SinglyLinkedList<>();
    };
    TGrupo(SinglyLinkedList<TEstud> listaEstud) {
        this.listaEstud = listaEstud;
    }

    //Add TEstud
    public void addEstud(TEstud estud) {
        listaEstud.addFirst(estud);
    }

    public TEstud promedioMasAltoEstud() {
        //Inicializar un puntero node
        SinglyLinkedList.Node<TEstud> current = listaEstud.head;
        if (current == null) {  // Si la lista está vacía, retorna null
            return null;
        }
        TEstud estudMax = current.getElement();
        while(current != null) {
            TEstud estudActual = current.getElement();
            if (estudActual.promedioEstud() > estudMax.promedioEstud()) {
                estudMax = estudActual;
            }
            current = current.getNext();
        }
        return estudMax;//
    }

    public double promedioMaximo(){
        return promedioMasAltoEstud().promedioEstud();
    }




}
