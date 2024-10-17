package Practice.Clase1.Ejercicio2;

public class Solicitud {
    private String estudiante;
    private String autor;
    private String titulo;

    Solicitud(String est, String t, String a) {
        this.estudiante = est;
        this.autor = a;
        this.titulo = t;
    }

    public String getAutorSolicitado(){
        return autor;
    }
    public String getTituloSolicitado(){
        return titulo;
    }

    @Override
    public String toString() {
        return estudiante + " - " + autor + " - " + titulo;
    }

}
