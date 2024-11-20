package Examenes.Examen2.Pregunta1;

import ADT.LinkedBinaryTree;
import ADT.Position;


public class ArbolEstudiantil extends LinkedBinaryTree<Estudiante> {
    public ArbolEstudiantil() {};

    public void setEstdiante(Estudiante est) {
        if (root() == null) addRoot(est);
        else recursiveInsert(root(), est);
    }

    private void recursiveInsert(Position<Estudiante> node, Estudiante est) {
        if (est.codigo < node.getElement().codigo) {
            if (left(node) == null) addLeft(node, est);
            else recursiveInsert(left(node), est); //insersion izq
        } else if (est.codigo > node.getElement().codigo) {
            if (right(node) == null) addRight(node, est);
            else recursiveInsert(right(node), est); // insersion der
        }
    }

    public Estudiante searchEstudianteCodigo(int codigo) {
        return searchRecursive(root(), codigo).getElement();
    }

    private Position<Estudiante> searchRecursive(Position<Estudiante> node, int codigo) {
        if (node == null || node.getElement().codigo == codigo) {
            return node; // caso base
        }
        if (codigo < node.getElement().codigo) {
            return searchRecursive(left(node), codigo);  // Búsqueda en el subárbol izquierdo
        } else {
            return searchRecursive(right(node), codigo);  // Búsqueda en el subárbol derecho
        }
    }

    public Estudiante getEstudianteMayorCodigo() {
        if (root() == null) {
            return null;  // empty
        }
        return getMayorCodigoRecursive(root()).getElement();
    }

    private Position<Estudiante> getMayorCodigoRecursive(Position<Estudiante> node) {
        if (right(node) == null) {
            return node;  // root is highest
        } else {
            return getMayorCodigoRecursive(right(node));  // busqueda por la derecha, debido al ordenamiento del arbol
        }
    }
}



