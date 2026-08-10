import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateCourseService {

    public static void updateCourse(
            int courseId,
            String courseName,
            String duration,
            double fees) {

        String sql = "UPDATE courses SET course_name = ?, duration = ?, fees = ? WHERE course_id = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, courseName);
            pst.setString(2, duration);
            pst.setDouble(3, fees);
            pst.setInt(4, courseId);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println("\n✅ Course updated successfully!");

            } else {

                System.out.println("\n❌ Course not found.");
            }

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to update course.");
            e.printStackTrace();
        }
    }
}