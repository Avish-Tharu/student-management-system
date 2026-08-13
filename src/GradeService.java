import java.sql.Connection;
import java.sql.PreparedStatement;

public class GradeService {

    public static void addGrade(Grade grade) {

        String sql = "INSERT INTO grades " +
                "(student_id, subject, marks, semester, grade) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, grade.getStudentId());
            pst.setString(2, grade.getSubject());
            pst.setDouble(3, grade.getMarks());
            pst.setString(4, grade.getSemester());
            pst.setString(5, grade.getGrade());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println("\n✅ Grade added successfully!");

            } else {

                System.out.println("\n❌ Failed to add grade.");
            }

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to add grade.");
            e.printStackTrace();
        }
    }
}