import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseService {

    public static void addCourse(Course course) {

        String checkSql = "SELECT course_id FROM courses WHERE course_name = ?";

        String insertSql = "INSERT INTO courses " +
                           "(course_name, duration, fees) " +
                           "VALUES (?, ?, ?)";

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement checkPst = conn.prepareStatement(checkSql)
        ) {

            // Check whether course already exists
            checkPst.setString(1, course.getCourseName());

            try (ResultSet rs = checkPst.executeQuery()) {

                if (rs.next()) {

                    System.out.println(
                            "\n❌ A course with this name already exists."
                    );

                    return;
                }
            }

            // Insert new course
            try (PreparedStatement pst = conn.prepareStatement(insertSql)) {

                pst.setString(1, course.getCourseName());
                pst.setString(2, course.getDuration());
                pst.setDouble(3, course.getFees());

                int rowsInserted = pst.executeUpdate();

                if (rowsInserted > 0) {

                    System.out.println(
                            "\n✅ Course added successfully!"
                    );

                } else {

                    System.out.println(
                            "\n❌ Failed to add course."
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "\n❌ Failed to add course."
            );
        }
    }

    public static void viewCourses() {

        String sql = "SELECT course_id, course_name, duration, fees FROM courses";

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()
        ) {

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

        } catch (Exception e) {

            System.out.println("\n❌ Failed to retrieve courses.");
        }
    }
    public static void updateCourse(
        int courseId,
        String courseName,
        String duration,
        double fees) {

    String checkSql =
            "SELECT course_id FROM courses " +
            "WHERE course_name = ? AND course_id <> ?";

    String updateSql =
            "UPDATE courses " +
            "SET course_name = ?, duration = ?, fees = ? " +
            "WHERE course_id = ?";

    try (Connection conn = DatabaseConnection.getConnection()) {

        // Check whether another course already uses this name
        try (PreparedStatement checkPst =
                     conn.prepareStatement(checkSql)) {

            checkPst.setString(1, courseName);
            checkPst.setInt(2, courseId);

            try (ResultSet rs = checkPst.executeQuery()) {

                if (rs.next()) {

                    System.out.println(
                            "\n❌ Another course with this name already exists."
                    );

                    return;
                }
            }
        }

        // Update course
        try (PreparedStatement pst =
                     conn.prepareStatement(updateSql)) {

            pst.setString(1, courseName);
            pst.setString(2, duration);
            pst.setDouble(3, fees);
            pst.setInt(4, courseId);

            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {

                System.out.println(
                        "\n✅ Course updated successfully!"
                );

            } else {

                System.out.println(
                        "\n❌ Course not found."
                );
            }
        }

    } catch (Exception e) {

        System.out.println(
                "\n❌ Failed to update course."
        );
    }
}

}