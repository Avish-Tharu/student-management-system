import java.util.Scanner;

public class InputHelper {

    public static int readInt(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println("❌ Please enter a valid whole number.");
            }
        }
    }

    public static double readDouble(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                return Double.parseDouble(input);

            } catch (NumberFormatException e) {

                System.out.println("❌ Please enter a valid number.");
            }
        }
    }
}