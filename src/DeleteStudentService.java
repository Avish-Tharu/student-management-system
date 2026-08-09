import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudentService {

    public static void deleteStudent(int studentId) {

        String sql = "DELETE FROM students WHERE student_id = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, studentId);

            int rowsDeleted = pst.executeUpdate();

            if (rowsDeleted > 0) {

                System.out.println("\n✅ Student deleted successfully!");

            } else {

                System.out.println("\n❌ Student not found.");

            }

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to delete student.");
            e.printStackTrace();
        }
    }
}