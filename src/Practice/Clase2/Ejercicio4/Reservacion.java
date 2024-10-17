package Practice.Clase2.Ejercicio4;

public class Reservacion {

    private int codigo;
    private String nombre;
    private String nomHotel;
    private boolean VIP; //0 if not VIP, 1 if VIP
    private int diasEstancia;
    private int numHabitacion;

    Reservacion(int code, String name, String hotel, boolean vip, int diasEstancia){
        this.codigo = code;
        this.nombre = name;
        this.nomHotel = hotel;
        this.VIP = vip;
        this.diasEstancia = diasEstancia;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public boolean isVIP() {
        return VIP;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }
}
