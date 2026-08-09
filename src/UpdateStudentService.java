import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateStudentService {

    public static void updateStudent(
            int studentId,
            String email,
            String phone,
            int courseId) {

        String sql = "UPDATE students SET email = ?, phone = ?, course_id = ? " +
                     "WHERE student_id = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, email);
            pst.setString(2, phone);
            pst.setInt(3, courseId);
            pst.setInt(4, studentId);

            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {

                System.out.println("\n✅ Student updated successfully!");

            } else {

                System.out.println("\n❌ Student not found.");

            }

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to update student.");
            e.printStackTrace();
        }
    }
}