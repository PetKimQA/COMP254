package exercise2;

public class TestTransfer {
    public static void main(String[] args) {
        Stack<Integer> S = new LinkedStack<>();
        Stack<Integer> T = new LinkedStack<>();

        // Load S: bottom→top = [1, 2, 3]
        S.push(1);
        S.push(2);
        S.push(3);

        // Transfer S→T
        StackUtils.transfer(S, T);

        // Now T (bottom→top) = [3, 2, 1].
        // Popping T should print 1 2 3
        while (!T.isEmpty()) {
            System.out.print(T.pop() + " ");
        }
        // Expected output: 1 2 3
    }
}
