package Examenes.Examen1;

import ADT.LinkedQueue;

public class EmpresaTelecomunicacion {
    private LinkedQueue<Operador> operadores;
    private LinkedQueue<Llamada> llamadas;

    EmpresaTelecomunicacion(){
        operadores = new LinkedQueue<>();
        llamadas = new LinkedQueue<>();
    }


    public void addLlamada(Llamada llamada){ //Literal b, agrega una llamada entrante en O(1)
        llamadas.enqueue(llamada);
    }

    public void addOperador(Operador operador){//Literal c, agrega un operador en O(1)
        operadores.enqueue(operador);
    }

    public void procesarLlamadas(){ //este metodo procesa llamadas en orden de una cola, tiene eficiencia O(n)
        LinkedQueue<Operador> operadoresOcupados = new LinkedQueue<>();
        while(!llamadas.isEmpty()){//sigue hasta que la cola de llamadas este vacia | O(n)
            operadores.first().atenderLlamada(llamadas.dequeue()); //el primer operador disponible atiende la llamada, la llamada se elimina | O(1)
            operadoresOcupados.enqueue(operadores.dequeue()); //el operador ocupado es sacado de la lista de disponibles y añadido a la lista de ocupados | O(1)
        }
        while(!operadoresOcupados.isEmpty()){//los ocupados dependen de la cantidad de llamadas | O(n)
            operadores.enqueue(operadoresOcupados.dequeue());//los ocupados son añadidos nuevamente a la lista de operadores disponibles | O(1)
        }

        //hay dos ciclos while que dependen del tamaño de llamadas, sin embargo, no estan anidados, esto significa que este metodo tiene un big O lineal | O(n)
    }


    public int llamadasAtendidas(String nombre){//Buscar el operador por su nombre, y retornar .getLlamadasAtendidas()
        LinkedQueue<Operador> operadoresaux = new LinkedQueue<>();

        operadoresaux = operadores;

        while(!operadoresaux.first().getNombre().equals(nombre)){
            operadores.enqueue(operadoresaux.dequeue());
        }

        return operadoresaux.first().getLlamadasAtendidas();

    }

    public LinkedQueue<Operador> getOperadores() {
        return operadores;
    }

}
