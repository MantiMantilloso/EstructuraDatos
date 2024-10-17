package ADT;

public class LinkedQueue<E> implements Queue<E>{
    public SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public LinkedQueue() {}


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
