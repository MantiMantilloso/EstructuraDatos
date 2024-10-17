package Examenes.Examen1;

public class Llamada {

    private String nombre;
    private String motivo; //soporte tecnico, pagar facturas o cambiar planes de servicio
    public String numeroTelf;

    public Llamada(String nombre, String motivo, String numeroTelf) {
        this.nombre = nombre;
        if (motivo.equals("soporte tecnico") || motivo.equals("pagar facturas")|| motivo.equals("cambiar planes de servicio"))
            this.motivo = motivo;
        else
            throw new IllegalArgumentException("El motivo no es valido");
        this.numeroTelf = numeroTelf;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getNumeroTelf() {
        return numeroTelf;
    }
}
