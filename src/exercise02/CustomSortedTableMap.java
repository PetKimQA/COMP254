package exercise02;

import examples.SortedTableMap;

public class CustomSortedTableMap<K extends Comparable<K>, V> extends SortedTableMap<K, V> {

    public CustomSortedTableMap() {
        super();  // call parent constructor
    }

    public boolean containsKey(K key) {
        int index = findIndex(key);
        return (index < table.size() && table.get(index).getKey().equals(key));
    }
}
