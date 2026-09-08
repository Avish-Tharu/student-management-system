import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchStudentService {

    public static void searchStudent(int studentId) {

        String sql = "SELECT * FROM students WHERE student_id = ?";

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)
        ) {

            pst.setInt(1, studentId);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {

                    System.out.println("\n========================================");
                    System.out.println("          STUDENT DETAILS");
                    System.out.println("========================================");

                    System.out.println("Student ID       : " + rs.getInt("student_id"));
                    System.out.println("First Name       : " + rs.getString("first_name"));
                    System.out.println("Last Name        : " + rs.getString("last_name"));
                    System.out.println("Email            : " + rs.getString("email"));
                    System.out.println("Phone            : " + rs.getString("phone"));
                    System.out.println("Date of Birth    : " + rs.getDate("date_of_birth"));
                    System.out.println("Gender           : " + rs.getString("gender"));
                    System.out.println("Course ID        : " + rs.getInt("course_id"));
                    System.out.println("Enrollment Date  : " + rs.getDate("enrollment_date"));

                    System.out.println("========================================");

                } else {

                    System.out.println("\n❌ Student not found.");
                }
            }

        } catch (Exception e) {

            System.out.println("\n❌ Failed to search student.");
        }
    }
}