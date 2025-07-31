package exercise01;

import examples.AbstractHashMap;

public abstract class CustomAbstractHashMap<K, V> extends AbstractHashMap<K, V> {
    protected double maxLoadFactor = 0.5;  // default

    public CustomAbstractHashMap() {
        super();
    }

    public CustomAbstractHashMap(int cap, int p, double loadFactor) {
        super(cap, p);  // use base constructor
        maxLoadFactor = loadFactor;
    }

    @Override
    public V put(K key, V value) {
        V answer = super.put(key, value);
        if (n > maxLoadFactor * capacity)
            resize(2 * capacity - 1);  // resize if exceeded
        return answer;
    }
}
