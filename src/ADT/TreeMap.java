package ADT;

/**An implementation of a sorted map using binary Tree search*/
public class TreeMap <K,V> extends AbstractSortedMap<K,V>{
    //To represent the underlying tree structure, we use a specialized subclass of the LinkedBinaryTree
    // class that we name BalanceableBinaryTree
    protected static class BalanceableBinaryTree<K,V>
            extends LinkedBinaryTree<Entry<K,V>>{
        //-------------- nested BSTNode class --------------
        // this extends the inherited LinkedBinaryTree.Node class
        protected static class BSTNode<E> extends Node<E> {
            int aux=0;
            BSTNode(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
                super(e, parent, leftChild, rightChild);
            }
            public int getAux() { return aux; }
            public void setAux(int value) { aux = value; }
        } //--------- end of nested BSTNode class ---------

    }

}
