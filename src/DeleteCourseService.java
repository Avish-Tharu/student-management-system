import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteCourseService {

    public static void deleteCourse(int courseId) {

        String sql = "DELETE FROM courses WHERE course_id = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, courseId);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println("\n✅ Course deleted successfully!");

            } else {

                System.out.println("\n❌ Course not found.");
            }

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to delete course.");
            e.printStackTrace();
        }
    }
}