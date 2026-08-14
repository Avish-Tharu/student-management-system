import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DashboardService {

    public static void showDashboard() {

        String studentSql = "SELECT COUNT(*) FROM students";
        String courseSql = "SELECT COUNT(*) FROM courses";
        String gradeSql = "SELECT COUNT(*) FROM grades";
        String averageSql = "SELECT AVG(marks) FROM grades";

        try {

            Connection conn = DatabaseConnection.getConnection();

            int totalStudents = 0;
            int totalCourses = 0;
            int totalGrades = 0;
            double averageMarks = 0.0;
            double highestMarks = 0.0;
double lowestMarks = 0.0;
String performanceSql =
        "SELECT MAX(marks), MIN(marks) FROM grades";

            // Total Students
            PreparedStatement studentPst =
                    conn.prepareStatement(studentSql);

            ResultSet studentRs = studentPst.executeQuery();

            if (studentRs.next()) {
                totalStudents = studentRs.getInt(1);
            }

            // Total Courses
            PreparedStatement coursePst =
                    conn.prepareStatement(courseSql);

            ResultSet courseRs = coursePst.executeQuery();

            if (courseRs.next()) {
                totalCourses = courseRs.getInt(1);
            }

            // Total Grades
            PreparedStatement gradePst =
                    conn.prepareStatement(gradeSql);

            ResultSet gradeRs = gradePst.executeQuery();

            if (gradeRs.next()) {
                totalGrades = gradeRs.getInt(1);
            }

            // Average Marks
            PreparedStatement averagePst =
                    conn.prepareStatement(averageSql);

            ResultSet averageRs = averagePst.executeQuery();

            if (averageRs.next()) {
                averageMarks = averageRs.getDouble(1);
            }
PreparedStatement performancePst =
        conn.prepareStatement(performanceSql);

ResultSet performanceRs = performancePst.executeQuery();

if (performanceRs.next()) {

    highestMarks = performanceRs.getDouble(1);
    lowestMarks = performanceRs.getDouble(2);
}
            System.out.println("\n=========================================");
            System.out.println("             ADMIN DASHBOARD");
            System.out.println("=========================================");

            System.out.println("Total Students       : " + totalStudents);
            System.out.println("Total Courses        : " + totalCourses);
            System.out.println("Total Grades         : " + totalGrades);
            System.out.printf("Average Marks        : %.2f%n", averageMarks);
            System.out.printf("Highest Marks        : %.2f%n", highestMarks);
System.out.printf("Lowest Marks         : %.2f%n", lowestMarks);

            System.out.println("=========================================");

            studentRs.close();
            courseRs.close();
            gradeRs.close();
            averageRs.close();

            studentPst.close();
            coursePst.close();
            gradePst.close();
            averagePst.close();
performanceRs.close();
performancePst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("\n❌ Failed to load dashboard.");
            e.printStackTrace();
        }
    }
}