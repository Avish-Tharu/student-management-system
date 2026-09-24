import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchStudentService {

    // Search student by Student ID
    public static void searchStudent(int studentId) {

        String sql = "SELECT * FROM students WHERE student_id = ?";

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)
        ) {

            pst.setInt(1, studentId);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {

                    System.out.println("\n========================================");
                    System.out.println("          STUDENT DETAILS");
                    System.out.println("========================================");

                    System.out.println("Student ID       : " + rs.getInt("student_id"));
                    System.out.println("First Name       : " + rs.getString("first_name"));
                    System.out.println("Last Name        : " + rs.getString("last_name"));
                    System.out.println("Email            : " + rs.getString("email"));
                    System.out.println("Phone            : " + rs.getString("phone"));
                    System.out.println("Date of Birth    : " + rs.getDate("date_of_birth"));
                    System.out.println("Gender           : " + rs.getString("gender"));
                    System.out.println("Course ID        : " + rs.getInt("course_id"));
                    System.out.println("Enrollment Date  : " + rs.getDate("enrollment_date"));

                    System.out.println("========================================");

                } else {

                    System.out.println("\n❌ Student not found.");
                }
            }

        } catch (Exception e) {

            System.out.println("\n❌ Failed to search student.");
        }
    }

    // Search student by name
    public static void searchStudentByName(String name) {

        String sql = "SELECT student_id, first_name, last_name, email, phone, " +
                     "course_id FROM students " +
                     "WHERE first_name LIKE ? OR last_name LIKE ?";

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)
        ) {

            String searchName = "%" + name + "%";

            pst.setString(1, searchName);
            pst.setString(2, searchName);

            try (ResultSet rs = pst.executeQuery()) {

                System.out.println("\n==============================================================");
                System.out.println("                    SEARCH RESULTS");
                System.out.println("==============================================================");

                System.out.printf(
                        "%-8s %-18s %-18s %-25s %-15s %-10s%n",
                        "ID",
                        "First Name",
                        "Last Name",
                        "Email",
                        "Phone",
                        "Course ID"
                );

                System.out.println("--------------------------------------------------------------");

                boolean found = false;

                while (rs.next()) {

                    found = true;

                    System.out.printf(
                            "%-8d %-18s %-18s %-25s %-15s %-10d%n",
                            rs.getInt("student_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getInt("course_id")
                    );
                }

                if (!found) {

                    System.out.println(
                            "❌ No students found with that name."
                    );
                }

                System.out.println("==============================================================");
            }

        } catch (Exception e) {

            System.out.println("\n❌ Failed to search students by name.");
        }
    }
    // Search student by email
public static void searchStudentByEmail(String email) {

    String sql = "SELECT student_id, first_name, last_name, email, " +
                 "phone, course_id FROM students WHERE email = ?";

    try (
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql)
    ) {

        pst.setString(1, email);

        try (ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {

                System.out.println("\n========================================");
                System.out.println("          STUDENT DETAILS");
                System.out.println("========================================");

                System.out.println("Student ID : " + rs.getInt("student_id"));
                System.out.println("First Name : " + rs.getString("first_name"));
                System.out.println("Last Name  : " + rs.getString("last_name"));
                System.out.println("Email      : " + rs.getString("email"));
                System.out.println("Phone      : " + rs.getString("phone"));
                System.out.println("Course ID  : " + rs.getInt("course_id"));

                System.out.println("========================================");

            } else {

                System.out.println(
                        "\n❌ No student found with that email."
                );
            }
        }

    } catch (Exception e) {

        System.out.println(
                "\n❌ Failed to search student by email."
        );
    }
}
// Search students by Course ID
public static void searchStudentByCourse(int courseId) {

    String sql = "SELECT student_id, first_name, last_name, email, " +
                 "phone, course_id FROM students WHERE course_id = ?";

    try (
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql)
    ) {

        pst.setInt(1, courseId);

        try (ResultSet rs = pst.executeQuery()) {

            System.out.println("\n==============================================================");
            System.out.println("                 STUDENTS IN COURSE");
            System.out.println("==============================================================");

            System.out.printf(
                    "%-8s %-18s %-18s %-25s %-15s%n",
                    "ID",
                    "First Name",
                    "Last Name",
                    "Email",
                    "Phone"
            );

            System.out.println("--------------------------------------------------------------");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.printf(
                        "%-8d %-18s %-18s %-25s %-15s%n",
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
            }

            if (!found) {

                System.out.println(
                        "❌ No students found for this Course ID."
                );
            }

            System.out.println("==============================================================");
        }

    } catch (Exception e) {

        System.out.println(
                "\n❌ Failed to search students by course."
        );
    }
}
}