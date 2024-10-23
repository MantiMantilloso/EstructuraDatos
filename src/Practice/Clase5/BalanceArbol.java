package Practice.Clase5;

import ADT.Entry;
import ADT.Position;
import ADT.TreeMap;

    public class BalanceArbol<K,V> extends TreeMap<K,V> {
        public void rotateTree(K k){
            Position<Entry<K, V>> center = treeSearch(root(), k);
            rotate(center);
        }
    }

