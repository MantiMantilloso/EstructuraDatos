package Examenes.Examen2.Pregunta2;

import ADT.TreeMap;
import Examenes.Examen2.Pregunta1.Estudiante;

public class CentroUSFQ extends TreeMap<Integer, String> {

    public String buscarEstudiantexCodigo(int codigo){
        return get(codigo);
    }

    public void insertarEstudiante(Estudiante estudiante) {
        put(estudiante.codigo, estudiante.nombre);
    }
    public String deleteEstudiante(Estudiante est) {
        return remove(est.codigo);
    }


}
