package Examenes.Examen3.Ejercicio1;

public class Cliente {
    public String nombreCompleto;
    public int numCedula; //Se trabaja con este para obtener el codigo de hashing
    public String genero;
    public String direccion;

    public Cliente (String nombre, int numCedula, String genero, String direccion) {
        this.nombreCompleto = nombre;
        this.numCedula = numCedula;
        this.genero = genero;
        this.direccion = direccion;
    }

}
