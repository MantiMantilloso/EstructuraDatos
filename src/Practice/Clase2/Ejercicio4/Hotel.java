package Practice.Clase2.Ejercicio4;

public class Hotel {

    private String nombre;
    private int [] habitaciones;
    private int numHabitacionesDisponibles;
    public Hotel(String nombre, int numHabitaciones) {
        this.nombre = nombre;
        this.habitaciones = new int[numHabitaciones];
        for (int i = 0; i < numHabitaciones; i++) {
            habitaciones[i] = i+1;
        }
        numHabitacionesDisponibles = numHabitaciones;
    }
    public String getNombre() {
        return nombre;
    }
    public int getNumHabitaciones() {
        return habitaciones.length;
    }
    public void removeHabitacion(){
        numHabitacionesDisponibles--;
    }
    public boolean isFull(){
        return numHabitacionesDisponibles < 1;
    }

}
