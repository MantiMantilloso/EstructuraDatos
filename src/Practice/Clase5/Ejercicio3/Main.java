package Practice.Clase5.Ejercicio3;

public class Main {
    public static void main(String[] args) {

        PolinomialBinaryTree tree = new PolinomialBinaryTree();

        tree.buildPolynomialTree();
        System.out.println(tree.solveForX(3));
    }
}
