import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewStudentService {

    public static void viewStudents() {

        String sql = "SELECT student_id, first_name, last_name, email, phone, " +
                     "date_of_birth, gender, course_id, enrollment_date " +
                     "FROM students";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            System.out.println("\n==========================================================================");
            System.out.println("                         ALL STUDENTS");
            System.out.println("==========================================================================");

            System.out.printf(
                    "%-5s %-15s %-15s %-25s %-15s %-10s%n",
                    "ID", "First Name", "Last Name", "Email", "Phone", "Course"
            );

            System.out.println("--------------------------------------------------------------------------");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.printf(
                        "%-5d %-15s %-15s %-25s %-15s %-10d%n",
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("course_id")
                );
            }

            if (!found) {
                System.out.println("No students found.");
            }

            System.out.println("==========================================================================");

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("❌ Failed to retrieve students.");
            e.printStackTrace();
        }
    }
}