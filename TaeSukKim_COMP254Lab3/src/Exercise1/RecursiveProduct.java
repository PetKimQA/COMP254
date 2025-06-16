package Exercise1;

import java.util.Scanner;

public class RecursiveProduct {
    // Computes m × n using only addition and subtraction
    public static int product(int m, int n) {
        // Base cases
        if (m == 0 || n == 0) {
            return 0;
        }
        // Recurse on the smaller of the two to minimize depth
        if (n < 0) {
            // Handle negative n by flipping sign
            return -product(m, -n);
        }
        // Recursive step: add m one time, decrement n by 1
        return m + product(m, n - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter positive integer m: ");
        int m = in.nextInt();
        System.out.print("Enter positive integer n: ");
        int n = in.nextInt();
        int result = product(m, n);
        System.out.printf("Product of %d and %d is %d.%n", m, n, result);
        in.close();
    }
}
