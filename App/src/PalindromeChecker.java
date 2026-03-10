import java.util.Scanner;

/**
 * ============================================================================
 * MAIN CLASS - PalindromeChecker
 * ============================================================================
 * * Use Case 11: Object-Oriented Palindrome Service
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate the service class (Creating an object of this very class)
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("--- Object-Oriented Palindrome Checker App ---");
        System.out.print("Enter a string to validate: ");
        String input = scanner.nextLine();

        // Call the method and store the result
        // This will now work perfectly because the method is defined below!
        boolean isPalindrome = checker.checkPalindrome(input);

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
     * Validates if a given string is a palindrome.
     * @param str The string to validate
     * @return true if it is a palindrome, false otherwise
     */
    public boolean checkPalindrome(String str) {
        // Handle null values
        if (str == null) {
            return false;
        }

        // Normalize the string (ignore spaces and case)
        String normalizedString = str.replaceAll("\\s+", "").toLowerCase();

        // Handle empty strings
        if (normalizedString.isEmpty()) {
            return true;
        }

        // Two-pointer logic
        char[] charArray = normalizedString.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false; // Mismatch found, return immediately
            }
            left++;
            right--;
        }

        return true; // Valid palindrome
    }
}