import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * ============================================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================================
 * * Use Case 7: Deque-Based Optimized Palindrome Checker
 * * Description:
 * This class validates a palindrome using a Deque (Double Ended Queue).
 * It demonstrates optimized data handling by comparing elements from both
 * the front and rear simultaneously, eliminating the need for multiple
 * or separate reversal data structures.
 * * Flow:
 * - Insert characters into deque
 * - Remove first & last
 * - Compare until empty
 * * @author Developer
 * @version 7.0
 */
public class PalindromeChecker {

    /**
     * Application entry point for UC7.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Deque-Based Palindrome Checker App ---");
        System.out.print("Enter a string to validate: ");
        String input = scanner.nextLine();

        // Pre-processing: Removing spaces and converting to lowercase
        // to handle sentences properly (e.g., "Madam In Eden Im Adam")
        String cleanString = input.replaceAll("\\s+", "").toLowerCase();

        // Initialize the Deque
        // ArrayDeque is generally faster than LinkedList for Deque operations
        Deque<Character> deque = new ArrayDeque<>();

        // Step 1: Insert characters into deque
        for (int i = 0; i < cleanString.length(); i++) {
            deque.addLast(cleanString.charAt(i));
        }

        boolean isPalindrome = true;

        // Step 2 & 3: Remove first & last and compare until empty (or 1 element left)
        // A palindrome with an odd length will leave exactly 1 element in the middle
        while (deque.size() > 1) {
            char frontChar = deque.removeFirst(); // Front Access
            char rearChar = deque.removeLast();   // Rear Access

            if (frontChar != rearChar) {
                isPalindrome = false; // Mismatch found
                break;                // Optimized Data Handling: Exit early
            }
        }

        // Display result
        System.out.println("\nResult:");
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a valid Palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}