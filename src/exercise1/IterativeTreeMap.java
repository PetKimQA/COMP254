package exercise1;

import java.util.Comparator;
import examples.TreeMap1;
import examples.Position;
import examples.Entry;

/**
 * Iterative version of treeSearch
 */
public class IterativeTreeMap<K,V> extends TreeMap1<K,V> {

    public IterativeTreeMap() { super(); }
    public IterativeTreeMap(Comparator<K> comp) { super(comp); }

    @Override
    protected Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key) {

        while (isInternal(p)) {
            int compareResult = compare(key, p.getElement());
            if (compareResult == 0) return p;              // if found, return it where it is.
            p = (compareResult < 0) ? left(p) : right(p);  // if result is less than 0, go left. else, go right.
            //System.out.println("step -> " + compareResult); // for debugging purpose
        }

        // When it's not found, return the position
        return p;
    }

}
