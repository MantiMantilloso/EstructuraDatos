package Practice.Clase1.Ejercicio1;

public class TEstud {
    private String nombre;
    private int edad;
    private double[] notasCursos;

    //Builders
    TEstud(String nombre, int edad, double[] notasCursos) {
        this.nombre = nombre;
        this.edad = edad;
        if (notasCursos.length == 5) { // Verifica que el array tenga longitud 5
            this.notasCursos = notasCursos;
        } else {
            throw new IllegalArgumentException("El array debe tener exactamente 5 elementos.");
        }
    }

    //Get Methods
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public double[] getNotasCursos() {
        return notasCursos;
    }



    public double promedioEstud(){
        double suma = 0;
        for(double nota : notasCursos){
            suma += nota;
        }
        return suma / notasCursos.length;
    }


}
