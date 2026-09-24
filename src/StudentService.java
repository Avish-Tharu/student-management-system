import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentService {

    public static void addStudent(Student student) {

        String checkEmailSql =
                "SELECT student_id FROM students WHERE email = ?";

        String checkCourseSql =
                "SELECT course_id FROM courses WHERE course_id = ?";

        String insertSql = "INSERT INTO students " +
                           "(first_name, last_name, email, phone, date_of_birth, " +
                           "gender, course_id, enrollment_date) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection()) {

            // Check whether email already exists
            try (PreparedStatement checkEmailPst =
                         conn.prepareStatement(checkEmailSql)) {

                checkEmailPst.setString(1, student.getEmail());

                try (ResultSet rs = checkEmailPst.executeQuery()) {

                    if (rs.next()) {

                        System.out.println(
                                "\n❌ A student with this email already exists."
                        );

                        return;
                    }
                }
            }

            // Check whether course exists
            try (PreparedStatement checkCoursePst =
                         conn.prepareStatement(checkCourseSql)) {

                checkCoursePst.setInt(1, student.getCourseId());

                try (ResultSet rs = checkCoursePst.executeQuery()) {

                    if (!rs.next()) {

                        System.out.println(
                                "\n❌ Course not found. Please enter a valid Course ID."
                        );

                        return;
                    }
                }
            }

            // Insert new student
            try (PreparedStatement pst =
                         conn.prepareStatement(insertSql)) {

                pst.setString(1, student.getFirstName());
                pst.setString(2, student.getLastName());
                pst.setString(3, student.getEmail());
                pst.setString(4, student.getPhone());
                pst.setString(5, student.getDateOfBirth());
                pst.setString(6, student.getGender());
                pst.setInt(7, student.getCourseId());
                pst.setString(8, student.getEnrollmentDate());

                int rows = pst.executeUpdate();

                if (rows > 0) {

                    System.out.println(
                            "\n✅ Student added successfully!"
                    );

                } else {

                    System.out.println(
                            "\n❌ Failed to add student."
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "\n❌ Failed to add student."
            );
        }
    }
}