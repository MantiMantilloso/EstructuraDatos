package Practice.Clase4.Trees.Ejercicio1;

import ADT.LinkedBinaryTree;
import ADT.Position;

public class ArithmeticExpresionTree {
    private LinkedBinaryTree<String> tree;
    public ArithmeticExpresionTree() {
        tree = new LinkedBinaryTree<>();
    }
    // Evaluate the arithmetic tree
    public double evaluateTree(Position<String> p) {
        if (tree.isExternal(p)) { // Leaf node
            return Double.parseDouble(p.getElement());
        } else { // Internal node (operator)
            double leftVal = evaluateTree(tree.left(p));
            double rightVal = evaluateTree(tree.right(p));
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

    public String toInfixExpression(Position<String> p) {
        if (tree.isExternal(p)) { // If it's a leaf node (number)
            return p.getElement(); // Return the number as a string
        } else { // Internal node (operator)
            String leftExpr = toInfixExpression(tree.left(p));  // Recursively get left subtree
            String rightExpr = toInfixExpression(tree.right(p)); // Recursively get right subtree
            return "(" + leftExpr + " " + p.getElement() + " " + rightExpr + ")"; // Add parentheses
        }
    }

    public String toPostfixExpression(Position<String> p) {
        if (tree.isExternal(p)) { // If it's a leaf node (number)
            return p.getElement(); // Return the number as a string
        } else { // Internal node (operator)
            String leftExpr = toPostfixExpression(tree.left(p));  // Recursively get left subtree
            String rightExpr = toPostfixExpression(tree.right(p)); // Recursively get right subtree
            return leftExpr + " " + rightExpr + " " + p.getElement(); // Operator comes after operands
        }
    }

    public LinkedBinaryTree<String> buildExampleTree() {
        // Example: ((3 + 2) * (5 - 1))
        Position<String> root = tree.addRoot("*");       // Root: "*"

        Position<String> addNode = tree.addLeft(root, "+");  // Left child: "+"
        Position<String> subtractNode = tree.addRight(root, "-"); // Right child: "-"

        tree.addLeft(addNode, "3");  // Left child of "+" is 3
        tree.addRight(addNode, "2"); // Right child of "+" is 2

        tree.addLeft(subtractNode, "5"); // Left child of "-" is 5
        tree.addRight(subtractNode, "1"); // Right child of "-" is 1

        return tree;
    }





}
