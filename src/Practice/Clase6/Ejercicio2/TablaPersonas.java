package Practice.Clase6.Ejercicio2;

import ADT.ProbeHashMap;

public class TablaPersonas {

    ProbeHashMap<Integer, Persona> hashPersonas = new ProbeHashMap<Integer, Persona>();

    public Persona insertPersona(Persona persona) {
        hashPersonas.put(persona.cedula%1000, persona);
        return persona;
    }

    public void printFicha(int cedula){
        Persona personaHallada  = hashPersonas.get(cedula);
        System.out.println(personaHallada.toString());
    }

    public void printAllFichas(){
        hashPersonas.entrySet().toString();
    }

}
