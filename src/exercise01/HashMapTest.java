package exercise01;

import examples.AbstractHashMap;

import java.util.Random;

public class HashMapTest {
    public static void main(String[] args) {
        int numElements = 100_000;
        double[] loadFactors = {0.5, 0.75, 0.9};

        for (double lf : loadFactors) {
            System.out.println("=== exercise01.CustomChainHashMap | Load Factor: " + lf + " ===");
            CustomChainHashMap<Integer, Integer> chainMap = new CustomChainHashMap<>(17, 109345121, lf);
            runTest(chainMap, numElements);
            System.out.println();
        }
    }

    private static void runTest(AbstractHashMap<Integer, Integer> map, int numElements) {
        Random rand = new Random();

        // Insert
        long insertStart = System.currentTimeMillis();
        for (int i = 0; i < numElements; i++) {
            int key = rand.nextInt(numElements * 10);
            map.put(key, i);
        }
        long insertEnd = System.currentTimeMillis();

        // Lookup
        long lookupStart = System.currentTimeMillis();
        for (int i = 0; i < numElements; i++) {
            int key = rand.nextInt(numElements * 10);
            map.get(key);
        }
        long lookupEnd = System.currentTimeMillis();

        // Print results
        System.out.println("Inserted " + numElements + " items");
        System.out.println("Insert Time : " + (insertEnd - insertStart) + " ms");
        System.out.println("Lookup Time : " + (lookupEnd - lookupStart) + " ms");
        System.out.println("Map Size    : " + map.size());
        System.out.println("Capacity    : " + getCapacity(map));
        System.out.println("--------------------------------------------");
    }

    private static int getCapacity(AbstractHashMap<?, ?> map) {
        try {
            java.lang.reflect.Field capField = AbstractHashMap.class.getDeclaredField("capacity");
            capField.setAccessible(true);
            return capField.getInt(map);
        } catch (Exception e) {
            return -1;
        }
    }
}
