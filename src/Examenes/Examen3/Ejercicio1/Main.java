package Examenes.Examen3.Ejercicio1;

import static Examenes.Examen3.Ejercicio1.OficinaRegistro.customHash;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {12,44,13,88,23,94,11,39,20,16,5};

        for (int numero : numeros){
            System.out.println(customHash(numero));
        }
    }
}
