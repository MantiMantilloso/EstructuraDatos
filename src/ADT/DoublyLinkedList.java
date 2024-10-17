package ADT;

public class DoublyLinkedList <E>{
    //nested Node class
    public static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p , Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        public E getElement(){return element;}
        public Node<E> getPrev(){return prev;}
        public Node<E> getNext(){return next;}
        public void setPrev(Node<E> p){prev = p;}
        public void setNext(Node<E> n){next = n;}
    }//end of nested Node class
    //instance variables
    public Node<E> header;
    public Node<E> trailer;
    private int size = 0;
    //Construct an empty list
    public DoublyLinkedList(){
        header = new Node<E>(null, null, null);//create null header
        trailer = new Node<E>(null, header, null);//trailer is preceded by header
        header.setNext(trailer);//header is followed by trailer
    }
    public int size(){return size;} //returns the amount of elements in the linked list
    public boolean isEmpty(){return size == 0;}
    public E first(){ // returns the first element on the list
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }
    public E last(){//returns the last element on the list
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();
    }
    //update methods
    public void addFirst(E e){//adds element in front of the list
        addBetween(e, header, header.getNext());//place after the header
    }
    public void addLast(E e){//adds element to the end of the list
        addBetween(e, trailer.getPrev(), trailer);//place before the trailer
    }
    public E removeFirst(){//returns and removes the element next to the header
        if(isEmpty()) return null;
        return remove(header.getNext());//first element is after header
    }
    public E removeLast(){//returns and removes the element before to the trailer
        if(isEmpty()) return null;
        return remove(trailer.getPrev());//last element is before trailer
    }
    public void addBetween(E e, Node<E> predecesor, Node<E> sucessor){//adds e between the given nodes
        Node <E> newest = new Node<E>(e, predecesor, sucessor);
        predecesor.setNext(newest);
        sucessor.setPrev(newest);
        size++;
    }
    public E remove(Node<E> node){//removes and returns element e from the list
        Node<E> predecessor = node.getPrev();
        Node <E> sucessor = node.getNext();
        predecessor.setNext(sucessor);
        sucessor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = header.getNext();
        while (current != trailer) {  // Traverse until the trailer
            sb.append(current.getElement()).append(" <-> ");
            current = current.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}//end of DoublyLinkedList class
