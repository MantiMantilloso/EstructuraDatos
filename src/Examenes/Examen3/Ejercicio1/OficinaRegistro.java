package Examenes.Examen3.Ejercicio1;

import ADT.ProbeHashMap;

public class OficinaRegistro {

    //Se trabaja con un tipo de hashing de linear probing
    ProbeHashMap<Integer, Cliente> clientes = new ProbeHashMap<>();


    public Cliente ingresarCliente(Cliente cliente){
        clientes.put(customHash(cliente.numCedula), cliente);
        return cliente;
    }
    // h(i)=(3i+5) mod 11
    public static int customHash(int i){
        return (3*i+5)%11;
    }
}
