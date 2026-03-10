import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * ============================================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================================
 * * Use Case 6: Queue + Stack Based Palindrome Check
 * * Description:
 * This class validates a palindrome by demonstrating the behavioral
 * difference between a Queue (FIFO) and a Stack (LIFO).
 * It adds characters to both structures, then compares the output
 * of dequeuing (front-to-back) against popping (back-to-front).
 * * Flow:
 * - Enqueue characters to Queue
 * - Push characters to Stack
 * - Compare dequeue vs pop
 * * @author Developer
 * @version 6.0
 */
public class PalindromeChecker {

    /**
     * Application entry point for UC6.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Queue + Stack Palindrome Checker App ---");
        System.out.print("Enter a string to validate: ");
        String input = scanner.nextLine();

        // Pre-processing: Removing spaces and converting to lowercase
        String cleanString = input.replaceAll("\\s+", "").toLowerCase();

        // Initialize the Data Structures
        // Note: Queue is an interface in Java, so we instantiate it using a LinkedList
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Step 1 & 2: Enqueue characters to Queue and Push characters to Stack
        for (int i = 0; i < cleanString.length(); i++) {
            char c = cleanString.charAt(i);
            queue.add(c);  // Enqueue operation
            stack.push(c); // Push operation
        }

        boolean isPalindrome = true;

        // Step 3: Compare dequeue vs pop
        while (!queue.isEmpty() && !stack.isEmpty()) {
            char queueChar = queue.remove(); // Dequeue: gets character in original order (FIFO)
            char stackChar = stack.pop();    // Pop: gets character in reverse order (LIFO)

            // Logical Comparison
            if (queueChar != stackChar) {
                isPalindrome = false; // Mismatch found
                break;                // Exit early to save time
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