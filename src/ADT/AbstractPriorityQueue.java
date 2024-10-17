package ADT;

import java.util.Comparator;

public abstract class AbstractPriorityQueue <K,V> implements PriorityQueue<K,V> {
    //nested PQ entry class
    protected static class PQEntry<K,V> implements Entry<K,V> {
        private K k;
        private V v;
        public PQEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }
        //methods of the Entry face
        public K getKey() { return k; }
        public V getValue() { return v; }
        //Utilities not exposed as part of the entry interface
        protected void setKey(K k) { this.k = k; }
        protected void setValue(V v) { this.v = v; }
    }//end of nested PQ entry class

    //Instance variable for an Abstract Priority Queue
    /*The comparator defining the ordering of keys in the priority queue. */
    private Comparator<K> comp;
    /*Creates an empty priority queue using the given comparator to order keys. */
    protected AbstractPriorityQueue(Comparator<K> c) {comp = c;}
     /*Creates an empty priority queue based on the natural ordering of its keys. */
    protected AbstractPriorityQueue() {this(new DefaultComparator<K>());}
     /*Method for comparing two entries according to key*/
    protected int compare(Entry<K,V> a, Entry<K,V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }
    /*Determines whether a key is valid. */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return comp.compare(key, key) == 0; //see if key can be compared to itself
        }catch (ClassCastException e){
            throw new IllegalArgumentException();
        }
    }
    /*Tests whether the priority queue is empty. */
    public boolean isEmpty() {return size() == 0;}
}

//Implementa sortedPriority Queue y unsorted priority Queue