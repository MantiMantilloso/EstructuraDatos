package ADT;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap <K,V> extends AbstractMap<K,V> {
    /**Underlying storage for the map of entries*/
    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

    /**Constructs an intially empty map*/
    public UnsortedTableMap() {};

    //private utility
    /**Returns the index of an Entry with equal key, or -1 if none found*/
    private int findIndex (K key){
        int n = table.size();
        for (int i = 0; i < n; i++) {
            if (table.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1; //special value, key not found
    }
    /**Returns the number of entries in the Map*/
    public int size() { return table.size(); }
    /**Returns the value associated with the specified Key (or else null)*/
    public V get(K key) {
        int index = findIndex(key);
        if (index == -1) return null; //not found
        return table.get(index).getValue();
    }
    /**Associates given value with given key, replacing a previous value(if any)*/
    public V put(K key, V value){
        int index = findIndex(key);
        if (index == -1) {
            table.add(new MapEntry<>(key, value)); //add new entry
            return null;
        } else                                     //key already exists
            return table.get(index).getValue();    //replaced value is returned
    }
    /**Removes the entry with the specified Key (if any) and Returns its value*/
    public V remove(K key){
        int index = findIndex(key);
        int n = size();
        if (index == -1) return null;              //not found
        V answer = table.get(index).getValue();
        if (index == n-1)
            table.set(index, table.get(n-1));      //relocate last entry to 'hole' created by removal
        table.remove(n-1);
        return answer;
    }
    //Support for public entrySet method...
    private class EntryIterator implements Iterator <Entry<K,V>> {
        private int index = 0;
        public boolean hasNext() { return index < table.size(); }
        public Entry<K,V> next() {
            if (index == table.size()) throw new NoSuchElementException();
            return table.get(index++);
        }
        public void remove() { throw new UnsupportedOperationException(); };
    }
    private class EntryIterable implements Iterable <Entry<K,V>> {
        public Iterator<Entry<K,V>> iterator() { return new EntryIterator(); };
    }
    /**Returns an iterable collection of all key-value entries of the map*/
    public Iterable <Entry<K,V>> entrySet() { return new EntryIterable(); }
}
