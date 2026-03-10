import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * ============================================================================
 * MAIN CLASS - PalindromeChecker
 * ============================================================================
 * * Use Case 12: Strategy Pattern for Palindrome Algorithms
 */
public class PalindromeChecker {

    // The context holds a reference to the strategy interface
    private PalindromeStrategy strategy;

    /**
     * FIXED: Removed 'public' to match the PalindromeStrategy interface's visibility scope.
     * Injects the strategy at runtime.
     * @param strategy The specific palindrome algorithm to use
     */
    void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * FIXED: Removed 'public' for consistency.
     * Executes the currently injected strategy.
     * @param str The string to validate
     * @return true if palindrome, false otherwise
     */
    boolean check(String str) {
        if (strategy == null) {
            throw new IllegalStateException("PalindromeStrategy is not set!");
        }
        return strategy.isPalindrome(str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeChecker appContext = new PalindromeChecker();

        System.out.println("--- Strategy Pattern Palindrome Checker App ---");
        System.out.print("Enter a string to validate: ");
        String input = scanner.nextLine();

        System.out.println("\n--- Results ---");

        // 1. Inject StackStrategy and run
        appContext.setStrategy(new StackStrategy());
        boolean isStackPalindrome = appContext.check(input);
        System.out.println("[Stack Strategy] Is Palindrome? " + isStackPalindrome);

        // 2. Inject DequeStrategy at runtime and run
        appContext.setStrategy(new DequeStrategy());
        boolean isDequePalindrome = appContext.check(input);
        System.out.println("[Deque Strategy] Is Palindrome? " + isDequePalindrome);

        scanner.close();
    }
}

/**
 * ============================================================================
 * INTERFACE - PalindromeStrategy
 * ============================================================================
 * Defines the contract that all concrete strategies must follow.
 */
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

/**
 * ============================================================================
 * CONCRETE STRATEGY 1 - StackStrategy
 * ============================================================================
 * Validates a palindrome using a Stack (LIFO principle).
 */
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : cleanStr.toCharArray()) {
            stack.push(c);
        }

        for (char c : cleanStr.toCharArray()) {
            if (stack.pop() != c) {
                return false;
            }
        }
        return true;
    }
}

/**
 * ============================================================================
 * CONCRETE STRATEGY 2 - DequeStrategy
 * ============================================================================
 * Validates a palindrome using a Deque (comparing front and rear simultaneously).
 */
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : cleanStr.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}