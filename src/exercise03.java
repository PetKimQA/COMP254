import courseExamples.HeapPriorityQueue;
import courseExamples.Entry;

public class exercise03<K, V> extends HeapPriorityQueue<K, V> {

    @Override
    protected void upheap(int j) {
        if (j == 0) return; // Base case: at root

        int p = parent(j);
        // if parent is bigger, swap it then recursively
        if (compare(heap.get(j), heap.get(p)) < 0) {
            swap(j, p);
            upheap(p); // Go up recursively
        }
    }
    // test
    public static void main(String[] args) {
        // Integer: key (priority), String: value
        exercise03<Integer, String> heap = new exercise03<>();

        heap.insert(20, "C");
        heap.insert(10, "B");
        heap.insert(5, "A");
        heap.insert(15, "D");
        heap.insert(2, "E");

        System.out.println("Removing elements in order of priority (min-heap):");
        while (!heap.isEmpty()) {
            Entry<Integer, String> min = heap.removeMin();
            System.out.println("Key: " + min.getKey() + ", Value: " + min.getValue());
        }
    }
}
