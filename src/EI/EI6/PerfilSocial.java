package EI.EI6;

public class PerfilSocial {
    String nombre;
    int edad;
    String sexo;
    public PerfilSocial(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getSexo() {
        return sexo;
    }
    public int getEdad() {
        return edad;
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Sexo: " + sexo;
    }

}
