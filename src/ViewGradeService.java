import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewGradeService {

    public static void viewGrades() {

        String sql = "SELECT grade_id, student_id, subject, marks, semester, grade " +
                     "FROM grades ORDER BY grade_id";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            System.out.println("\n==============================================================");
            System.out.println("                         ALL GRADES");
            System.out.println("==============================================================");

            System.out.printf(
                    "%-8s %-12s %-25s %-10s %-15s %-6s%n",
                    "ID",
                    "Student ID",
                    "Subject",
                    "Marks",
                    "Semester",
                    "Grade"
            );

            System.out.println("--------------------------------------------------------------");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.printf(
                        "%-8d %-12d %-25s %-10.2f %-15s %-6s%n",
                        rs.getInt("grade_id"),
                        rs.getInt("student_id"),
                        rs.getString("subject"),
                        rs.getDouble("marks"),
                        rs.getString("semester"),
                        rs.getString("grade")
                );
            }

            if (!found) {
                System.out.println("No grades found.");
            }

            System.out.println("==============================================================");

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to retrieve grades.");
            e.printStackTrace();
        }
    }
}