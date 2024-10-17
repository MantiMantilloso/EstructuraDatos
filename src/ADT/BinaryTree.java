package ADT;

/*An interface for a binary tree in which node has at most 2 children*/
public interface BinaryTree <E> extends Tree<E> {
    /*Returns the position of p's left child (or null if it no child exists)*/
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    /*Returns the position of p's right child (or null if it no child exists)*/
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    /*Returns the position of p's sibling (or null if it no sibling exists)*/
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
