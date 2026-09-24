import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GradeService {

    public static void addGrade(Grade grade) {

        // Validate marks
        if (!InputValidator.isValidMarks(grade.getMarks())) {

            System.out.println(
                    "\n❌ Invalid marks. Marks must be between 0 and 100."
            );

            return;
        }

        String checkStudentSql =
                "SELECT student_id FROM students WHERE student_id = ?";

        String insertSql = "INSERT INTO grades " +
                "(student_id, subject, marks, semester, grade) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement checkPst =
                     conn.prepareStatement(checkStudentSql)) {

            // Check whether student exists
            checkPst.setInt(1, grade.getStudentId());

            try (ResultSet rs = checkPst.executeQuery()) {

                if (!rs.next()) {

                    System.out.println(
                            "\n❌ Student not found. Please enter a valid Student ID."
                    );

                    return;
                }
            }

            // Insert grade
            try (PreparedStatement pst =
                         conn.prepareStatement(insertSql)) {

                pst.setInt(1, grade.getStudentId());
                pst.setString(2, grade.getSubject());
                pst.setDouble(3, grade.getMarks());
                pst.setString(4, grade.getSemester());
                pst.setString(5, grade.getGrade());

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {

                    System.out.println(
                            "\n✅ Grade added successfully!"
                    );

                } else {

                    System.out.println(
                            "\n❌ Failed to add grade."
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "\n❌ Failed to add grade."
            );
        }
    }
}