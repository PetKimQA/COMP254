package exercise2;
import examples.LinkedQueue;

/**
 * ex2 demo
 * */
public class Exercise2Demo {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        //adding test data
        int[] data = {42, 5, 12, 77, 1, 9, 31, 60, 18, 55};
        for (int x : data) queue.enqueue(x);

        System.out.println("Before: " + queue);
        BottomUpMergeSort.sort(queue);
        System.out.println(" After: " + queue);
    }
}
