
import java.util.Scanner;
public class PalindromeChecker {
    public static void main (String args[]){
                // Create Scanner object to take user input
                Scanner scanner = new Scanner(System.in);

                // Prompt user for input
                System.out.print("Enter a string to check if it is a palindrome: ");
                String input = scanner.nextLine();

                // Convert string to lowercase (optional, for case-insensitive check)
                String original = input.toLowerCase();
                String reversed = "";

                // Reverse the string
                for (int i = original.length() - 1; i >= 0; i--) {
                    reversed += original.charAt(i);
                }

                // Check if palindrome using if-else
                if (original.equals(reversed)) {
                    System.out.println("The entered string \"" + input + "\" is a Palindrome.");
                } else {
                    System.out.println("The entered string \"" + input + "\" is NOT a Palindrome.");
                }

                // Close scanner
                scanner.close();
            }
        }
