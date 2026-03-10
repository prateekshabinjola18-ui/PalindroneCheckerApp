import java.util.Scanner;
import java.util.Stack;

/**
 * ============================================================================
 * MAIN CLASS - PalindromeChecker
 * ============================================================================
 * * Use Case 13: Performance Comparison
 * * Description:
 * This application compares the performance of different palindrome
 * algorithms (Two-Pointer, Stack, and StringBuilder) by capturing their
 * execution times using System.nanoTime().
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Algorithm Performance Comparison App ---");
        System.out.print("Enter a long string to validate (e.g., repeating a word 100 times): ");
        String input = scanner.nextLine();

        // Normalize string once so preprocessing time doesn't skew algorithm time
        String normalizedString = input.replaceAll("\\s+", "").toLowerCase();

        System.out.println("\nExecuting algorithms and capturing nano times...\n");

        // --- Approach 1: Highly Optimized Two-Pointer ---
        long startTime1 = System.nanoTime();
        boolean isPal1 = checkWithTwoPointers(normalizedString);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        // --- Approach 2: Stack-Based (Object Overhead) ---
        long startTime2 = System.nanoTime();
        boolean isPal2 = checkWithStack(normalizedString);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        // --- Approach 3: Built-in StringBuilder Reverse ---
        long startTime3 = System.nanoTime();
        boolean isPal3 = checkWithStringBuilder(normalizedString);
        long endTime3 = System.nanoTime();
        long duration3 = endTime3 - startTime3;

        // Displaying Results
        System.out.println("==================================================");
        System.out.println("               PERFORMANCE RESULTS                ");
        System.out.println("==================================================");
        System.out.printf("%-20s | %-10s | %-15s%n", "Algorithm", "Result", "Time (ns)");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s | %-10s | %d ns%n", "Two-Pointer (Array)", isPal1, duration1);
        System.out.printf("%-20s | %-10s | %d ns%n", "Stack (Objects)", isPal2, duration2);
        System.out.printf("%-20s | %-10s | %d ns%n", "StringBuilder API", isPal3, duration3);
        System.out.println("==================================================");

        scanner.close();
    }

    /**
     * Algorithm 1: Two-Pointer Technique
     * Highly efficient, O(1) space complexity.
     */
    static boolean checkWithTwoPointers(String str) {
        if (str == null || str.isEmpty()) return true;
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Algorithm 2: Stack Technique
     * Slower due to creating Character objects and Stack overhead.
     */
    static boolean checkWithStack(String str) {
        if (str == null || str.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        for (char c : str.toCharArray()) {
            if (stack.pop() != c) {
                return false;
            }
        }
        return true;
    }

    /**
     * Algorithm 3: StringBuilder Reverse
     * Very clean code. Now optimized using contentEquals!
     */
    static boolean checkWithStringBuilder(String str) {
        if (str == null) return false;
        // FIXED: Replaced .equals(...toString()) with .contentEquals()
        return str.contentEquals(new StringBuilder(str).reverse());
    }
}