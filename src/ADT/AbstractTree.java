package ADT;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p) {return numChildren(p)>0;}
    public boolean isExternal(Position<E> p) {return numChildren(p)==0;}
    public boolean isRoot(Position<E> p) {return p == root();}
    public boolean isEmpty() {return size()==0;}
    /*Returns the numbers of levels separating Position p from the root*/
    public int depth(Position<E> p) {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }
    /*Returns the height of the subtree rooted at Position p*/
    public int height(Position<E> p) {
        int h = 0;
        for (Position<E> c : children(p)) {
            h = Math.max(h, height(c));
        }
        return h;
    }
    //Nested ElementIteratorClass
    /*This class adapts the iteration produced by positions() to return elements*/
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator=positions().iterator();
        public boolean hasNext() {return posIterator.hasNext();}
        public E next() {return posIterator.next().getElement();}
        public void remove() {posIterator.remove();}
    }
    /*Returns an Iterator of the elements stored in the tree*/
    public Iterator<E> iterator() {return new ElementIterator();}

    //Traversal Methods

    public Iterable<Position<E>> positions() {return preorder();} //so that requisites are met
    /*Adds the positions of the subtree rooted at position p to the given snapshot*/
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) { //for preorder
        snapshot.add(p);// for preorder, we add position before exploring subtrees
        for (Position<E> c : children(p)) {
            preorderSubtree(c, snapshot);
        }
    }
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {//for postorder
        for (Position<E> c : children(p)) {
            postorderSubtree(c, snapshot);
        }
        snapshot.add(p);
    }
    /*Returns an iterable collection of positions of the tree, reported in preorder*/
    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            preorderSubtree(root(), snapshot);// fill the snapshot recursively
        return snapshot;
    }
    /*Returns an iterable collection of positions of the tree, reported in postorder*/
    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            postorderSubtree(root(), snapshot);// fill the snapshot recursively
        return snapshot;
    }
    /*Returns an iterable collection of positions of the tree in breadth-first order*/
    public Iterable<Position<E>> breadthFirst(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for (Position<E> c : children(p))
                    fringe.enqueue(c);
            }
        }
        return snapshot;
    }



}
