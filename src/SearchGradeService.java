import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchGradeService {

    public static void searchGrade(int gradeId) {

        String sql = "SELECT grade_id, student_id, subject, marks, semester, grade " +
                     "FROM grades WHERE grade_id = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, gradeId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                System.out.println("\n=================================");
                System.out.println("          GRADE DETAILS");
                System.out.println("=================================");

                System.out.println("Grade ID       : " + rs.getInt("grade_id"));
                System.out.println("Student ID     : " + rs.getInt("student_id"));
                System.out.println("Subject        : " + rs.getString("subject"));
                System.out.println("Marks          : " + rs.getDouble("marks"));
                System.out.println("Semester       : " + rs.getString("semester"));
                System.out.println("Grade          : " + rs.getString("grade"));

                System.out.println("=================================");

            } else {

                System.out.println("\n❌ Grade not found.");
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to search grade.");
            e.printStackTrace();
        }
    }
}