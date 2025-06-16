package Exercise2;

import java.util.Scanner;

public class PalindromeChecker {
    // Returns true if s is a palindrome
    public static boolean isPalindrome(String s) {
        // Normalize or remove non-letters if desired
        int len = s.length();
        if (len <= 1) {
            return true;  // empty or single-char strings are palindromes
        }
        // Compare first and last characters
        if (s.charAt(0) != s.charAt(len - 1)) {
            return false;
        }
        // Recur on the substring without first and last char
        return isPalindrome(s.substring(1, len - 1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string to check: ");
        String input = in.nextLine();
        boolean result = isPalindrome(input);
        if (result) {
            System.out.printf("'%s' IS a palindrome.%n", input);
        } else {
            System.out.printf("'%s' is NOT a palindrome.%n", input);
        }
        in.close();
    }
}
