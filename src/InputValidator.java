import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InputValidator {

    // Check if text is empty
    public static boolean isNotEmpty(String value) {

        return value != null && !value.trim().isEmpty();
    }
// Validate person name
public static boolean isValidName(String name) {

    return name != null &&
           name.matches("[A-Za-z]+([ '-][A-Za-z]+)*");
}
// Validate gender
public static boolean isValidGender(String gender) {

    if (gender == null) {
        return false;
    }

    return gender.equalsIgnoreCase("Male") ||
           gender.equalsIgnoreCase("Female") ||
           gender.equalsIgnoreCase("Other");
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

    // Validate grade
    public static boolean isValidGrade(String grade) {

        if (grade == null) {
            return false;
        }

        return grade.equals("A+") ||
               grade.equals("A") ||
               grade.equals("A-") ||
               grade.equals("B+") ||
               grade.equals("B") ||
               grade.equals("B-") ||
               grade.equals("C+") ||
               grade.equals("C") ||
               grade.equals("C-") ||
               grade.equals("D") ||
               grade.equals("F");
    }
    // Validate semester
public static boolean isValidSemester(String semester) {

    if (semester == null) {
        return false;
    }

    return semester.matches(
            "Semester [1-8]"
    );
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