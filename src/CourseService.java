import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseService {

    public static void addCourse(Course course) {

        String sql = "INSERT INTO courses (course_name, duration, fees) VALUES (?, ?, ?)";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, course.getCourseName());
            pst.setString(2, course.getDuration());
            pst.setDouble(3, course.getFees());

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("\n✅ Course added successfully!");
            }

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to add course.");
            e.printStackTrace();
        }
    }

    public static void viewCourses() {

        String sql = "SELECT course_id, course_name, duration, fees FROM courses";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            System.out.println("\n==============================================================");
            System.out.println("                      ALL COURSES");
            System.out.println("==============================================================");

            System.out.printf(
                    "%-10s %-30s %-15s %-15s%n",
                    "ID", "Course Name", "Duration", "Fees"
            );

            System.out.println("--------------------------------------------------------------");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.printf(
                        "%-10d %-30s %-15s %-15.2f%n",
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getString("duration"),
                        rs.getDouble("fees")
                );
            }

            if (!found) {
                System.out.println("No courses found.");
            }

            System.out.println("==============================================================");

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to retrieve courses.");
            e.printStackTrace();
        }
    }
}