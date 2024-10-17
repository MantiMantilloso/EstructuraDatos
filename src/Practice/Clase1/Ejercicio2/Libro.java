package Practice.Clase1.Ejercicio2;

public class Libro {
    private String titulo;
    private String autor;
    private int numEjemplares;
    private int numTotalejemplares;

    public Libro(String titulo, String autor, int numTotalejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.numEjemplares = numTotalejemplares;
        this.numTotalejemplares = numTotalejemplares;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public int getNumTotalejemplares() {
        return numTotalejemplares;
    }
    public void removeEjemplar(){
        if(numEjemplares>0){
            numEjemplares--;
        }
    }

    public Boolean isAvailable(){
        return numEjemplares > 0;
    }
}
