package Practice.Clase3;

public class Paciente {
    private String nombre;
    private int numHistoriaClinica;
    private int edad;
    private Boolean sexo; //0 masculino, 1 femenino
    private Boolean atentido;

    Paciente(String nombre, int num, int edad, Boolean sexo) {
        this.nombre = nombre;
        this.numHistoriaClinica = num;
        this.edad = edad;
        this.sexo = sexo;
        atentido = false;
    }

    public int getEdad() {
        return edad;
    }

    public Boolean isAtendido(){
        return atentido;
    }
    public void setAtendido(){
        atentido = true;
    }



}
