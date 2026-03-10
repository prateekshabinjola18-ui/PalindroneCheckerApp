import java.util.Scanner;

/**
 * ============================================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================================
 * * Use Case 10: Case-Insensitive & Space-Ignored Palindrome
 * * Description:
 * This class validates a palindrome by explicitly focusing on string
 * normalization. It uses regular expressions to ignore spaces and
 * standardizes character casing before applying the underlying
 * array-based palindrome checking logic.
 * * Flow:
 * 1. Normalize string
 * 2. Apply previous logic
 * * @author Developer
 * @version 10.0
 */
public class PalindromeChecker {

    /**
     * Application entry point for UC10.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Advanced Palindrome Checker App ---");
        System.out.print("Enter a string to validate: ");
        String input = scanner.nextLine();

        // Step 1: Normalize string
        // Using Regular Expressions: "\\s+" matches one or more whitespace characters
        // .toLowerCase() ensures case-insensitivity (e.g., 'A' == 'a')
        String normalizedString = input.replaceAll("\\s+", "").toLowerCase();

        // Handle edge case for an empty string or a string that was only spaces
        if (normalizedString.isEmpty()) {
            System.out.println("\nResult:\n\"" + input + "\" is considered a valid Palindrome (Empty/Only Spaces).");
            scanner.close();
            return;
        }

        // Step 2: Apply previous logic (Data Structure: String / Array using Two-Pointers)
        char[] charArray = normalizedString.toCharArray();
        boolean isPalindrome = true;

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
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