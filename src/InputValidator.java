import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InputValidator {

    // Check if text is empty
    public static boolean isNotEmpty(String value) {

        return value != null && !value.trim().isEmpty();
    }

    // Validate email
    public static boolean isValidEmail(String email) {

        return email != null &&
               email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    // Validate phone number
    public static boolean isValidPhone(String phone) {

        return phone != null &&
               phone.matches("0[0-9]{9}");
    }

    // Validate marks
    public static boolean isValidMarks(double marks) {

        return marks >= 0 && marks <= 100;
    }

    // Validate fees
    public static boolean isValidFees(double fees) {

        return fees >= 0;
    }

    // Validate date
    public static boolean isValidDate(String date) {

        try {

            LocalDate.parse(date);

            return true;

        } catch (DateTimeParseException e) {

            return false;
        }
    }
}