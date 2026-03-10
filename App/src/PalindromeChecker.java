import java.util.Scanner;

/**
 * ============================================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================================
 * * Use Case 8: Linked List Based Palindrome Checker
 * * Description:
 * This class validates a palindrome using a Custom Singly Linked List.
 * It demonstrates advanced traversal techniques such as the Fast and Slow
 * Pointer approach to find the middle, and an in-place reversal of the
 * second half to allow sequential comparison without extra memory overhead.
 * * Flow:
 * 1. Convert string to linked list
 * 2. Reverse second half
 * 3. Compare halves
 * * @author Developer
 * @version 8.0
 */
public class PalindromeChecker {

    // Define the Singly Linked List Node structure
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Application entry point for UC8.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Linked List Palindrome Checker App ---");
        System.out.print("Enter a string to validate: ");
        String input = scanner.nextLine();

        // Pre-processing: Removing spaces and converting to lowercase
        String cleanString = input.replaceAll("\\s+", "").toLowerCase();

        if (cleanString.isEmpty()) {
            System.out.println("\nResult:\n\"" + input + "\" is considered a valid Palindrome (Empty).");
            scanner.close();
            return;
        }

        // Step 1: Convert string to linked list
        Node head = new Node(cleanString.charAt(0));
        Node current = head;
        for (int i = 1; i < cleanString.length(); i++) {
            current.next = new Node(cleanString.charAt(i));
            current = current.next; // Node Traversal
        }

        // --- Fast and Slow Pointer Technique ---
        // Used to find the middle of the linked list efficiently.
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Moves 1 step
            fast = fast.next.next;  // Moves 2 steps
        }
        // When 'fast' reaches the end, 'slow' is at the middle.

        // Step 2: Reverse the second half (In-Place Reversal)
        // Reverses the pointers in the second half of the list without creating new nodes.
        Node secondHalfHead = reverseList(slow);

        // Step 3: Compare halves
        Node firstHalfPtr = head;
        Node secondHalfPtr = secondHalfHead;
        boolean isPalindrome = true;

        while (secondHalfPtr != null) {
            if (firstHalfPtr.data != secondHalfPtr.data) {
                isPalindrome = false;
                break;
            }
            firstHalfPtr = firstHalfPtr.next;
            secondHalfPtr = secondHalfPtr.next;
        }

        // Optional but good practice: Restore the list back to its original state
        // reverseList(secondHalfHead);

        // Display result
        System.out.println("\nResult:");
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a valid Palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }

    /**
     * Helper method to reverse a singly linked list in-place.
     * * @param head The starting node of the list to reverse
     * @return The new head of the reversed list
     */
    private static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next; // Store next node
            curr.next = prev;          // Reverse the link
            prev = curr;               // Move prev forward
            curr = nextTemp;           // Move curr forward
        }
        return prev;
    }
}