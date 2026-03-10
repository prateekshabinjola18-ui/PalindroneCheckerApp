import java.util.Scanner;

/**
 * ============================================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================================
 * * Use Case 9: Recursive Palindrome Checker
 * * Description:
 * This class validates a palindrome using recursion.
 * It utilizes the system's Call Stack to manage method calls, checking
 * the start and end characters and recursing inward until a base
 * condition is met.
 * * Flow:
 * 1. Recursive call compares start & end
 * 2. Base condition exits recursion
 * * @author Developer
 * @version 9.0
 */
public class PalindromeChecker {

    /**
     * Application entry point for UC9.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Recursive Palindrome Checker App ---");
        System.out.print("Enter a string to validate: ");
        String input = scanner.nextLine();

        // Pre-processing: Removing spaces and converting to lowercase
        String cleanString = input.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome;

        // Handle edge case for an empty or entirely whitespace string
        if (cleanString.isEmpty()) {
            isPalindrome = true;
        } else {
            // Kick off the recursion starting at the first and last indices
            isPalindrome = checkPalindromeRecursive(cleanString, 0, cleanString.length() - 1);
        }

        // Display the result
        System.out.println("\nResult:");
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a valid Palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }

    /**
     * Recursive helper method to determine if a string is a palindrome.
     *
     * @param str   The pre-processed string
     * @param start The starting pointer index
     * @param end   The ending pointer index
     * @return true if the substring is a palindrome, false otherwise
     */
    private static boolean checkPalindromeRecursive(String str, int start, int end) {
        // Base Condition: Prevents infinite recursion.
        // If the pointers cross or meet, we've successfully checked all pairs.
        if (start >= end) {
            return true;
        }

        // If the outer characters don't match, fail immediately.
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Call: Shrink the problem by moving both pointers inward.
        return checkPalindromeRecursive(str, start + 1, end - 1);
    }
}