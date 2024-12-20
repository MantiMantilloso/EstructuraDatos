package ADT;

//Implementation of a Binary Tree using a node-based linked structure
public class LinkedBinaryTree <E> extends AbstractBinaryTree<E> {

    //Nested Node Class
    public static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        /*Constructs a node with the given element and it's neighbors. */
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        // Accesor Methods
        public E getElement() {return element;}
        public Node<E> getParent() {return parent;}
        public Node<E> getLeft() {return left;}
        public Node<E> getRight() {return right;}
        // Update Methods
        public void setElement(E e) {element = e;}
        public void setParent(Node<E> above) {parent = above;}
        public void setLeft(Node<E> leftChild) {left = leftChild;}
        public void setRight(Node<E> rightChild) {right = rightChild;}
    }//End of nested Node class

    /*Factory fuction to create a new node storing the element e*/
    protected Node<E> createNode(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
        return new Node<E>(e, above, leftChild, rightChild);
    }

    //LinkedBinaryTree instance variables
    protected Node<E> root = null;
    protected int size = 0;

    //constructor
    public LinkedBinaryTree() {};

    //nonpublic utility
    /*Validates the position and returns it as a node*/
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>)p;      //Safe cast
        if (node.getParent() == node)   //convention  for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    //accessor methods (not already implemented in AbstractBinaryTree)
    /*Returns the number of nodes in the tree*/
    public int size() {return size;}

    /*Returns root position of tree or null if it's empty*/
    public Position<E> root() {return root;}

    /*Returns the Position of p's parent or null if p is root*/
    public Position<E> parent(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getParent();
    }
    /*Returns the Position of p's lef child or null if p is root*/
    public Position<E> left(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getLeft();
    }
    /*Returns the Position of p's right child or null if p is root*/
    public Position<E> right(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getRight();
    }

    //update methods for LinkedBinaryTree
    /*Places element e at the root of an empty tree and returns its new Position*/
    public Position<E> addRoot(E e) throws IllegalArgumentException {
        if (!isEmpty()) throw new IllegalArgumentException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }
    /*Creates new left child of Position p storing element e; returns its Position*/
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) throw new IllegalArgumentException("p already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }
    /*Creates new right child of Position p storing element e; returns its Position*/
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }
    /*Replaces the element at Position p with e; returns  the replaced element*/
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }
    /*Attaches trees t1 & t2 as left and right subtrees of external p*/
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
        size += t1.size() + t2.size();
        if (!t1.isEmpty()){              //Attach t1 as left subtree of node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()){              //Attach t2 as right subtree of node
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }
    /*Removes node at Position p and replaces it with its child; if any*/
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if(numChildren(p)==2){
            throw new IllegalArgumentException("p has two children");
        }
        Node<E> child = (node.getLeft()!= null ? node.getLeft() : node.getRight());
        if (child != null)
            child.setParent(node.getParent()); //child's grandparent becomes its parent
        if (node == root)
            root = child;
        else{
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);               //help garbage collection
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);                //convention for defunct node
        return temp;
    }
}//End of LinkedBinaryTree class
