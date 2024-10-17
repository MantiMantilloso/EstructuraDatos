package Practice.Clase4.Trees.Ejercicio1;

import ADT.LinkedBinaryTree;

public class Main {
    public static void main(String[] args) {
        ArithmeticExpresionTree arithmeticExpresionTree = new ArithmeticExpresionTree();
        LinkedBinaryTree<String> tree = arithmeticExpresionTree.buildExampleTree();

        // Infix Expression
        String infixExpr = arithmeticExpresionTree.toInfixExpression(tree.root());
        System.out.println("Infix Expression: " + infixExpr); // Output: ((3 + 2) * (5 - 1))

        // Postfix Expression
        String postfixExpr = arithmeticExpresionTree.toPostfixExpression(tree.root());
        System.out.println("Postfix Expression: " + postfixExpr); // Output: 3 2 + 5 1 - *

        //Evaluation of Tree
        System.out.println("The result of the operation is: " + arithmeticExpresionTree.evaluateTree(tree.root()));
    }
}
