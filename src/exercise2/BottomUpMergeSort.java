package exercise2;

import examples.LinkedQueue;

import java.util.Comparator;

/**
 * Bottom up merge sort with LinkedQueue.
 */
public class BottomUpMergeSort {

    // natural-order wrapper. it routes to the comparator version
    public static <E extends Comparable<E>> void sort(LinkedQueue<E> S) {
        sort(S, (a, b) -> a.compareTo(b));
    }

    public static <E> void sort(LinkedQueue<E> S, Comparator<E> cmp) {
        if (S.size() <= 1) return; // if sorted already or empty

        // break S into single item queue
        LinkedQueue<LinkedQueue<E>> buckets = new LinkedQueue<>();
        while (!S.isEmpty()) {
            LinkedQueue<E> single = new LinkedQueue<>();
            single.enqueue(S.dequeue());
            buckets.enqueue(single);
        }

        // merge pairs until one bucket left
        while (buckets.size() > 1) {
            LinkedQueue<E> leftQ  = buckets.dequeue();
            LinkedQueue<E> rightQ = buckets.isEmpty() ? new LinkedQueue<>() : buckets.dequeue(); // odd-count case
            LinkedQueue<E> merged = merge(leftQ, rightQ, cmp);
            buckets.enqueue(merged);
        }

        // move sorted result back into S
        LinkedQueue<E> sorted = buckets.dequeue();
        while (!sorted.isEmpty()) {
            S.enqueue(sorted.dequeue());
        }
    }

    // merge two sorted queues into a new sorted queue
    private static <E> LinkedQueue<E> merge(LinkedQueue<E> left,
                                            LinkedQueue<E> right,
                                            Comparator<E> cmp) {
        LinkedQueue<E> out = new LinkedQueue<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            E lf = left.first();
            E rf = right.first();
            if (cmp.compare(lf, rf) <= 0) {
                out.enqueue(left.dequeue());
            } else {
                out.enqueue(right.dequeue());
            }
        }

        // clean out remainder
        while (!left.isEmpty())  out.enqueue(left.dequeue());
        while (!right.isEmpty()) out.enqueue(right.dequeue());

        return out;
    }
}
