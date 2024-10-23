package Practice.Clase4.Trees.Ejercicio3;

import ADT.LinkedBinaryTree;
import ADT.LinkedTree;
import ADT.Position;
/*
public class TreeEx3 {
    public LinkedBinaryTree<E> OverallTree2BinaryTree(LinkedTree<E> T){
        LinkedBinaryTree<E> binaryTree = new LinkedBinaryTree<Object>();
        if (!T.isEmpty()) {
            binaryTree.addRoot(T.root().getElement());
            covertSubtree(T, T.root(), binaryTree, binaryTree.root());
        }
        return binaryTree;

    }


    private void convertSubtree (LinkedTree<E>T, Position<E> nodeInT, LinkedBinaryTree<E> binaryTree, Position<E> nodeInBinaryTree){
        LinkedTree.Node<E> currentNodeInT = (LinkedTree<E>) nodeInT;
        LinkedBinaryTree.Node<E> currentNodeInBinary = (LinkedBinaryTree<E>) nodeInBinaryTree;

        ArrayList<LinkedTree.Node<E>> children = currentNodeInT.getChildren();
        LinkedBinaryTree.Node<E> lastCreatedNode = null;

        // Process each child in T and build the corresponding left child and right siblings in binary tree
        for (int i = 0; i < children.size(); i++) {
            LinkedTree.Node<E> childInT = children.get(i);

            // Create the binary tree node for this child
            LinkedBinaryTree.Node<E> childInBinary = binaryTree.createNode(childInT.getElement(), currentNodeInBinary, null, null);

            if (i == 0) {
                // The first child of T becomes the left child of binary tree node
                currentNodeInBinary.setLeft(childInBinary);
            } else {
                // Subsequent children become right siblings in binary tree
                lastCreatedNode.setRight(childInBinary);
            }

            // Recurse into this child to convert its subtree
            convertSubtree(T, childInT, binaryTree, childInBinary);

            // Keep track of the last created node to link right siblings
            lastCreatedNode = childInBinary;
        }

    }
}
*/