package exercise2;

/**
 * Utility methods for Stack operations.
 */
public class StackUtils {

    /**
     * Moves every element from S onto T, so that
     * the original top of S becomes the bottom
     * of the transferred block in T.
     */
    public static <E> void transfer(Stack<E> S, Stack<E> T) {
        while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }
}
