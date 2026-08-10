import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchCourseService {

    public static void searchCourse(int courseId) {

        String sql = "SELECT * FROM courses WHERE course_id = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, courseId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                System.out.println("\n=================================");
                System.out.println("        COURSE DETAILS");
                System.out.println("=================================");

                System.out.println("Course ID   : " + rs.getInt("course_id"));
                System.out.println("Course Name : " + rs.getString("course_name"));
                System.out.println("Duration    : " + rs.getString("duration"));
                System.out.println("Fees        : " + rs.getDouble("fees"));

                System.out.println("=================================");

            } else {

                System.out.println("\n❌ Course not found.");
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to search course.");
            e.printStackTrace();
        }
    }
}