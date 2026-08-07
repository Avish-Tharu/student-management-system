import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentService {

    public static void addStudent(Student student) {

        String sql = "INSERT INTO students (first_name, last_name, email, phone, date_of_birth, gender, course_id, enrollment_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, student.getFirstName());
            pst.setString(2, student.getLastName());
            pst.setString(3, student.getEmail());
            pst.setString(4, student.getPhone());
            pst.setString(5, student.getDateOfBirth());
            pst.setString(6, student.getGender());
            pst.setInt(7, student.getCourseId());
            pst.setString(8, student.getEnrollmentDate());

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("\n✅ Student added successfully!");
            } else {
                System.out.println("\n❌ Failed to add student.");
            }

            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}