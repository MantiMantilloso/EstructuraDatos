package Practice.Clase1.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        double [] notas1 = {10, 9, 9.5, 9.6, 6};
        double [] notas2 = {10, 9, 9.4, 9.6, 7};
        double [] notas3 = {6, 9, 9.3, 9.8, 7};


        TEstud estudiante1 = new TEstud("Manti", 20, notas1);
        TEstud estudiante2 = new TEstud("James", 20, notas2);
        TEstud estudiante3 = new TEstud("Mapu", 20, notas3);

        TGrupo clase1 = new TGrupo();

        clase1.addEstud(estudiante1);
        clase1.addEstud(estudiante2);
        clase1.addEstud(estudiante3);

        System.out.println(clase1.promedioMasAltoEstud().getNombre());
        System.out.println(clase1.promedioMaximo());
    }
}
