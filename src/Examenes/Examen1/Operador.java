package Examenes.Examen1;

public class Operador {
    private String nombre;
    private String codigo;

    private int llamadasAtendidas;

    public Operador(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.llamadasAtendidas = 0;
    }

    public void atenderLlamada(Llamada llamada){

        //Llamada atendida por el operador

        llamadasAtendidas++;
    }

    public int getLlamadasAtendidas() {
        return llamadasAtendidas;
    }
    public String getNombre() {
        return nombre;
    }

    public boolean isOcupado(){
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
