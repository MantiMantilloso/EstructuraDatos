package EI.EI4;

public class Empleado {
    private String nombre;
    private String cargo;
    private double salario;

    public Empleado(String nombre, String cargo, double salario) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCargo() {
        return cargo;
    }
    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return cargo + ": " + nombre + " " + salario;
    }
}
