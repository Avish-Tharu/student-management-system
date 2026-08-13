import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteGradeService {

    public static void deleteGrade(int gradeId) {

        String sql = "DELETE FROM grades WHERE grade_id = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, gradeId);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println("\n✅ Grade deleted successfully!");

            } else {

                System.out.println("\n❌ Grade not found.");
            }

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to delete grade.");
            e.printStackTrace();
        }
    }
}