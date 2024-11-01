package EI.EI5;

public class Factura {

    private String numero;
    private String nombre;
    private double total;

    Factura (String numero, String nombre, double total) {
        this.numero = numero;
        this.nombre = nombre;
        this.total = total;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public int hashCode() {
        // Convertimos los dos últimos dígitos del número de factura a un entero
        return Integer.parseInt(numero.substring(numero.length() - 2));
    }

    @Override
    public String toString() {
        return "Factura{" +
                "numero='" + numero + '\'' +
                ", nombre='" + nombre + '\'' +
                ", total=" + total +
                '}';
    }
}
