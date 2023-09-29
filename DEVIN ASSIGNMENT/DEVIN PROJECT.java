import java.util.Scanner;

public class LoginProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String correctUsername = "yourUsername"; // Change this to your desired username
        String correctPassword = "yourPassword"; // Change this to your desired password
        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = hidePasswordInput(scanner);

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Login failed. Please try again.");
                attempts++;
                System.out.println("You have " + (maxAttempts - attempts) + " attempts remaining.\n");
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Maximum login attempts reached. Account locked.");
        }

        scanner.close();
    }

    // Function to hide password input with asterisks
    private static String hidePasswordInput(Scanner scanner) {
        char[] passwordChars = scanner.nextLine().toCharArray();
        StringBuilder hiddenPassword = new StringBuilder();

        for (char c : passwordChars) {
            hiddenPassword.append("*");
        }

        return hiddenPassword.toString();
    }
}
