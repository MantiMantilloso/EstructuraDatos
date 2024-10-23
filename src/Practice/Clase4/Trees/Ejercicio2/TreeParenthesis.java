package Practice.Clase4.Trees.Ejercicio2;

import ADT.LinkedBinaryTree;
import ADT.LinkedTree;
import ADT.Position;

public class TreeParenthesis<E> extends LinkedBinaryTree<E> {
/*
    public String parentesisExpresion(Position<E> p, int indent){
        Node<E> node = (Node<E>) p;
        StringBuilder expression = new StringBuilder();
        expression.append("\t".repeat(Math.max(0, indent)));
        if (this.isInternal(node)){
            expression.append(node.getElement().toString()).append("(\n");
            indent++;
            for(Node<E> o : node.getChildren()){
                expression.append(parentesisExpresion(o, indent + 1));
            }
            indent--;
            expression.append("\t".repeat(Math.max(0, indent)));
            expression.append(")\n");
        }else
            expression.append(node.getElement().toString()).append("\n");
        return expression.toString();
    }*/
}
