
import java.util.Scanner;
public class PalindromeChecker {

        public static void main(String[] args) {

            // Create Scanner object for user input
            Scanner scanner = new Scanner(System.in);

            // Prompt user to enter a string
            System.out.print("Enter a string to check if it is a palindrome: ");
            String input = scanner.nextLine();

            // Store original string
            String original = input;

            // Variable to store reversed string
            String reversed = "";

            // Reverse string using for loop
            for (int i = original.length() - 1; i >= 0; i--) {
                reversed = reversed + original.charAt(i);
            }

            // Compare original and reversed using equals()
            if (original.equals(reversed)) {
                System.out.println("The entered string \"" + input + "\" is a Palindrome.");
            } else {
                System.out.println("The entered string \"" + input + "\" is NOT a Palindrome.");
            }

            // Close scanner
            scanner.close();
        }
    }