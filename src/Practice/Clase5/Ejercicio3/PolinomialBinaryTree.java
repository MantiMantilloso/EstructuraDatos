package Practice.Clase5.Ejercicio3;

import ADT.LinkedBinaryTree;
import ADT.Position;

public class PolinomialBinaryTree {
    // Builds the arithmetic expression tree for the polynomial x^2 - 2x + 1
    public LinkedBinaryTree<String> buildPolynomialTree() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

        // Add root node with '+'
        Position<String> root = tree.addRoot("+");

        // Add '-' as left child of '+'
        Position<String> minus = tree.addLeft(root, "-");

        // Add '1' as right child of '+'
        tree.addRight(root, "1");

        // Add '*' (x * x) as left child of '-'
        Position<String> multXX = tree.addLeft(minus, "*");

        // Add '*' (2 * x) as right child of '-'
        Position<String> mult2X = tree.addRight(minus, "*");

        // Add 'x' and 'x' as children of '*'
        tree.addLeft(multXX, "x");
        tree.addRight(multXX, "x");

        // Add '2' and 'x' as children of '*' (2 * x)
        tree.addLeft(mult2X, "2");
        tree.addRight(mult2X, "x");

        return tree;
    }

    // Evaluates the tree for any value of x
    protected double evaluateForX(LinkedBinaryTree<String> tree, Position<String> p, double x) {
        if (tree.isExternal(p)) { // Leaf node
            String element = p.getElement();
            if (element.equals("x")) {
                return x; // Return the value of x
            } else {
                return Double.parseDouble(element); // It's a number (e.g., 1 or 2)
            }
        } else { // Internal node (operator)
            double leftVal = evaluateForX(tree, tree.left(p), x);  // Recursively evaluate left subtree
            double rightVal = evaluateForX(tree, tree.right(p), x); // Recursively evaluate right subtree
            String operator = p.getElement();
            return switch (operator) {
                case "+" -> leftVal + rightVal;
                case "-" -> leftVal - rightVal;
                case "*" -> leftVal * rightVal;
                case "/" -> leftVal / rightVal;
                default -> throw new IllegalArgumentException("Invalid operator: " + operator);
            };
        }
    }

    public double solveForX(double x) {
        PolinomialBinaryTree exprTree = new PolinomialBinaryTree();
        LinkedBinaryTree<String> tree = exprTree.buildPolynomialTree();
        return exprTree.evaluateForX(tree, tree.root(), x);
    }
}
