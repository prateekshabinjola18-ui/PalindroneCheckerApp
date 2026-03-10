import java.util.Scanner;
import java.util.Stack;

/**
 * ============================================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================================
 * * Use Case 5: Stack-Based Palindrome Checker
 * * Description:
 * This class validates a palindrome by utilizing a Stack data structure.
 * It pushes all characters onto the stack and then pops them to compare
 * against the original string, effectively using the LIFO property to
 * reverse the string.
 * * At this stage, the application:
 * - Pushes characters into stack
 * - Pops and compares
 * - Prints the result
 * * @author Developer
 * @version 5.0
 */
public class PalindromeChecker {

    /**
     * Application entry point for UC5.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Stack-Based Palindrome Checker App ---");
        System.out.print("Enter a string to validate: ");
        String input = scanner.nextLine();

        // Pre-processing: Removing spaces and converting to lowercase
        // to handle standard sentences properly (e.g., "Step on no pets")
        String cleanString = input.replaceAll("\\s+", "").toLowerCase();

        // Initialize the Stack
        Stack<Character> stack = new Stack<>();

        // Step 1: Push characters into stack
        for (int i = 0; i < cleanString.length(); i++) {
            stack.push(cleanString.charAt(i));
        }

        boolean isPalindrome = true;

        // Step 2: Pop and compare
        // The stack will pop the characters in reverse order (LIFO)
        for (int i = 0; i < cleanString.length(); i++) {
            char poppedChar = stack.pop();

            // Compare the original string's character (left-to-right)
            // with the popped character (right-to-left)
            if (cleanString.charAt(i) != poppedChar) {
                isPalindrome = false; // Mismatch found
                break;                // No need to check further
            }
        }

        // Step 3: Print result
        System.out.println("\nResult:");
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a valid Palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}