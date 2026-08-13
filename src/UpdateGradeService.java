import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateGradeService {

    public static void updateGrade(
            int gradeId,
            double marks,
            String semester,
            String grade) {

        String sql = "UPDATE grades " +
                     "SET marks = ?, semester = ?, grade = ? " +
                     "WHERE grade_id = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setDouble(1, marks);
            pst.setString(2, semester);
            pst.setString(3, grade);
            pst.setInt(4, gradeId);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println("\n✅ Grade updated successfully!");

            } else {

                System.out.println("\n❌ Grade not found.");
            }

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to update grade.");
            e.printStackTrace();
        }
    }
}