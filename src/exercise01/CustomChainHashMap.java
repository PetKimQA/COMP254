package exercise01;

import examples.ChainHashMap;

public class CustomChainHashMap<K, V> extends ChainHashMap<K, V> {
    private double maxLoadFactor;

    public CustomChainHashMap(int cap, int p, double loadFactor) {
        super(cap, p);  // call parent
        this.maxLoadFactor = loadFactor;
    }

    @Override
    public V put(K key, V value) {
        V result = super.put(key, value);
        if (size() > maxLoadFactor * capacity)
            resize(2 * capacity - 1);
        return result;
    }
}
